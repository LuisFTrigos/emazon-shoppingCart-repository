package com.example.emazon_shopping_cart.application.dto.request.feingDto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class AssociatedCategoriesGetRequestDto {

    private Long id;
    private String categoryName;
}
