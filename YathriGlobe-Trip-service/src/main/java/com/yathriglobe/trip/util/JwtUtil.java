package com.yathriglobe.trip.util;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil 
{
	@Value("${jwt.secret}")
    private String secret;

    private Key key() {
        return Keys.hmacShaKeyFor(secret.getBytes());
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
    
    public boolean isTokenExpired(String token) {
        return getClaims(token).getExpiration().before(new Date());
    }
}
