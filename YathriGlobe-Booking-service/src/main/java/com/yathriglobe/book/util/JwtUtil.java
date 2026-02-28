package com.yathriglobe.book.util;

import java.security.Key;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil 
{
	private final String SECRET = "yathriglobe_secret_key_which_is_very_secure_256bit";
	private Key key() {
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }

	
	public Claims getClaims(String token) 
    {
        return Jwts.parserBuilder()
                .setSigningKey(key())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String extractEmail(String token) 
    {
        return getClaims(token).getSubject();
    }
}
