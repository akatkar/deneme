package com.alikatkar.lesson.numbers.converter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class TurkishConverterTest {

    private final TurkishConverter turkishConverter = new TurkishConverter();

    @ParameterizedTest
    @CsvFileSource(resources = "/TurkishValues.csv")
    void toText(long number, String expected) {
        System.out.println(number + ":" + expected);
        String actual = turkishConverter.toText(number);
        assertEquals(expected, actual);
    }
}