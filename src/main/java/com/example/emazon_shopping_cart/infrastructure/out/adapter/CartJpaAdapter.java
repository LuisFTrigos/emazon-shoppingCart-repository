package com.example.emazon_shopping_cart.infrastructure.out.adapter;

import com.example.emazon_shopping_cart.domain.model.CartModel;
import com.example.emazon_shopping_cart.domain.spi.ICartPersistencePort;
import com.example.emazon_shopping_cart.infrastructure.out.entity.CartEntity;
import com.example.emazon_shopping_cart.infrastructure.out.mapper.CartEntityMapper;
import com.example.emazon_shopping_cart.infrastructure.out.repository.CartJpaRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class CartJpaAdapter implements ICartPersistencePort {

    private final CartJpaRepository cartJpaRepository;
    private final CartEntityMapper cartEntityMapper;

    @Override
    public boolean existsByUserId(Long userId) {
        return cartJpaRepository.existsByUserId(userId);
    }

    @Override
    public CartModel createShoppingCart(CartModel cartModel) {
        CartEntity cartEntity = cartEntityMapper.modelToEntity(cartModel);
        cartEntity = cartJpaRepository.save(cartEntity);
        return cartEntityMapper.entityToModel(cartEntity);
    }

    @Override
    public Optional<CartModel> findByUserId(Long userId) {
        return cartJpaRepository.findByUserId(userId).map(cartEntityMapper::entityToModel);
    }


}
