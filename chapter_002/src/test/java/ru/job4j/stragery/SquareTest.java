package ru.job4j.stragery;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

    private static final String SEPARATOR = System.getProperty("line.separator");

    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        assertThat(
                square.draw(),
                is(
                        new StringBuilder()
                                .append("++++++" + SEPARATOR)
                                .append("+    +" + SEPARATOR)
                                .append("+    +" + SEPARATOR)
                                .append("++++++" + SEPARATOR)
                                .toString()
                )
        );
    }
}