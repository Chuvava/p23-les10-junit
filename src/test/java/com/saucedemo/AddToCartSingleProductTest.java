package com.saucedemo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class AddToCartSingleProductTest extends BaseTest {

    @AfterEach
    public void afterEach() {
        cartPage.removeSingleProductFromCart();
    }

    @CsvFileSource(resources = "/test_data/productsAndPrices.csv")
    @ParameterizedTest
    public void cartShowsCorrectProductNameAndPriceAfterAddingTest(String productName, String price) {

        loginPage.loginWithDefaultCredentials();
        productsPage.checkThatProductsPageIsOpen();

        productsPage.addProductToCart(productName);
        productsPage.clickOnCart();

        cartPage.checkProductName(productName);
        cartPage.checkProductPrice(price);
    }
}
