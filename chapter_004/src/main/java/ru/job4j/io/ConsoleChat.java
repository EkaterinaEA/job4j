package ru.job4j.io;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static ru.job4j.io.ReadFile.readFile;

public class ConsoleChat {

    private static String logFile = "data\\ChatLog.txt";
    private static boolean check = true;
    private String[] inputTestData;
    private String[] answers = readFile("data\\Sonnet2");

    public ConsoleChat() {

    }

    public ConsoleChat(String[] inputTestData) {
        this.inputTestData = inputTestData;
    }

    public void consoleChat() throws IOException {
        System.out.println("Добро пожаловать в консольный чат!");
        if (this.inputTestData != null) {
            testMethod();
        } else workMethod();
    }

    private void workMethod() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        while (!input.equals("закончить")) {
            input = sc.nextLine();
            writeLog(input);
            if (input.equals("продолжить")) {
                check = true;
            }
            if (input.equals("стоп") || input.equals("закончить")) {
                check = false;
            }
            if (check) {
                String answer = answers[(int) (Math.random() * answers.length)];
                writeLog(answer);
                System.out.println(answer);
            }
        }
    }

    private void testMethod() {
        int position = 0;
        String input = inputTestData[position++];
        while (!input.equals("закончить")) {
            input = inputTestData[position++];
            writeLog(input);
            if (input.equals("продолжить")) {
                check = true;
            }
            if (input.equals("стоп") || input.equals("закончить")) {
                check = false;
            }
            if (check) {
                String answer = answers[(int) (Math.random() * answers.length)];
                writeLog(answer);
                System.out.println(answer);
            }
        }
    }

    private static void writeLog(String line) {
        try (FileWriter writer = new FileWriter(logFile, true)) {
            writer.write(line + System.lineSeparator());
            writer.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
