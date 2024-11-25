package com.example.emazon_shopping_cart.infrastructure.out.mapper;

import com.example.emazon_shopping_cart.domain.model.CartModel;
import com.example.emazon_shopping_cart.infrastructure.out.entity.CartEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CartEntityMapper {

    CartEntity modelToEntity(CartModel cartModel);
    CartModel entityToModel(CartEntity cartEntity);

}
