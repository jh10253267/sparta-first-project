package kr.sparta.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class ParseInt {

    private ParseInt() {

    }
    private static ParseInt instance = new ParseInt();

    public static ParseInt getInstance() {
        return instance;
    }
    public static String parsePrice(int price) {
        DecimalFormat formatter = new DecimalFormat("###,###");
        return formatter.format(price);
    }
}
