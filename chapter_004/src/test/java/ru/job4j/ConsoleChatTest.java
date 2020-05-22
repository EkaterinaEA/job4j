package ru.job4j;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import ru.job4j.io.ConsoleChat;
import ru.job4j.io.StubInput;

import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ConsoleChatTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void trackerTest() throws IOException {
        String[] answersOfUser = {"Hello!", "stop", "How are you?", "continue", "finish"};
        String source = "data\\Sonnet2";
        File destination = folder.newFile("log.txt");
        new ConsoleChat(new StubInput(answersOfUser), source, destination.getAbsolutePath()).init();
        try (BufferedReader in = new BufferedReader(new FileReader(destination))) {
            List<String> list = in.lines().collect(Collectors.toList());
            System.out.println(list.toString());
            assertThat(list.get(0), is("Hello!"));
            assertTrue(list.get(1).length() > 0);
            assertThat(list.get(2), is("stop"));
            assertThat(list.get(3), is("How are you?"));
            assertThat(list.get(4), is("continue"));
            assertTrue(list.get(5).length() > 0);
            assertThat(list.get(6), is("finish"));
            assertThat(list.size(), is(7));
        }

    }
}
