package ru.job4j.io;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("even.txt")) {
            StringBuilder numbers = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                numbers.append((char) read);
            }
            String[] lines = numbers.toString().split(System.lineSeparator());
            for (String line : lines) {
                if (Integer.parseInt(line) % 2 == 0) {
                    System.out.println("Number " + line + " is even");
                } else {
                    System.out.println("Number " + line + " is odd");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}