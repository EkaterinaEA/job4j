package ru.job4j.tracker;

import java.util.function.Consumer;

public interface Input {

    String askStr(String question);

    int askInt(String question, int max, Consumer<String> output);

}
