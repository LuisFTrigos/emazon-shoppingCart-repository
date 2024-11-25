package com.example.emazon_shopping_cart.domain.api;

import com.example.emazon_shopping_cart.domain.model.CartItemModel;
import com.example.emazon_shopping_cart.domain.model.CartModel;

import java.util.Optional;

public interface CartServicePort {

    CartModel createShoppingCart(CartModel cartModel);
    CartModel addItemToCart(CartItemModel cartItemModel);
    Optional<CartModel> obtainCartByUser();
    CartModel deleteItemToCart(CartItemModel cartItemModel);
}
