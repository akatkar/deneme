package com.alikatkar.lesson.numbers.converter;


public class NumberToTextConverter {
    private final NumbersToText numbersToText;

    private NumberToTextConverter(NumbersToText numbersToText) {
        this.numbersToText = numbersToText;
    }

    public String toText(long number) {
        return numbersToText.toText(number);
    }

    public static NumberToTextConverter of(String language) {
        return switch (language.toLowerCase()) {
            case "en" -> new NumberToTextConverter(new EnglishConverter());
            case "de" -> new NumberToTextConverter(new DeutscheConverter());
            default -> new NumberToTextConverter(new TurkishConverter());
        };
    }
}
