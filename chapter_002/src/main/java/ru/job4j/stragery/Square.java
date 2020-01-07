package ru.job4j.stragery;

public class Square implements Shape {

    private static final String SEPARATOR = System.getProperty("line.separator");

    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("++++++" + SEPARATOR);
        pic.append("+    +" + SEPARATOR);
        pic.append("+    +" + SEPARATOR);
        pic.append("++++++" + SEPARATOR);
        return pic.toString();
    }
}
