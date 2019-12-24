package ru.job4j.loop;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class CounterTest {

    @Test
    void add() {

        int start = 1;
        int finish = 10;
        int expected = 30;
        int out = Counter.add(start, finish);
        assertEquals(expected, out);

    }
}