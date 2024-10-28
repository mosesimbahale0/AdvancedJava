package com.kca.web.app;

public class CartItem {
    private String title;
    private int quantity;

    public CartItem(String title, int quantity) {
        this.title = title;
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
