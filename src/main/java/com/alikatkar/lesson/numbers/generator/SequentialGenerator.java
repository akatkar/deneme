package com.alikatkar.lesson.numbers.generator;

class SequentialGenerator implements NumberGenerator {
    private final long start;
    private final long stop;
    private long current;

    public SequentialGenerator(long start, long stop) {
        this.start = start;
        this.stop = stop;
        this.current = start;
    }

    @Override
    public long nextNumber() {
        long next = current++;
        if (current >= stop) {
            current = start;
        }
        return next;
    }
}
