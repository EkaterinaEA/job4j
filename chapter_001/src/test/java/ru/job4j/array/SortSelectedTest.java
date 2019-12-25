package ru.job4j.array;

import org.junit.jupiter.api.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

class SortSelectedTest {

    @Test
    public void whenSort5() {
        int[] input = new int[] {3, 4, 1, 2, 5};
        int result[] = SortSelected.sort(input);
        int[] expect = new int[] {1, 2, 3, 4, 5};
        assertThat(result, is(expect));
    }

    @Test
    public void whenSort3() {
        int[] input = new int[] {-3, 40, 10};
        int result[] = SortSelected.sort(input);
        int[] expect = new int[] {-3, 10, 40};
        assertThat(result, is(expect));
    }

}