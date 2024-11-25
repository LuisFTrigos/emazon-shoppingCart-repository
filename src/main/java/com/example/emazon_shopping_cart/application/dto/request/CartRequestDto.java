package com.example.emazon_shopping_cart.application.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartRequestDto {

    @NotNull(message = "The field name cannot null")
    @NotEmpty(message = "The field name cannot empty")
    private Long id;

    @NotNull(message = "The field name cannot null")
    @NotEmpty(message = "The field name cannot empty")
    private Long userId;

    private List<String> cartItems;
}
