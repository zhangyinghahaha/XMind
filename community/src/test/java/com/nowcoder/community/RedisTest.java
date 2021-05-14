package com.nowcoder.community;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.*;

@SpringBootTest
public class RedisTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testString() {
        String redisKey = "test:count";
        redisTemplate.opsForValue().set(redisKey, 1);
        System.out.println(redisTemplate.opsForValue().get(redisKey));
    }

    @Test
    public void testHash() {
        String redisKey = "test:user";
        redisTemplate.opsForHash().put(redisKey, "id", 1);
        redisTemplate.opsForHash().put(redisKey, "name", "zhangsan");

        System.out.println(redisTemplate.opsForHash().get(redisKey, "name"));
    }

    @Test
    public void testList() {
        String key = "test:ids";

        redisTemplate.opsForList().leftPush(key, 101);
        redisTemplate.opsForList().leftPush(key, 102);
        redisTemplate.opsForList().leftPush(key, 103);
    }

    @Test
    public void testSortedSet() {
        String key = "test:student";

        redisTemplate.opsForZSet().add(key, "1", 10);
        redisTemplate.opsForZSet().add(key, "2", 12);
        redisTemplate.opsForZSet().add(key, "3", 13);
        redisTemplate.opsForZSet().add(key, "4", 14);
        redisTemplate.opsForZSet().add(key, "5", 15);

        System.out.println(redisTemplate.opsForZSet().zCard(key));
    }

    @Test
    public void testKeys() {
        redisTemplate.delete("test:user");
        System.out.println(redisTemplate.hasKey("test:user"));
    }

    @Test
    public void testBoundOperations() {
        String key = "test:count";
        BoundValueOperations operations = redisTemplate.boundValueOps(key);
        operations.increment();
        System.out.println(operations.get());
    }

    @Test
    public void testTransactional() {
        Object obj = redisTemplate.execute(new SessionCallback() {
            @Override
            public Object execute(RedisOperations redisOperations) throws DataAccessException {
                String key = "test:tx";
                redisOperations.multi();
                redisOperations.opsForSet().add(key, "zhang");
                System.out.println(redisOperations.opsForSet().members(key));

                return redisOperations.exec();
            }
        });

        System.out.println(obj);
    }
}
