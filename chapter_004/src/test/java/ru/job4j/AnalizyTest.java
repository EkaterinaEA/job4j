package ru.job4j;

import org.junit.Test;
import ru.job4j.io.Analizy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AnalizyTest {

    private static final String MAIN_DIR = System.getProperty("user.dir");
    private static final String SEPARATOR = System.getProperty("file.separator");

    private static final String target = MAIN_DIR + SEPARATOR + "data" + SEPARATOR + "unavailable.csv";
    private static final String source = MAIN_DIR + SEPARATOR + "data" + SEPARATOR + "server.log";

    @Test
    public void check() throws IOException {
        new Analizy().unavailable(source, target);
        try (BufferedReader read = new BufferedReader(new FileReader(target))
        ) {
            assertThat(read.readLine(), is("10:58:01;10:59:01"));
            assertThat(read.readLine(), is("11:01:02;11:02:02"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
