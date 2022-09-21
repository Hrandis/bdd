package ru.netology.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.val;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class BalanceCheckPage {

    private final SelenideElement firstCard = $("[data-test-id=\"" + DataHelper.getCard1Info().getCardID() + "\"]");
    private final SelenideElement secondCard = $("[data-test-id=\"" + DataHelper.getCard2Info().getCardID() + "\"]");
    private final SelenideElement firstCardButton = $("[data-test-id=\"" + DataHelper.getCard1Info().getCardID() + "\"] button");
    private final SelenideElement secondCardButton = $("[data-test-id=\"" + DataHelper.getCard2Info().getCardID() + "\"] button");

    public int getFirstCardBalance() {
        String text = firstCard.text();
        return extractBalance(text);
    }

    public int getSecondCardBalance() {
        String text = secondCard.text();
        return extractBalance(text);
    }

    private int extractBalance(String text) {
        String balanceStart = "баланс: ";
        val start = text.indexOf(balanceStart);
        String balanceFinish = " р.";
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

    public BalanceRefillPage pressFirstCardButton() {
        firstCardButton.click();
        return new BalanceRefillPage();
    }

    public BalanceRefillPage pressSecondCardButton() {
        secondCardButton.click();
        return new BalanceRefillPage();
    }
}
