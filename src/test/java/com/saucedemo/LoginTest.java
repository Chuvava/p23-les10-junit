package com.saucedemo;

import com.codeborne.selenide.Condition;
import com.saucedemo.data.UserName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.$;

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

        login(validUserName, "secret_sauce");
        checkThatUserIsLoggedIn();
    }

    @EnumSource(UserName.class)
    @ParameterizedTest
    @Tag("POSITIVE")
    @Tag("SMOKE")
    @DisplayName("Successful authorization test with valid credentials")
    public void successfulAuthorizationViaEnumSourceTest(UserName validUserName) {

        login(validUserName.name().toLowerCase(), "secret_sauce");
        checkThatUserIsLoggedIn();
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

        login("wrong_user", "secret_sauce");
        $("[data-test=error]")
                .shouldHave(Condition.text("Username and password do not match any user in this service"));
    }
}
