package kr.sparta.util;

import java.text.DecimalFormat;

public class PriceParser {

    private PriceParser() {
    }
    private static final PriceParser instance = new PriceParser();

    public static PriceParser getInstance() {
        return instance;
    }
    public static String parsePrice(int price) {
        DecimalFormat formatter = new DecimalFormat("###,###");
        return formatter.format(price);
    }
}
