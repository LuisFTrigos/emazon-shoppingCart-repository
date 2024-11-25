package com.example.emazon_shopping_cart.infrastructure.feing;

import com.example.emazon_shopping_cart.application.dto.request.feingDto.GetSuppliesRequestDto;
import com.example.emazon_shopping_cart.infrastructure.feing.configuration.FeingClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "tienda_emazon", url = "http://localhost:9090/api/supply", configuration = FeingClientConfig.class)
public interface UserFeingSupply {

    @GetMapping
    List getSupplies();

    @GetMapping("/supplies")
    List<GetSuppliesRequestDto> getAllSupplies();
}
