package com.example.emazon_shopping_cart.domain.model;

import java.util.List;

public class CartModel {

    private Long id;

    private List<CartItemModel> items;

    private Long userId;

    public CartModel(Long id, List<CartItemModel> items, Long userId) {
        this.id = id;
        this.items = items;
        this.userId = userId;
    }

    public CartModel() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CartItemModel> getItems() {
        return items;
    }

    public void setItems(List<CartItemModel> items) {
        this.items = items;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
