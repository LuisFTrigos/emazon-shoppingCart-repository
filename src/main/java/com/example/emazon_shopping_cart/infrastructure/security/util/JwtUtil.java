package com.example.emazon_shopping_cart.infrastructure.security.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    private String SECRET_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXvCJ9";

    public Long extractClientId(String token) {
        Claims claims = extractAllClaims(token);
        return (Long) claims.get("userId");
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }


}
