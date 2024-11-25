package com.example.emazon_shopping_cart.infrastructure.out.repository;

import com.example.emazon_shopping_cart.infrastructure.out.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartJpaRepository extends JpaRepository<CartEntity, Long> {

    boolean existsByUserId(Long userId);
    Optional<CartEntity> findByUserId(Long userId);
}
