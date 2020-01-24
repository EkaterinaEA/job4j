package ru.job4j.tracker;

public class StubInput implements Input {

    private String[] answers;
    private int position = 0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }


    public StubInput() {
    }

    @Override
    public String askStr(String question) {
        return answers[position++];
    }

    @Override
    public int askInt(String question, int max) {
        if (question.matches("[0-9]+") && (Integer.parseInt(askStr(question)) > max
                || Integer.parseInt(askStr(question)) < 0)) {
            throw new IllegalStateException();
        } else {
            return Integer.valueOf(askStr(question));
        }
    }

}
