package com.demo.justauth.uap;

import com.demo.justauth.JustAuthController;
import me.zhyd.oauth.config.AuthSource;
import me.zhyd.oauth.request.AuthDefaultRequest;

/**
 * 自定义的OAuth认证平台
 * @author ying.zhang01
 */
public enum AuthCustomSource implements AuthSource {
    /**
     * UAP
     */
    UAP {
        @Override
        public String authorize() {
            return JustAuthController.DOMAIN + "/connect/authorize";
        }

        @Override
        public String accessToken() {
            return JustAuthController.DOMAIN + "/connect/token";
        }

        @Override
        public String userInfo() {
            return JustAuthController.DOMAIN + "/connect/userinfo";
        }

        @Override
        public String revoke() {
            return JustAuthController.DOMAIN + "/connect/logout";
        }

        @Override
        public String refresh() {
            return JustAuthController.DOMAIN + "/connect/token";
        }

        @Override
        public Class<? extends AuthDefaultRequest> getTargetClass() {
            return AuthUapRequest.class;
        }
    }
}
