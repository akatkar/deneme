package com.alikatkar.lesson.numbers.generator;

public interface NumberGenerator {
    long nextNumber();

    static NumberGenerator of(GeneratorType type, long startNumber, long stopNumber) {
        return GeneratorType.RANDOM == type
                ? new RandomGenerator(startNumber, stopNumber)
                : new SequentialGenerator(startNumber, stopNumber);
    }
}
