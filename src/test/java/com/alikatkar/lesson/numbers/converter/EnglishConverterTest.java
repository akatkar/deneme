package com.alikatkar.lesson.numbers.converter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EnglishConverterTest {

    private final EnglishConverter englishConverter = new EnglishConverter();

    @ParameterizedTest
    @CsvFileSource(resources = "/EnglishValues.csv")
    void toText(long number, String expected) {
        System.out.println(number + ":" + expected);
        String actual = englishConverter.toText(number);
        assertEquals(expected, actual);
    }
}