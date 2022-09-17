package ru.netology.data;

import com.codeborne.selenide.SelenideElement;
import lombok.Value;

@Value
public class Cards {
    private SelenideElement card;
    private SelenideElement button;

    public String text() {
        return card.text();
    }
}
