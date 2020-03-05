package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class StartUI {

    public void init(Input input, Tracker tracker, List<UserAction> actions, Consumer<String> output) {
        boolean run = true;
        while (run) {
            this.showMenu(actions, output);
            int select = input.askInt("Select: ", actions.size(), output);
            UserAction action = actions.get(select);
            run = action.execute(input, tracker, output);
        }
    }

    private void showMenu(List<UserAction> actions, Consumer<String> output) {
        output.accept("Menu.");
        int index = 0;
        for (UserAction userAction : actions) {
            output.accept(index++ + ". " + userAction.name());
        }
    }
    
}
