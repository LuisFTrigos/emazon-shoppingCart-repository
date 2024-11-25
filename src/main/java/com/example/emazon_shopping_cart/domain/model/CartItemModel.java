package com.example.emazon_shopping_cart.domain.model;

public class CartItemModel {

    private Long id;

    private Long itemId;

    private int amount;

    public CartItemModel(Long id, Long itemId, int amount) {
        this.id = id;
        this.itemId = itemId;
        this.amount = amount;
    }

    public CartItemModel() {

    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
