package ru.netology.data.pages;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public static BalanceCheckPage login(){
    $("[data-test-id=\"login\"] input").setValue("vasya");
    $("[data-test-id=\"password\"] input").setValue("qwerty123");
    $("[data-test-id=\"action-login\"]").click();
    $("[data-test-id=\"code\"] input").setValue("12345");
    $("[data-test-id=\"action-verify\"]").click();
    return new BalanceCheckPage();
    }
}
