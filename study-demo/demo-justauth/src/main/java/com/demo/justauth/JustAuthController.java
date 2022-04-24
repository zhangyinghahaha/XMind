package com.demo.justauth;

import com.demo.justauth.uap.AuthUapRequest;
import me.zhyd.oauth.config.AuthConfig;
import me.zhyd.oauth.exception.AuthException;
import me.zhyd.oauth.model.AuthCallback;
import me.zhyd.oauth.request.AuthGiteeRequest;
import me.zhyd.oauth.request.AuthRequest;
import me.zhyd.oauth.utils.AuthStateUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ying.zhang01
 */
@RestController
public class JustAuthController {
    public static final String DOMAIN = "https://auth-admin-dev-api.uihcloud.cn/v4";

    /**
     * 获取授权链接并跳转到第三方授权页面
     *
     * @param response response
     * @throws IOException response可能存在的异常
     */
    @RequestMapping("/oauth/render/{source}")
    public void renderAuth(@PathVariable String source, HttpServletResponse response) throws IOException {
        AuthRequest authRequest = getAuthRequest(source);
        String authorizeUrl = authRequest.authorize(AuthStateUtils.createState());
        response.sendRedirect(authorizeUrl);
    }

    /**
     * 用户在确认第三方平台授权（登录）后， 第三方平台会重定向到该地址，并携带code、state等参数
     *
     * @param callback 第三方回调时的入参
     * @return 第三方平台的用户信息
     */
    @RequestMapping("/oauth/callback/{source}")
    public Object login(@PathVariable String source, AuthCallback callback) {
        AuthRequest authRequest = getAuthRequest(source);
        return authRequest.login(callback);
    }

    /**
     * 获取授权Request
     * @param source
     * @return
     */
    private AuthRequest getAuthRequest(String source) {
        AuthRequest authRequest = null;
        switch (source) {
            case "gitee":
                authRequest = new AuthGiteeRequest(AuthConfig.builder()
                        .clientId("f5cc7e2a7d204c953c9c0a793de45faa4648f96d1a47b90847c52b295de901c0")
                        .clientSecret("1161bef89e456c8385db313e3de40e014d1d59c8729cd2c7ff74cfd5082532e5")
                        .redirectUri("http://localhost:9000/oauth/callback/gitee")
                        .build());
                break;
            case "uap":
                authRequest = new AuthUapRequest(AuthConfig.builder()
                        .clientId("ZcELFz6XnHrVDy46")
                        .clientSecret("ac8e43e0db655acbc297220d37ecc3f57291de1614b312cf884a8cf97e5cf412")
                        .redirectUri("http://localhost:9000/oauth/callback/uap")
                        .build());
                break;
            default:
                break;
        }
        if (null == authRequest) {
            throw new AuthException("未获取到有效的Auth配置");
        }
        return authRequest;
    }
}