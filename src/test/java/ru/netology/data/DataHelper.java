package ru.netology.data;

import lombok.Value;

public class DataHelper {

    @Value
    public static class UserInfo {
        private String login;
        private String password;
    }

    public static UserInfo getUserInfo() {
        return new UserInfo("vasya", "qwerty123");
    }


    @Value
    public static class VerificationCode {
        private String code;
    }

    public static VerificationCode getVerificationCode(UserInfo user) {
        return new VerificationCode("12345");
    }

    @Value
    public static class CardInfo {
        private String cardID; //test ID in page code
        private String cardNumber; //card number visible in app
    }

    public static CardInfo getCard1Info() {
        return new CardInfo("92df3f1c-a033-48e6-8390-206f6b1f56c0", "5559 0000 0000 0001");

    }

    public static CardInfo getCard2Info() {
        return new CardInfo("0f3f5c2a-249e-4c3d-8287-09f7a039391d", "5559 0000 0000 0002");
    }
}
