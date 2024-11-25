package com.example.emazon_shopping_cart.infrastructure.in.rest;

import com.example.emazon_shopping_cart.application.dto.request.CartItemsRequestDto;
import com.example.emazon_shopping_cart.application.dto.response.CartResponse;
import com.example.emazon_shopping_cart.application.handler.ICartHandler;
import com.example.emazon_shopping_cart.domain.model.CartModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/shoppingCart")
public class CartController {

    private final ICartHandler cartHandler;

    @PostMapping("/add")
    public ResponseEntity<CartResponse> addItem(@RequestParam CartItemsRequestDto cartItemsRequestDto) {
        CartResponse cartResponse = cartHandler.addItemToCart(cartItemsRequestDto);
        return ResponseEntity.ok(cartResponse);
    }

    @Secured({"ADMIN"})
    @GetMapping("/items")
    public ResponseEntity<Optional<CartModel>> getCartItems() {
            Optional<CartModel> cartItems = cartHandler.obtainCartByUserId();

        return ResponseEntity.ok(cartItems);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<CartResponse> deleteItem(@RequestParam CartItemsRequestDto cartItemsRequestDto) {
        CartResponse cartResponse = cartHandler.deleteItemToCart(cartItemsRequestDto);
        if (cartResponse != null) {
            return ResponseEntity.ok(cartResponse);
        }
        return ResponseEntity.notFound().build();
    }
}
