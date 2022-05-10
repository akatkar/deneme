package com.alikatkar.lesson.numbers.converter;

import java.util.ArrayDeque;
import java.util.Deque;

public class TurkishConverter implements NumbersToText {
    private static final String ZERO = "sıfır";
    private static final String[] ONES =
            {"", "bir", "iki", "üç", "dört", "beş", "altı", "yedi", "sekiz", "dokuz"};
    private static final String[] TENS =
            {"", "on", "yirmi", "otuz", "kırk", "elli", "altmış", "yetmiş", "seksen", "doksan"};
    private static final String HUNDREDS = "yüz";
    private static final String[] THOUSANDS =
            {"", "bin", "milyon", "milyar", "trilyon", "katrilyon", "kentilyon"};

    private String toTextAsThreeDigit(int number) {
        int digitCount = 0;
        String[] texts = {"","",""};
        while (number > 0) {
            int digit = number % 10;

            texts[2 - digitCount] = switch (digitCount) {
                case 0 -> ONES[digit];
                case 1 -> TENS[digit];
                case 2 -> ((digit > 1) ? ONES[digit] + " " : "") + HUNDREDS;
                default -> throw new IllegalArgumentException();
            };

            number /= 10;
            digitCount++;
        }
        return String.join(" ", texts).trim();
    }

    public String toText(long number) {

        if(number == 0) {
            return ZERO;
        }

        Deque<String> stack = new ArrayDeque<>();
        int thousand = 0;
        while (number > 0) {
            int threeDigit = (int)(number % 1000);
            stack.push(THOUSANDS[thousand]);
            if (thousand != 1 || number != 1) {
                stack.push(toTextAsThreeDigit(threeDigit));
            }
            thousand++;
            number /= 1000;
        }
        return String.join(" ", stack).trim();
    }
}
