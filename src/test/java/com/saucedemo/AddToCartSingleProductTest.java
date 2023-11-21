package com.saucedemo;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;

public class AddToCartSingleProductTest extends BaseTest {

    @AfterEach
    public void afterEach() {
        $(byTagAndText("button", "Remove")).click();
    }

    @CsvFileSource(resources = "/test_data/productsAndPrices.csv")
    @ParameterizedTest
    public void cartShowsCorrectProductNameAndPriceAfterAddingTest(String productName, String price) {

        loginWithDefaultCredentials();
        checkThatUserIsLoggedIn();

        $(byTagAndText("div", productName))
                .ancestor(".inventory_item_description").$("button").click();

        $(".shopping_cart_link").click();

        $(".inventory_item_name").shouldHave(Condition.text(productName));
        $(".inventory_item_price").shouldHave(Condition.partialText(price));
    }
}
