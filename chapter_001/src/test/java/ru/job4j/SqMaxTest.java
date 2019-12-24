package ru.job4j;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

class SqMaxTest {

    @Test
    public void whenFirstMax() {
        SqMax check = new SqMax();
        int result = check.max(10, 4, 2, 1);
        assertThat(result, is(10));
    }

    @Test
    public void whenSecondMax() {
        SqMax check = new SqMax();
        int result = check.max(1, 4, 2, 1);
        assertThat(result, is(4));
    }

    @Test
    public void whenThirdMax() {
        SqMax check = new SqMax();
        int result = check.max(1, -4, 20, 1);
        assertThat(result, is(20));
    }

    @Test
    public void whenForthMax() {
        SqMax check = new SqMax();
        int result = check.max(1, 4, -2, 20);
        assertThat(result, is(20));
    }

    @Test
    public void whenElementsAreEquals() {
        SqMax check = new SqMax();
        int result = check.max(-20, -20, -20, -20);
        assertThat(result, is(-20));
    }
}