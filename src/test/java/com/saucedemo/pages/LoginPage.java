package com.saucedemo.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.saucedemo.data.Password;
import com.saucedemo.data.UserName;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private SelenideElement userName = $("#user-name"),
        password = $("#password"),
        loginBtn = $("#login-button"),
        authorizationErrorMessage = $("[data-test=error]");

    public void login(String userName, String password) {
        this.userName.setValue(userName);
        this.password.setValue(password);
        loginBtn.click();
    }

    public void loginWithDefaultCredentials() {
        login(UserName.STANDARD_USER.toString().toLowerCase(), Password.SECRET_SAUCE.toString().toLowerCase());
    }

    public void checkErrorMessageAboutUnsuccessfulLoginIsShown() {
        authorizationErrorMessage.shouldHave(Condition.text("Username and password do not match any user in this service"));
    }
}
