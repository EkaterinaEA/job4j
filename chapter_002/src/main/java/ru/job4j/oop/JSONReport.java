package ru.job4j.oop;

public class JSONReport extends TextReport {

    @Override
    public String generate(String name, String body) {
        return "{\n\n  name : " + name + ",\n  body : " + body + "\n\n}";
    }
}