package com.example.emazon_shopping_cart.domain.usecase;

import com.example.emazon_shopping_cart.application.dto.request.feingDto.GetSuppliesRequestDto;
import com.example.emazon_shopping_cart.domain.api.CartServicePort;
import com.example.emazon_shopping_cart.domain.exception.CartAlreadyExistsException;
import com.example.emazon_shopping_cart.domain.model.CartItemModel;
import com.example.emazon_shopping_cart.domain.model.CartModel;
import com.example.emazon_shopping_cart.domain.spi.AuthenticationTokenPort;
import com.example.emazon_shopping_cart.domain.spi.ICartPersistencePort;
import com.example.emazon_shopping_cart.infrastructure.feing.UserFeingSupply;

import java.util.List;
import java.util.Optional;

import static com.example.emazon_shopping_cart.domain.util.Constants.CART_ALREADY_EXISTS;

public class CartUseCase implements CartServicePort {

    private final ICartPersistencePort cartPersistencePort;
    private final AuthenticationTokenPort authenticationTokenPort;
    private final UserFeingSupply userFeingSupply;

    public CartUseCase(ICartPersistencePort cartPersistencePort, AuthenticationTokenPort authenticationTokenPort, UserFeingSupply userFeingSupply) {
        this.cartPersistencePort = cartPersistencePort;
        this.authenticationTokenPort = authenticationTokenPort;
        this.userFeingSupply = userFeingSupply;
    }

    @Override
    public CartModel createShoppingCart(CartModel cartModel) {
        cartModel.setUserId(cartModel.getUserId());
        if(cartPersistencePort.existsByUserId(cartModel.getUserId())) {
            throw new CartAlreadyExistsException(CART_ALREADY_EXISTS + cartModel.getUserId());
        }
        return cartPersistencePort.createShoppingCart(cartModel);
    }

    public void get(){
        List<GetSuppliesRequestDto> suppliesList = userFeingSupply.getAllSupplies();
        System.out.println(suppliesList);
    }

    @Override
    public CartModel addItemToCart(CartItemModel cartItemModel) {
        Optional<CartModel> cartOpt = cartPersistencePort.findByUserId(cartItemModel.getId());

        CartModel cartModel = cartOpt.orElseGet(() -> createShoppingCart(new CartModel()));

        CartItemModel itemModel = new CartItemModel();
        itemModel.setItemId(itemModel.getItemId());
        itemModel.setAmount(itemModel.getAmount());
        itemModel.setId(itemModel.getId());

        cartModel.getItems().add(itemModel);
        return cartPersistencePort.createShoppingCart(cartModel); //REVISAR
    }

    @Override
    public Optional<CartModel> obtainCartByUser() {
        return cartPersistencePort.findByUserId(authenticationTokenPort.getUserIdFromToken());
    }

    @Override
    public CartModel deleteItemToCart(CartItemModel cartItemModel) {
        Optional<CartModel> carritoOpt = cartPersistencePort.findByUserId(cartItemModel.getId());
        if (carritoOpt.isPresent()) {
            CartModel cartModel = carritoOpt.get();
            cartModel.getItems().removeIf(item -> item.getItemId().equals(cartItemModel));
            return cartPersistencePort.createShoppingCart(cartModel);
        }
        return null;
    }

}
