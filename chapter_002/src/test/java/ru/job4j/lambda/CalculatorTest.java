package ru.job4j.lambda;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void whenAddUntil3() {
        Calculator calculator = new Calculator();
        List<Double> buffer = new ArrayList<>();
        calculator.multiple(
                0, 3, 1,
                MathUtil :: add,
                buffer :: add
        );
        assertThat(buffer, is(Arrays.asList(1D, 2D, 3D)));
    }
}