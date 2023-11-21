package com.saucedemo.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.saucedemo.data.ProductsSorting;

import java.util.List;

import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductsPage {

    private SelenideElement logo = $(".app_logo"),
            productSortingSelect = $(".product_sort_container"),
            cartBtn = $(".shopping_cart_link");
    private ElementsCollection allProducts = $$(".inventory_item_name");

    public void checkThatProductsPageIsOpen() {
        logo.shouldHave(Condition.exactText("Swag Labs"));
    }

    public void addProductToCart(String productName) {
        $(byTagAndText("div", productName))
                .ancestor(".inventory_item_description").$("button").click();
    }

    public void clickOnCart() {
        cartBtn.click();
    }

    public void selectSortingOptionForPage(ProductsSorting productsSorting) {
        productSortingSelect.selectOption(productsSorting.toString());
    }

    public void checkThatProductsOrderOnPageMatches(List<String> expectedSequenceOfProducts) {
        allProducts.shouldHave(CollectionCondition.exactTexts(expectedSequenceOfProducts));
    }
}
