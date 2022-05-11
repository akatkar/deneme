package com.alikatkar.lesson.numbers.converter;

public interface NumberToTextConverter {
    String toText(long number);

    static NumberToTextConverter of(String language) {
        return switch (language.toLowerCase()) {
            case "en" -> new EnglishConverter();
            case "de" -> new DeutschConverter();
            default -> new TurkishConverter();
        };
    }
}
