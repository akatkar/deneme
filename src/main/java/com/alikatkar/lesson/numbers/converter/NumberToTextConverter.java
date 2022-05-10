package com.alikatkar.lesson.numbers.converter;


public record NumberToTextConverter(NumbersToText numbersToText) {

    public String toText(long number) {
        return numbersToText.toText(number);
    }

    public static NumberToTextConverter of(String language) {
        return switch (language.toLowerCase()) {
            case "en" -> new NumberToTextConverter(new EnglishConverter());
            case "de" -> new NumberToTextConverter(new DeutschConverter());
            default -> new NumberToTextConverter(new TurkishConverter());
        };
    }
}
