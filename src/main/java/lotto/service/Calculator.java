package lotto.service;

import static lotto.model.Rank.*;

public class Calculator {

    private static final float PERCENTAGE = 100;
    private static final int TICKET_PRICE = 1000;

    public static int numberOfLottoTickets(int purchasePrice) {
        return purchasePrice / TICKET_PRICE;
    }

    public static float rateOfProfit(int purchasePrice, int[] rankBoard) {
        float totalPrize = totalPrize(rankBoard);
        float rateOfProfit = (totalPrize / (float) purchasePrice) * PERCENTAGE;
        return rateOfProfit;
    }

    public static int totalPrize(int[] rates) {
        int total = 0;

        for (int i = 1; i < 6; i++) {
            total += eachRankPrize(i, rates[i]);
        }
        return total;
    }

    public static int eachRankPrize(int rate, int rateNum) {

        switch (rate) {
            case 5:
                return getPrizeMoney(FIFTH) * rateNum;
            case 4:
                return getPrizeMoney(FOURTH) * rateNum;
            case 3:
                return getPrizeMoney(THIRD) * rateNum;
            case 2:
                return getPrizeMoney(SECOND) * rateNum;
            case 1:
                return getPrizeMoney(FIRST) * rateNum;
        }

        return 0;

    }
}