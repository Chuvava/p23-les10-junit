package com.saucedemo.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {

    private SelenideElement productName = $(".inventory_item_name"),
            price = $(".inventory_item_price"),
            removeBtn = $(byTagAndText("button", "Remove"));

    public void checkProductName(String value) {
        productName.shouldHave(Condition.text(value));
    }

    public void checkProductPrice(String value) {
        price.shouldHave(Condition.text(value));
    }

    public void removeSingleProductFromCart() {
        removeBtn.click();
    }
}
