package lotto.util;

import java.util.List;

import static lotto.model.Rank.*;

public class Calculator {

    private static final float PERCENTAGE = 100;
    private static final int TICKET_PRICE = 1000;

    public static int getNumberOfLottoTickets(int purchasePrice) {
        return purchasePrice / TICKET_PRICE;
    }

    public static float getRateOfProfit(int purchasePrice, List<Integer> rates) {
        float totalPrize = getTotalPrize(rates);
        float rateOfProfit = (totalPrize / (float) purchasePrice) * PERCENTAGE;
        return rateOfProfit;
    }

    public static int getTotalPrize(List<Integer> rates) {
        int total = 0;

        for (int i = 0; i < 5; i++) {
            total += getEachRankPrize(i + 1, rates.get(i));
        }
        return total;
    }

    public static int getEachRankPrize(int rate, int rateNum) {

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