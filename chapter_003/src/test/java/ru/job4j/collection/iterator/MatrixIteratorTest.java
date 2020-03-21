package ru.job4j.collection.iterator;

import org.junit.jupiter.api.Test;
import ru.job4j.collection.iterator.MatrixIterator;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

class MatrixIteratorTest {

    @Test
    void whenJaggedArray() {

        MatrixIterator matrixIterator = new MatrixIterator(new int[][]{{1, 2, 3, 4}, {5, 6}});
        Integer[] expected = new Integer[] {1, 2, 3, 4, 5, 6};
        List<Integer> list = new ArrayList<>();

        list.add(matrixIterator.next());
        list.add(matrixIterator.next());
        list.add(matrixIterator.next());
        list.add(matrixIterator.next());
        list.add(matrixIterator.next());
        list.add(matrixIterator.next());

        Integer[] actual = list.toArray(new Integer[0]);

        assertThat(actual, is(expected));

    }
}