package com.example.emazon_shopping_cart.infrastructure.security.jwt;

import com.example.emazon_shopping_cart.domain.spi.AuthenticationTokenPort;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static com.example.emazon_shopping_cart.domain.util.Constants.ACCESS_TOKEN_SECRET;

@Component
public class AuthenticationTokenAdapter implements AuthenticationTokenPort {


    @Override
    public Long getUserIdFromToken() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        String bearerToken = attributes.getRequest().getHeader("Authorization").substring(7);
        Claims claims = Jwts
                .parser()
                .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
                .parseClaimsJws(bearerToken)
                .getBody();
        return Long.valueOf((Integer)claims.get("userId"));
    }
}
