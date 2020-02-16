package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class StartUI {

    private Consumer<String> output;

    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ", actions.size());
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        output.accept("Menu.");
        int index = 0;
        for (UserAction userAction : actions) {
            output.accept(index++ + ". " + userAction.name());
        }
    }


    public static void main(String[] args) {
        Input input = new StubInput();
        Input validate = new ValidateInput(input);
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction());
        new StartUI().init(validate, tracker, actions);
    }

    
}
