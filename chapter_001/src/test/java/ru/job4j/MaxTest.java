package ru.job4j;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

class MaxTest {

    @Test
    public void whenMax1To2Then2() {
        int result = Max.max(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenMax3To2Then3() {
        int result = Max.max(2, 3);
        assertThat(result, is(3));
    }

    @Test
    public void whenElemEquals() {
        int result = Max.max(2, 2);
        assertThat(result, is(2));
    }
}