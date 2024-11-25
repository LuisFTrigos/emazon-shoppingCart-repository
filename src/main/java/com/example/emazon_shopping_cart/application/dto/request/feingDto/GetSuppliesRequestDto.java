package com.example.emazon_shopping_cart.application.dto.request.feingDto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class GetSuppliesRequestDto {

    private long id;
    private String supplyName;
    private String supplyDescription;
    private List<AssociatedCategoriesGetRequestDto> associatedCategories;
    private long supplyAmount;
    private long supplyPrice;

}
