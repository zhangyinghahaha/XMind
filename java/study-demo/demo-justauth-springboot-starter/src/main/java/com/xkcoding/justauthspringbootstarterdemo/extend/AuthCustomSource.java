package com.xkcoding.justauthspringbootstarterdemo.extend;

import me.zhyd.oauth.config.AuthSource;

/**
 * 自定义OAuth认证平台
 * @author ying.zhang01
 */
public enum AuthCustomSource implements AuthSource {
    /**
     * UAP
     */
    UAP_DEV {
        @Override
        public String authorize() {
            return "https://auth-admin-dev-api.uihcloud.cn/v4/connect/authorize";
        }

        @Override
        public String accessToken() {
            return "https://auth-admin-dev-api.uihcloud.cn/v4/connect/token";
        }

        @Override
        public String userInfo() {
            return "https://auth-admin-dev-api.uihcloud.cn/v4/connect/userinfo";
        }

        @Override
        public String revoke() {
            return "https://auth-admin-dev-api.uihcloud.cn/v4/connect/logout";
        }

        @Override
        public String refresh() {
            return "https://auth-admin-dev-api.uihcloud.cn/v4/connect/token";
        }
    }
}
