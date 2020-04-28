package ru.job4j.io;

import java.io.FileInputStream;

public class ReadFile {
    public static String[] readFile(String fileName) {
        try (FileInputStream in = new FileInputStream(fileName)) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            String[] lines = text.toString().split(System.lineSeparator());
            return lines;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
