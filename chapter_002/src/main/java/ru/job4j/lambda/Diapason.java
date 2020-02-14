package ru.job4j.lambda;

import ru.job4j.oop.Diagnose;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Diapason {

    List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> functionInDiapason = new ArrayList<>();
        for (int i = start; i != end; i++) {
            functionInDiapason.add(func.apply((double) i));
        }
        return functionInDiapason;
    };

}
