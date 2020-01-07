package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        ValidateInput input = new ValidateInput(new StubInput(new String[]{"invalid", "1"}));
        input.askInt("Enter", 1);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Please enter validate data again ")
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}