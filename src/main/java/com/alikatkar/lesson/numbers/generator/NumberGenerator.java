package com.alikatkar.lesson.numbers.generator;

public interface NumberGenerator {
    long nextNumber();

    static NumberGenerator of(String type, long startNumber, long stopNumber) {
        return "Random".equals(type)
                ? new RandomGenerator(startNumber, stopNumber)
                : new SequentialGenerator(startNumber, stopNumber);
    }
}
