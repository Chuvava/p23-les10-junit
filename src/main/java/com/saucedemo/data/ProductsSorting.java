package com.saucedemo.data;

public enum ProductsSorting {
    NAME_A_TO_Z("Name (A to Z)"),
    NAME_TO_Z_A("Name (Z to A)"),
    PRICE_LOW_TO_HIGH("Price (low to high)"),
    PRICE_HIGH_TO_LOW("Price (high to low)");

    private final String value;

    private ProductsSorting(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
