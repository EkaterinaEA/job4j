package ru.job4j.array;

import org.junit.jupiter.api.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

class MinTest {

    @Test
    public void whenFirstMin() {
        assertThat(
                Min.findMin(
                        new int[] {0, 5, 10}
                ),
                is(0)
        );
    }

    @Test
    public void whenLastMin() {
        assertThat(
                Min.findMin(
                        new int[] {10, 5, 3}
                ),
                is(3)
        );
    }

    @Test
    public void whenMiddleMin() {
        assertThat(
                Min.findMin(
                        new int[] {10, 2, 5}
                ),
                is(2)
        );
    }

    @Test
    public void whenNegativeNumber() {
        assertThat(
                Min.findMin(
                        new int[] {-10, 10, 10}
                ),
                is(-10)
        );
    }

    @Test
    public void whenEquals() {
        assertThat(
                Min.findMin(
                        new int[] {10, 10, 10}
                ),
                is(10)
        );
    }

}