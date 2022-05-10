package com.alikatkar.lesson.numbers.converter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeutschConverterTest {

    private final DeutschConverter deutschConverter = new DeutschConverter();

    @ParameterizedTest
    @CsvFileSource(resources = "/DeutschValues.csv")
    void toText(long number, String expected) {
        System.out.println(number + ":" + expected);
        String actual = deutschConverter.toText(number);
        assertEquals(expected, actual);
    }
}