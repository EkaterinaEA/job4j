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
    public void when2ElemEquals() {
        int result = Max.max(2, 2);
        assertThat(result, is(2));
    }

    @Test
    public void when3ElemFirstMax() {
        int result = Max.max(3, 2, 0);
        assertThat(result, is(3));
    }

    @Test
    public void when3ElemThirdMax() {
        int result = Max.max(-30, 2, 10);
        assertThat(result, is(10));
    }

    @Test
    public void when3ElemEquals() {
        int result = Max.max(30, 30, 30);
        assertThat(result, is(30));
    }

    @Test
    public void when4ElemFirstMax() {
        int result = Max.max(3, 2, 0, 1);
        assertThat(result, is(3));
    }

    @Test
    public void when4ElemThirdMax() {
        int result = Max.max(-30, 2, 10, 0);
        assertThat(result, is(10));
    }

    @Test
    public void when4ElemEquals() {
        int result = Max.max(30, 30, 30, 30);
        assertThat(result, is(30));
    }

}