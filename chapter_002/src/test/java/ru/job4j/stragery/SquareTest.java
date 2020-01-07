package ru.job4j.stragery;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        assertThat(
                square.draw(),
                is(
                        new StringBuilder()
                                .append("++++++\n")
                                .append("+    +\n")
                                .append("+    +\n")
                                .append("++++++\n")
                                .toString()
                )
        );
    }
}