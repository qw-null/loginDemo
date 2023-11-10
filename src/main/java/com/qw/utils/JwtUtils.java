package com.qw.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtils {
    // 7天过期
    private static long expire = 604800;
    // 32位密钥
    private static String secret = "qwertyuiopasdfghjklzxcvbnm123456";

    // 生成token
    public static String generateToken(String username){
        Date now = new Date();
        Date expiration = new Date(now.getTime() + 1000 * expire);
        return Jwts.builder()
                .setHeaderParam("type","JWT")
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256,secret)
                .compact();
    }

    // 解析token
    public static Claims getClaimsByToken(String token){
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJwt(token)
                .getBody();
    }
}
