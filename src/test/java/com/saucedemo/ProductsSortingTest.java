package com.saucedemo;

import com.saucedemo.data.ProductsSorting;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class ProductsSortingTest extends BaseTest {

    static Stream<Arguments> productsCanBeSortedCorrectly() {
        return Stream.of(
                Arguments.of(ProductsSorting.NAME_A_TO_Z, List.of("Sauce Labs Backpack", "Sauce Labs Bike Light",
                        "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)")),
                Arguments.of(ProductsSorting.NAME_TO_Z_A, List.of("Test.allTheThings() T-Shirt (Red)", "Sauce Labs Onesie",
                        "Sauce Labs Fleece Jacket", "Sauce Labs Bolt T-Shirt", "Sauce Labs Bike Light", "Sauce Labs Backpack"))
        );
    }

    @MethodSource
    @ParameterizedTest
    public void productsCanBeSortedCorrectly(ProductsSorting productsSorting, List<String> expectedSequenceOfProducts) {

        loginPage.loginWithDefaultCredentials();
        productsPage.checkThatProductsPageIsOpen();

        productsPage.selectSortingOptionForPage(productsSorting);

        productsPage.checkThatProductsOrderOnPageMatches(expectedSequenceOfProducts);
    }
}
