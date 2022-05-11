package com.alikatkar.lesson.numbers.generator;

import java.util.Random;

class RandomGenerator implements NumberGenerator {
    private final Random random = new Random();
    private final long start;
    private final long stop;

    public RandomGenerator(long start, long stop) {
        this.start = start;
        this.stop = stop;
    }

    @Override
    public long nextNumber() {
        return random.longs(start, stop)
                .limit(1)
                .toArray()[0];
    }
}
