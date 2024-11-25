package com.example.emazon_shopping_cart.application.dto.response;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartResponse {

    private String message;
    private LocalDate date;


}
