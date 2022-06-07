package com.nowcoder.community;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.*;

import java.nio.charset.StandardCharsets;

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

    @Test
    public void testHyperLogLog() {
        String key = "test:hll:01";
        for (int i = 0; i < 100000; i++) {
            redisTemplate.opsForHyperLogLog().add(key, i);
        }
        for (int i = 0; i < 100000; i++) {
            redisTemplate.opsForHyperLogLog().add(key, i);
        }

        System.out.println(redisTemplate.opsForHyperLogLog().size(key));
    }

    @Test
    public void testHyperLogLogUnion() {
        String key2 = "test:hll:02";
        for (int i = 0; i < 10000; i++) {
            redisTemplate.opsForHyperLogLog().add(key2, i);
        }

        String key3 = "test:hll:03";
        for (int i = 5000; i < 15000; i++) {
            redisTemplate.opsForHyperLogLog().add(key3, i);
        }

        String key4 = "test:hll:04";
        for (int i = 10000; i < 20000; i++) {
            redisTemplate.opsForHyperLogLog().add(key4, i);
        }

        String unionKey = "test:hll:union";
        System.out.println(redisTemplate.opsForHyperLogLog().union(unionKey, key2, key3, key4));
        System.out.println(redisTemplate.opsForHyperLogLog().size(unionKey));
    }

    @Test
    public void testBitMap() {
        String key = "test:bm:01";

        redisTemplate.opsForValue().setBit(key, 0, true);
        redisTemplate.opsForValue().setBit(key, 4, true);
        redisTemplate.opsForValue().setBit(key, 6, true);
        redisTemplate.opsForValue().setBit(key, 9, true);
        redisTemplate.opsForValue().setBit(key, 12, true);

        System.out.println(redisTemplate.opsForValue().getBit(key, 1));
        System.out.println(redisTemplate.opsForValue().getBit(key, 9));
        redisTemplate.execute((RedisCallback) (connection) -> {
            long count = connection.bitCount(key.getBytes(StandardCharsets.UTF_8));
            System.out.println(count);
            return count;
        });
    }

    @Test
    public void testBitMapOperations() {
        String key = "test:bm:02";
        redisTemplate.opsForValue().setBit(key, 0 , true);
        redisTemplate.opsForValue().setBit(key, 1 , true);
        redisTemplate.opsForValue().setBit(key, 2 , true);

        String key2 = "test:bm:03";
        redisTemplate.opsForValue().setBit(key2, 3 , true);
        redisTemplate.opsForValue().setBit(key2, 4 , true);
        redisTemplate.opsForValue().setBit(key2, 5 , true);

        String or = "test:bm:or";
        redisTemplate.execute((RedisCallback) (connection) -> {
            connection.bitOp(RedisStringCommands.BitOperation.OR, or.getBytes(StandardCharsets.UTF_8), key.getBytes(StandardCharsets.UTF_8), key2.getBytes(StandardCharsets.UTF_8));
            System.out.println(connection.bitCount(or.getBytes(StandardCharsets.UTF_8)));
            System.out.println(or.getBytes(StandardCharsets.UTF_8));
            return connection.bitCount(or.getBytes(StandardCharsets.UTF_8));
        });
    }
}
