package com.alikatkar.lesson.numbers.converter;

public interface NumberToTextConverter {
    String toText(long number);

    static NumberToTextConverter of(Language language) {
        return switch (language) {
            case EN -> new EnglishConverter();
            case DE -> new DeutschConverter();
            default -> new TurkishConverter();
        };
    }
}
