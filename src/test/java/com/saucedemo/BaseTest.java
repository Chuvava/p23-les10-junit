package com.saucedemo;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    @BeforeAll
    protected static void beforeAll() {
        Configuration.baseUrl = "https://www.saucedemo.com/";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy="eager";
    }

    @BeforeEach
    protected void beforeEach() {
        open("");
    }

    protected void login(String userName, String password) {
        $("#user-name").setValue(userName);
        $("#password").setValue(password);
        $("#login-button").click();
    }

    protected void loginWithDefaultCredentials() {
        login("standard_user", "secret_sauce");
    }

    protected void checkThatUserIsLoggedIn() {
        $(".app_logo").shouldHave(Condition.exactText("Swag Labs"));
    }
}
