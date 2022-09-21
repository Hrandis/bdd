package ru.netology.pages;

import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    public BalanceCheckPage enterCode(String code) {
        $("[data-test-id=\"code\"] input").setValue(code);
        $("[data-test-id=\"action-verify\"]").click();
        return new BalanceCheckPage();
    }
}
