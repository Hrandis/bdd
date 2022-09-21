package ru.netology.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class BalanceRefillPage {
    private final SelenideElement amountField = $("[data-test-id=\"amount\"] input");
    private final SelenideElement fromCardField = $("[data-test-id=\"from\"] input");
    private final SelenideElement refillButton = $("[data-test-id=\"action-transfer\"]");

    //method receives refill amount in rubles and number of card to transfer money from,
    //fills the corresponding fields and presses the "Пополнить" button
    public BalanceCheckPage refill(int amount, String cardNumber) {
        amountField.doubleClick().sendKeys(Keys.BACK_SPACE); //cleaning field because it memorises prev value
        amountField.setValue(String.valueOf(amount));

        fromCardField.doubleClick().sendKeys(Keys.BACK_SPACE); //cleaning field because it memorises prev value
        fromCardField.setValue(cardNumber);

        refillButton.click();
        return new BalanceCheckPage();
    }
}


