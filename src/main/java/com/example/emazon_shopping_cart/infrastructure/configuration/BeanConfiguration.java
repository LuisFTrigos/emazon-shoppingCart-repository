package com.example.emazon_shopping_cart.infrastructure.configuration;

import com.example.emazon_shopping_cart.domain.api.CartServicePort;
import com.example.emazon_shopping_cart.domain.spi.AuthenticationTokenPort;
import com.example.emazon_shopping_cart.domain.spi.ICartPersistencePort;
import com.example.emazon_shopping_cart.domain.usecase.CartUseCase;
import com.example.emazon_shopping_cart.infrastructure.feing.UserFeingSupply;
import com.example.emazon_shopping_cart.infrastructure.feing.configuration.FeingClientConfig;
import com.example.emazon_shopping_cart.infrastructure.out.adapter.CartJpaAdapter;
import com.example.emazon_shopping_cart.infrastructure.out.mapper.CartEntityMapper;
import com.example.emazon_shopping_cart.infrastructure.out.repository.CartJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor

public class BeanConfiguration {

    private final CartJpaRepository cartJpaRepository;
    private final CartEntityMapper cartEntityMapper;
    private final AuthenticationTokenPort authenticationTokenPort;

    @Bean
    public CartServicePort cartServicePort() {
        return new CartUseCase(cartPersistencePort(), authenticationTokenPort, userFeingSupply());
    }

    @Bean
    public ICartPersistencePort cartPersistencePort(){
        return new CartJpaAdapter(cartJpaRepository, cartEntityMapper);
    }

    @Bean
    public UserFeingSupply userFeingSupply(){
        return new FeingClientConfig();
    }



}
