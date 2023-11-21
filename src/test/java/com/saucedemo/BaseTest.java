package com.saucedemo;

import com.codeborne.selenide.Configuration;
import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    protected LoginPage loginPage = new LoginPage();
    protected ProductsPage productsPage = new ProductsPage();
    protected CartPage cartPage = new CartPage();


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

}
