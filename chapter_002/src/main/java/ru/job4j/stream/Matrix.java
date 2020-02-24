package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Matrix {

    public static List<Integer> convertMatrixOfNumbersToListOfNumbers(final Integer[][] matrix) {
        return Stream.of(matrix).flatMap(e -> Stream.of(e)).collect(Collectors.toList());
    }

    public static List<Integer> convertListOfListsToListOfNumbers(final List<List<Integer>> matrix) {
        return matrix.stream().flatMap(List::stream).collect(Collectors.toList());
    }
}