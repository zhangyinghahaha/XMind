package com.nowcoder.community.service;

import com.nowcoder.community.common.util.RedisKeyUtil;
import com.nowcoder.community.common.util.RsaKey;
import com.nowcoder.community.common.util.RsaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author ying.zhang01
 */
@Service
public class RsaKeyService {
    @Autowired
    private RedisTemplate redisTemplate;

    public String getPublicKey(String username) {
        String rsaKeyPairKey = RedisKeyUtil.getRsaKeyPairKey(username);
        RsaKey rsaKeyPair = (RsaKey) redisTemplate.opsForValue().get(rsaKeyPairKey);
        if (rsaKeyPair == null) {
            rsaKeyPair = initKeyPair(username);
        }
        return rsaKeyPair.getPublicKey();
    }

    public String getPrivateKey(String username) {
        String rsaKeyPairKey = RedisKeyUtil.getRsaKeyPairKey(username);
        RsaKey rsaKeyPair = (RsaKey) redisTemplate.opsForValue().get(rsaKeyPairKey);
        if (rsaKeyPair == null) {
            throw new RuntimeException("用户密钥过期");
        }
        return rsaKeyPair.getPrivateKey();
    }

    public void deleteKeyPair(String username) {
        String rsaKeyPairKey = RedisKeyUtil.getRsaKeyPairKey(username);
        redisTemplate.delete(rsaKeyPairKey);
    }

    private RsaKey initKeyPair(String username) {
        String rsaKeyPairKey = RedisKeyUtil.getRsaKeyPairKey(username);
        RsaKey rsaKey = RsaUtil.createKeys();
        redisTemplate.opsForValue().set(rsaKeyPairKey, rsaKey, 30*60, TimeUnit.SECONDS);
        return rsaKey;
    }
}
