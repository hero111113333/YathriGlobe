package com.yathriglobe.authservice.util;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil 
{
	private final String SECRET_KEY="yathriglobe_secret_key_which_is_very_secure_256bit";
	private final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
	private final long EXPIRATION = 1000 * 60 * 60; // 1 hour
	
	
	public String generateToken(String email,String role)
	{
		return Jwts.builder()
				.setSubject(email)
				.claim("role", role)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
				.signWith(key, SignatureAlgorithm.HS256)
				.compact();
	}
	
	
	public String extractEmail(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
