package com.nowcoder.community.service;

import com.nowcoder.community.util.RedisKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author zhangying
 */
@Service
public class DataService {
    @Autowired
    private RedisTemplate redisTemplate;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

    public void recordUV(String ip) {
        String redisKey = RedisKeyUtil.getUVKey(dateFormat.format(new Date()));
        redisTemplate.opsForHyperLogLog().add(redisKey, ip);
    }

    public long calculateUV(Date startDate, Date endDate) {
        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException("参数不能为空");
        }
        // 整理日期范围内的key
        List<String> keys = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        while (!calendar.getTime().after(endDate)) {
            keys.add(dateFormat.format(calendar.getTime()));
            calendar.add(Calendar.DATE, 1);
        }

        // 合并
        String redisKey = RedisKeyUtil.getUVKey(dateFormat.format(startDate), dateFormat.format(endDate));
        redisTemplate.opsForHyperLogLog().union(redisKey, keys.toArray());

        return  redisTemplate.opsForHyperLogLog().size(redisKey);
    }

    public void recordDAU(int userId) {
        String redisKey = RedisKeyUtil.getDAUKey(dateFormat.format(new Date()));
        redisTemplate.opsForValue().setBit(redisKey, userId, true);
    }

    public long calculateDAU(Date startDate, Date endDate) {
        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException("参数不能为空");
        }
        // 整理日期范围内的key
        List<byte[]> keys = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        while (!calendar.getTime().after(endDate)) {
            String key = RedisKeyUtil.getDAUKey(dateFormat.format(calendar.getTime()));
            keys.add(key.getBytes(StandardCharsets.UTF_8));
            calendar.add(Calendar.DATE, 1);
        }

        return (long)redisTemplate.execute((RedisCallback) (connection) -> {
            String redisKey = RedisKeyUtil.getDAUKey(dateFormat.format(startDate), dateFormat.format(endDate));
            connection.bitOp(
                    RedisStringCommands.BitOperation.OR,
                    redisKey.getBytes(StandardCharsets.UTF_8),
                    keys.toArray(new byte[0][0])
            );
            return connection.bitCount(redisKey.getBytes(StandardCharsets.UTF_8));
        });
    }

}
