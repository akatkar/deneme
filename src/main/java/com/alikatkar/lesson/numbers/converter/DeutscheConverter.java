package com.alikatkar.lesson.numbers.converter;

import java.util.ArrayDeque;
import java.util.Deque;

public class DeutscheConverter implements NumbersToText {
    private static final String ZERO = "null";
    private static final String ONE = "eins";
    private static final String[] ONES =
            {"", "ein", "zwei", "drei", "vier", "fünf", "sechs", "sieben", "acht", "neun", "zehn",
                    "elf", "zwölf", "dreizehn", "vierzehn", "fünfzehn", "sechzehn", "siebzehn", "achtzehn", "neunzehn"};
    private static final String[] TENS =
            {"", "zehn", "zwanzig", "dreißig", "vierzig", "fünfzig", "sechzig", "siebzig", "achtzig", "neunzig"};
    private static final String HUNDREDS = "hundert";
    private static final String[] THOUSANDS =
            {"", "tausend", "million", "milliarde", "billion", "billiarde", "trillion"};

    private String toTextAsTwoDigit(int number) {
        if (number < 20) {
            return ONES[number];
        }
        return number % 10 == 0
                ? TENS[number / 10]
                : ONES[number % 10] + "und" + TENS[number / 10];
    }

    private String toTextAsThreeDigit(int number) {
        if (number < 100) {
            return toTextAsTwoDigit(number);
        }
        return number % 100 == 0
                ? ONES[number / 100] + HUNDREDS
                : ONES[number / 100] + HUNDREDS + toTextAsTwoDigit(number % 100);
    }

    @Override
    public String toText(long number) {

        if(number == 0) {
            return ZERO;
        } else if (number == 1) {
            return ONE;
        }

        Deque<String> stack = new ArrayDeque<>();
        int thousand = 0;
        while (number > 0) {
            int threeDigit = (int)(number % 1000);
            stack.push(THOUSANDS[thousand]);
            stack.push(toTextAsThreeDigit(threeDigit));
            thousand++;
            number /= 1000;
        }
        return String.join("", stack);
    }
}
