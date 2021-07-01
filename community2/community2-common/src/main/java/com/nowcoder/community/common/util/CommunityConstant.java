package com.nowcoder.community.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ying.zhang01
 */
public interface CommunityConstant {
    int ACTIVATION_SUCCESS = 0;
    int ACTIVATION_REPEAT = 1;
    int ACTIVATION_FAILED = 2;
    /**
     * 默认登录凭证超时时间
     */
    int DEFAULT_EXPIRED_SECONDS = 3600*12;
    int REMEMBER_EXPIRED_SECONDS = 3600*12*7;

    int ENTITY_TYPE_POST = 1;
    int ENTITY_TYPE_COMMENT = 2;
    int ENTITY_TYPE_USER = 3;

    /**
     * 权限：普通用户
     */
    String AUTHORITY_USER = "user";
    /**
     * 权限：管理员
     */
    String AUTHORITY_ADMIN = "admin";
    /**
     * 权限：版主
     */
    String AUTHORITY_MODERATOR = "moderator";
}
