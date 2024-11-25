package com.example.emazon_shopping_cart.infrastructure.security.jwt;

import com.example.emazon_shopping_cart.infrastructure.security.util.JwtUtil;
import com.example.emazon_shopping_cart.infrastructure.security.util.TokenUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthorizationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(@NotNull HttpServletRequest request,
                                    @NotNull HttpServletResponse response,
                                    @NotNull FilterChain filterChain
    ) throws ServletException, IOException {
        String bearerToken = request.getHeader("Authorization");

        if (bearerToken != null && bearerToken.startsWith("Bearer")) {
            String clientToken = bearerToken.substring(7);  // Extraer el clientToken eliminando "Bearer "

            if (SecurityContextHolder.getContext().getAuthentication() == null) {
                // Crear una autenticación basada en el ID del cliente extraído del token
                UsernamePasswordAuthenticationToken authentication = TokenUtils.getAuthenticationToken(clientToken);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
            filterChain.doFilter(request, response);
        }
    }
}
