package ru.job4j;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import ru.job4j.io.ConsoleChat;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConsoleChatTest {

    private static String logFile = "data\\ChatLog.txt";

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void goAndGet() throws IOException {
        String[] answersOfUser = {"", "привет", "как дела?", "стоп", "привет", "продолжить", "как дела?", "закончить"};
        new ConsoleChat(answersOfUser).consoleChat();
        try (BufferedReader in = new BufferedReader(new FileReader(logFile))){
            List<String> list = in.lines().collect(Collectors.toList());
            assertThat(list.get(0), is("привет"));
            assertTrue(list.get(1).length() > 0);
            assertThat(list.get(2), is("как дела?"));
            assertTrue(list.get(3).length() > 0);
            assertThat(list.get(4), is("стоп"));
            assertThat(list.get(5), is("привет"));
            assertThat(list.get(6), is("продолжить"));
            assertTrue(list.get(7).length() > 0);
            assertThat(list.get(8), is("как дела?"));
            assertTrue(list.get(9).length() > 0);
            assertThat(list.get(10), is("закончить"));
            assertThat(list.size(), is(11));
        }

    }
}
