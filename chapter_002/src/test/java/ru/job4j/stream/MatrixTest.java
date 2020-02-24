package ru.job4j.stream;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static ru.job4j.stream.Matrix.convertListOfListsToListOfNumbers;
import static ru.job4j.stream.Matrix.convertMatrixOfNumbersToListOfNumbers;

class MatrixTest {

    @Test
    void convertMatrixOfNumbersToListOfNumbersTest() {

        Integer[][] matrix = {
                {1, 2, 3, 4},
                {2, 4, 6, 8},
                {3, 6, 9, 12},
                {4, 8, 12, 16}
        };

        List<Integer> list = convertMatrixOfNumbersToListOfNumbers(matrix);
        assertEquals(list, List.of(1, 2, 3, 4, 2, 4, 6, 8, 3, 6, 9, 12, 4, 8, 12, 16));

    }

    @Test
    void convertListOfListsToListOfNumbersTest() {

        List<List<Integer>> matrix = List.of(
                List.of(1, 2),
                List.of(3, 4)
        );

        List<Integer> list = convertListOfListsToListOfNumbers(matrix);
        assertEquals(list, List.of(1, 2, 3, 4));

    }
}