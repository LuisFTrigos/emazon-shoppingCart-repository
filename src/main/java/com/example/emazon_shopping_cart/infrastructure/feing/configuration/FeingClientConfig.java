package com.example.emazon_shopping_cart.infrastructure.feing.configuration;

import com.example.emazon_shopping_cart.application.dto.request.feingDto.GetSuppliesRequestDto;
import com.example.emazon_shopping_cart.infrastructure.feing.UserFeingSupply;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Configuration
@Component
public class FeingClientConfig implements UserFeingSupply {

    @Override
    public List getSupplies() {
        return List.of();
    }

    @Override
    public List<GetSuppliesRequestDto> getAllSupplies() {
        return List.of();
    }
}
