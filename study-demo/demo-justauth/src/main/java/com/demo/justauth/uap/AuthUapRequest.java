package com.demo.justauth.uap;

import com.alibaba.fastjson.JSONObject;
import com.xkcoding.http.support.HttpHeader;
import me.zhyd.oauth.cache.AuthStateCache;
import me.zhyd.oauth.config.AuthConfig;
import me.zhyd.oauth.exception.AuthException;
import me.zhyd.oauth.model.AuthCallback;
import me.zhyd.oauth.model.AuthToken;
import me.zhyd.oauth.model.AuthUser;
import me.zhyd.oauth.request.AuthDefaultRequest;
import me.zhyd.oauth.utils.HttpUtils;
import me.zhyd.oauth.utils.UrlBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * Uap Auth Request
 * @author ying.zhang01
 */
public class AuthUapRequest extends AuthDefaultRequest {
    public AuthUapRequest(AuthConfig config) {
        super(config, AuthCustomSource.UAP);
    }

    public AuthUapRequest(AuthConfig config, AuthStateCache authStateCache) {
        super(config, AuthCustomSource.UAP, authStateCache);
    }

    @Override
    protected AuthToken getAccessToken(AuthCallback authCallback) {
        String response = doPostAuthorizationCode(authCallback.getCode());
        JSONObject accessTokenObject = JSONObject.parseObject(response);
        this.checkResponse(accessTokenObject);
        return AuthToken.builder()
                .accessToken(accessTokenObject.getString("access_token"))
                .refreshToken(accessTokenObject.getString("refresh_token"))
                .tokenType(accessTokenObject.getString("token_type"))
                .expireIn(accessTokenObject.getIntValue("expires_in"))
                .build();
    }

    @Override
    protected AuthUser getUserInfo(AuthToken authToken) {
        String userInfo = doGetUserInfo(authToken);
        JSONObject object = JSONObject.parseObject(userInfo);
        this.checkResponse(object);
        return AuthUser.builder()
                .rawUserInfo(object)
                .uuid(object.getString("uid"))
                .username(object.getString("userLoginId"))
                .nickname(object.getString("name"))
                .email(object.getString("userEmail"))
                .token(authToken)
                .source(source.toString())
                .build();
    }

    @Override
    public String authorize(String state) {
        return UrlBuilder.fromBaseUrl(super.authorize(state))
                .queryParam("scope", "openid")
                .build();
    }

    @Override
    protected String doPostAuthorizationCode(String code) {
        HttpUtils httpUtils = new HttpUtils(config.getHttpConfig());
        HttpHeader header = new HttpHeader();
        header.add("Content-Type", "application/x-www-form-urlencoded");

        Map<String, String> params = new HashMap<>(5);
        params.put("code", code);
        params.put("client_id", config.getClientId());
        params.put("client_secret", config.getClientSecret());
        params.put("grant_type", "authorization_code");
        params.put("redirect_uri", config.getRedirectUri());

        String response = httpUtils.post(accessTokenUrl(code), params, header,true).getBody();
        return response;
    }

    @Override
    protected String accessTokenUrl(String code) {
        return UrlBuilder.fromBaseUrl(source.accessToken()).build();
    }

    @Override
    protected String doGetUserInfo(AuthToken authToken) {
        String token = String.format("%s %s", authToken.getTokenType(), authToken.getAccessToken());

        HttpUtils httpUtils = new HttpUtils(config.getHttpConfig());
        HttpHeader header = new HttpHeader();
        header.add("Authorization", token);

        String response = httpUtils.get(userInfoUrl(authToken), null, header, false).getBody();
        return response;
    }

    @Override
    protected String userInfoUrl(AuthToken authToken) {
        return UrlBuilder.fromBaseUrl(source.userInfo()).build();
    }

    private void checkResponse(JSONObject object) {
        if (object.containsKey("error")) {
            throw new AuthException(object.getString("error_description"));
        }
    }
}
