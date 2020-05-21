package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream out = System.out;
        System.setOut(new PrintStream(byteArrayOutputStream));
        ValidateInput validateInput = new ValidateInput(new StubInput(new String[]{"invalid", "1"}));
        validateInput.askInt("Enter", 6);
        assertThat(byteArrayOutputStream.toString(), is(String.format("Please enter validate data%n")));
        System.setOut(out);
    }

    @Test
    public void whenIllegalState() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream out = System.out;
        System.setOut(new PrintStream(byteArrayOutputStream));
        ValidateInput validateInput = new ValidateInput(new StubInput(new String[]{"7", "1"}));
        validateInput.askInt("Enter", 6);
        assertThat(byteArrayOutputStream.toString(), is(String.format("Please enter key from menu%n")));
        System.setOut(out);
    }

}
