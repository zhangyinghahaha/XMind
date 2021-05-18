package com.nowcoder.community.util;

/**
 * @author ying.zhang01
 */
public class RedisKeyUtil {
    public static final String SPLIT = ":";
    private static final String PREFIX_ENTITY_LIKE = "like:entity";

    /**
     * like:entity:entityType:entityId -> set(userId)
     * @param entityType
     * @param entityId
     * @return
     */
    public static String getEntityLikeKey(int entityType, int entityId) {
        return PREFIX_ENTITY_LIKE + SPLIT + entityType + SPLIT + entityId;
    }
}
