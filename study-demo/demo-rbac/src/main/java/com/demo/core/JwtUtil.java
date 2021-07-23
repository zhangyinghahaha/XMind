package com.demo.core;

import io.jsonwebtoken.*;
import org.apache.commons.lang3.StringUtils;

import java.time.Duration;
import java.util.Date;

/**
 * @author ying.zhang01
 */
public class JwtUtil {
    private final static String secretKey = "hello";
    private final static Duration expiration = Duration.ofMinutes(30);

    public static String generate(String username) {
        Date expireDate = new Date(System.currentTimeMillis() + expiration.toMillis());
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    public static Claims parse(String token) {
        if (StringUtils.isBlank(token)) {
            return null;
        }

        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (JwtException jwtException) {
            System.out.println("JWT解析失败");
        }

        return claims;
    }
}
