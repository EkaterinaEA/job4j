package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Matrix {

    private static Integer[][] matrix = {
            {1, 2, 3, 4},
            {2, 4, 6, 8},
            {3, 6, 9, 12},
            {4, 8, 12, 16}
    };

    private static List<List<Integer>> matrix1 = List.of(
            List.of(1, 2),
            List.of(3, 4)
    );

    public static void main(String[] args) {
        System.out.println(Stream.of(matrix).flatMap(e -> Stream.of(e)).collect(Collectors.toList()));
        System.out.println(matrix1.stream().flatMap(List::stream).collect(Collectors.toList()));
    }

}