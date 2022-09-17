package ru.netology.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.netology.data.Cards;
import ru.netology.data.pages.BalanceCheckPage;
import ru.netology.data.pages.LoginPage;

import static org.junit.jupiter.api.Assertions.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MoneyTransferTest {
    public Cards card1 = new Cards($("[data-test-id=\"92df3f1c-a033-48e6-8390-206f6b1f56c0\"]"), $("[data-test-id=\"92df3f1c-a033-48e6-8390-206f6b1f56c0\"] button"));
    public Cards card2 = new Cards($("[data-test-id=\"0f3f5c2a-249e-4c3d-8287-09f7a039391d\"]"), $("[data-test-id=\"0f3f5c2a-249e-4c3d-8287-09f7a039391d\"] button"));
    int firstCardBalance;
    int secondCardBalance;

    @BeforeEach
    public void preps() {
        open("http://localhost:9999");
        LoginPage.login();
        firstCardBalance = BalanceCheckPage.getCardBalance(card1);
        secondCardBalance = BalanceCheckPage.getCardBalance(card2);
    }

    @ParameterizedTest
    @CsvSource(value = {"10000", "9999", "555", "2", "1"}) //only happy path borders and random in between
    void shouldTransferMoneyToCard(int amount) {
        BalanceCheckPage.pressButton(card1).refill(amount, "5559 0000 0000 0002");
        int actualCard1 = BalanceCheckPage.getCardBalance(card1);
        int expectedCard1 = firstCardBalance + amount;
        int actualCard2 = BalanceCheckPage.getCardBalance(card2);
        int expectedCard2 = secondCardBalance - amount;
        assertEquals(expectedCard1, actualCard1);
        assertEquals(expectedCard2, actualCard2);
        BalanceCheckPage.pressButton(card2).refill(2 * amount, "5559 0000 0000 0001"); //decided to return SUT in a default condition to be independent of the tests sequence
    }
}