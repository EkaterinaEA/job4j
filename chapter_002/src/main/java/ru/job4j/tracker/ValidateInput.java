package ru.job4j.tracker;

import java.util.function.Consumer;

public class ValidateInput implements Input {

    private final Input input;

    public ValidateInput(Input input) {
        this.input = input;
    }

    @Override
    public String askStr(String question) {
        return input.askStr(question);
    }

    @Override
    public int askInt(String question, int max, Consumer<String> output) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = input.askInt(question, max, output);
                invalid = false;
            } catch (IllegalStateException moe) {
                output.accept("Please select key from menu ");
            } catch (NumberFormatException nfe) {
                output.accept("Please enter validate data again ");
            }
        } while (invalid);
        return value;
    }
}
