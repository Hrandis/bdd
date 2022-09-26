package ru.netology.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.netology.data.DataHelper;
import ru.netology.pages.BalanceCheckPage;
import ru.netology.pages.LoginPage;

import static org.junit.jupiter.api.Assertions.*;

import static com.codeborne.selenide.Selenide.open;

public class MoneyTransferTest {
    int firstCardStartBalance;
    int secondCardStartBalance;
    BalanceCheckPage vasyaDashboard;

    @BeforeEach
    public void preps() {
        open("http://localhost:9999");
        LoginPage loginPage = new LoginPage();
        vasyaDashboard = loginPage.login(DataHelper.getUserInfo().getLogin(), //enter login
                                         DataHelper.getUserInfo().getPassword()) //enter password
                                    .enterCode(DataHelper.getVerificationCode(DataHelper.getUserInfo()).getCode()); //enter code
        firstCardStartBalance = vasyaDashboard.getFirstCardBalance();
        secondCardStartBalance = vasyaDashboard.getSecondCardBalance();
    }

    @ParameterizedTest
    @CsvSource(value = {"10000", "9999", "555", "2", "1"}) //only happy path borders and random in between
    void shouldTransferMoneyToCard(int amount) {
        vasyaDashboard = vasyaDashboard.pressFirstCardButton().refill(amount, DataHelper.getCard2Info().getCardNumber());

        int actualCard1 = vasyaDashboard.getFirstCardBalance();
        int expectedCard1 = firstCardStartBalance + amount;
        assertEquals(expectedCard1, actualCard1);

        int actualCard2 = vasyaDashboard.getSecondCardBalance();
        int expectedCard2 = secondCardStartBalance - amount;
        assertEquals(expectedCard2, actualCard2);

        //return SUT in a default condition to be independent of the tests sequence
        vasyaDashboard.pressSecondCardButton().refill(amount, DataHelper.getCard1Info().getCardNumber());
    }
}