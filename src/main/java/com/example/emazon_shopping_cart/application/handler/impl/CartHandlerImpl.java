package com.example.emazon_shopping_cart.application.handler.impl;

import com.example.emazon_shopping_cart.application.dto.request.CartItemsRequestDto;
import com.example.emazon_shopping_cart.application.dto.request.CartRequestDto;
import com.example.emazon_shopping_cart.application.dto.response.CartResponse;
import com.example.emazon_shopping_cart.application.handler.ICartHandler;
import com.example.emazon_shopping_cart.application.mapper.CartDtoMapper;
import com.example.emazon_shopping_cart.domain.api.CartServicePort;
import com.example.emazon_shopping_cart.domain.model.CartModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

import static com.example.emazon_shopping_cart.domain.util.Constants.*;

@Service
@RequiredArgsConstructor
public class CartHandlerImpl implements ICartHandler {

    private final CartServicePort cartServicePort;
    private final CartDtoMapper cartDtoMapper;

    @Override
    public CartResponse createShoppingCart(CartRequestDto cartRequestDto){
        cartServicePort.createShoppingCart(cartDtoMapper.dtoToModel(cartRequestDto));
        return CartResponse.builder()
                .message(CART_CREATE)
                .date(LocalDate.now())
                .build();
    }

    @Override
    public CartResponse addItemToCart(CartItemsRequestDto cartItemsRequestDto) {
        return CartResponse.builder()
                .message(CORRECT_ADD_CART + cartItemsRequestDto)
                .date(LocalDate.now())
                .build();
    }

    @Override
    public Optional<CartModel> obtainCartByUserId() {
        return cartServicePort.obtainCartByUser();
    }

    @Override
    public CartResponse deleteItemToCart(CartItemsRequestDto cartItemsRequestDto) {
        return CartResponse.builder()
                .message(CORRECT_DELETE_CART + cartItemsRequestDto )
                .date(LocalDate.now())
                .build();
    }
}
