package com.saucedemo;

import com.saucedemo.data.Password;
import com.saucedemo.data.UserName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LoginTest extends BaseTest {

    @ValueSource(strings = {
        "standard_user",
        "problem_user",
        "performance_glitch_user",
        "error_user",
        "visual_user",
    })
    @ParameterizedTest
    @Tag("POSITIVE")
    @Tag("SMOKE")
    @DisplayName("Successful authorization test with valid credentials")
    public void successfulAuthorizationTest(String validUserName) {

        loginPage.login(validUserName, Password.SECRET_SAUCE.toString().toLowerCase());
        productsPage.checkThatProductsPageIsOpen();
    }

    @EnumSource(UserName.class)
    @ParameterizedTest
    @Tag("POSITIVE")
    @Tag("SMOKE")
    @DisplayName("Successful authorization test with valid credentials")
    public void successfulAuthorizationViaEnumSourceTest(UserName validUserName) {

        loginPage.login(validUserName.name().toLowerCase(), Password.SECRET_SAUCE.toString().toLowerCase());
        productsPage.checkThatProductsPageIsOpen();
    }

    @CsvSource(value = {
            "invalid_user,secret_sauce",
            "standard_user,invalid_password",
            "invalid_user,invalid_password"
    })
    @ParameterizedTest
    @Tag("NEGATIVE")
    @Tag("SMOKE")
    @DisplayName("Unsuccessful authorization test with invalid credentials (userName or password)")
    public void unSuccessfulAuthorizationTest() {

        loginPage.login("wrong_user", Password.SECRET_SAUCE.toString().toLowerCase());
        loginPage.checkErrorMessageAboutUnsuccessfulLoginIsShown();
    }
}
