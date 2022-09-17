package ru.netology.data.pages;

import lombok.val;
import ru.netology.data.Cards;

public class BalanceCheckPage {

    private static final String balanceStart = "баланс: ";
    private static final String balanceFinish = " р.";

    public static int getCardBalance(Cards card) {
        String text = card.text();
        return extractBalance(text);
    }

    private static int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

    public static BalanceRefillPage pressButton(Cards card) {
        card.getButton().click();
        return new BalanceRefillPage();
    }
}
