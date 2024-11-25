package com.example.emazon_shopping_cart.application.mapper;

import com.example.emazon_shopping_cart.application.dto.request.CartRequestDto;
import com.example.emazon_shopping_cart.domain.model.CartModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CartDtoMapper {

    CartRequestDto modelToDto(CartModel cartModel);
    CartModel dtoToModel(CartRequestDto cartRequestDto);


}
