package ru.job4j.io;

import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ConsoleChat {

    private static final String FINISH = "finish";
    private static final String CONTINUE = "continue";
    private static final String STOP = "stop";

    private final String answerFile;
    private final String logFile;
    private Input source;

    public ConsoleChat(Input input, String answerFile, String logFile) {
        this.source = input;
        this.answerFile = answerFile;
        this.logFile = logFile;
    }

    public void init() {
        try (PrintWriter out = new PrintWriter(new File(logFile));
             BufferedReader in = new BufferedReader(new FileReader(answerFile))) {
            String input;
            boolean check = true;
            Random random = new Random();
            List<String> answers = in.lines().collect(Collectors.toList());
            int size = answers.size();
            while (!FINISH.equals((input = source.getQuestion()))) {
                out.println(input);

                if (STOP.equals(input)) {
                    check = false;
                }
                if (CONTINUE.equals(input)) {
                    check = true;
                }
                if (check) {
                    String answer = answers.get(random.nextInt(size));
                    System.out.println(answer);
                    out.println(answer);
                }
            }
            out.println(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
