package ru.netology.data.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Selenide.$;

public class BalanceRefillPage {
    private SelenideElement amountField=$("[data-test-id=\"amount\"] input");
    private SelenideElement fromCardField =$("[data-test-id=\"from\"] input");
    private SelenideElement refillButton =$("[data-test-id=\"action-transfer\"]");

    public BalanceCheckPage refill (int amount, String cardNumber){
        amountField.doubleClick().sendKeys(Keys.BACK_SPACE); //cleaning field because it memorises prev value
        amountField.setValue(String.valueOf(amount));
        fromCardField.doubleClick().sendKeys(Keys.BACK_SPACE); //cleaning field because it memorises prev value
        fromCardField.setValue(cardNumber);
        refillButton.click();
        return new BalanceCheckPage();
    }
}


