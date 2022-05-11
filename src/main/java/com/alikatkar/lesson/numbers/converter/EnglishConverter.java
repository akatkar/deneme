package com.alikatkar.lesson.numbers.converter;

import java.util.ArrayDeque;
import java.util.Deque;

class EnglishConverter implements NumberToTextConverter {
    private static final String ZERO = "zero";
    private static final String[] ONES =
            {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                    "eleven", "twelve","thirteen","fourteen","fifteen","sixteen", "seventeen", "eighteen", "nineteen"};
    private static final String[] TENS =
            {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    private static final String HUNDREDS = "hundred";
    private static final String[] THOUSANDS =
            {"", "thousand", "million", "billion", "trillion", "quadrillion", "quintillion"};

    private String toTextAsTwoDigit(int number) {
        if (number < 20) {
            return ONES[number];
        }
        return number % 10 == 0
                ? TENS[number / 10]
                : TENS[number / 10] + '-' + ONES[number % 10];
    }

    private String toTextAsThreeDigit(int number) {
        if (number < 100) {
            return toTextAsTwoDigit(number);
        }
        return number % 100 == 0
                ? ONES[number/100] + ' ' + HUNDREDS
                : ONES[number/100] + ' ' + HUNDREDS + " and " + toTextAsTwoDigit(number%100);
    }

    @Override
    public String toText(long number) {

        if(number == 0) {
            return ZERO;
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
        return String.join(" ", stack).trim();
    }
}
