package com.example.emazon_shopping_cart.domain.spi;

import com.example.emazon_shopping_cart.domain.model.CartModel;

import java.util.Optional;

public interface ICartPersistencePort {

    CartModel createShoppingCart(CartModel cartModel);
    Optional<CartModel> findByUserId(Long userId);
    boolean existsByUserId(Long userId);

}
