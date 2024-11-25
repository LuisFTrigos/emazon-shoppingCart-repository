package com.example.emazon_shopping_cart.application.handler;

import com.example.emazon_shopping_cart.application.dto.request.CartItemsRequestDto;
import com.example.emazon_shopping_cart.application.dto.request.CartRequestDto;
import com.example.emazon_shopping_cart.application.dto.response.CartResponse;
import com.example.emazon_shopping_cart.domain.model.CartModel;

import java.util.Optional;

public interface ICartHandler {

    CartResponse createShoppingCart (CartRequestDto cartRequestDto);
    CartResponse addItemToCart(CartItemsRequestDto cartItemsRequestDto);
    Optional<CartModel> obtainCartByUserId();
    CartResponse deleteItemToCart(CartItemsRequestDto cartItemsRequestDto);


}
