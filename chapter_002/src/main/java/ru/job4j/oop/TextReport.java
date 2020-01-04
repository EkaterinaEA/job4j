package ru.job4j.oop;

public class TextReport {

    private static final String SEPARATOR = System.getProperty("file.separator");

    public String generate(String name, String body) {
        return name + SEPARATOR + body;
    }

}
