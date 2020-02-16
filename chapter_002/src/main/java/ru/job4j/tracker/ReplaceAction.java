package ru.job4j.tracker;

import java.util.function.Consumer;

public class ReplaceAction implements UserAction {

    private Consumer<String> output;

    @Override
    public String name() {
        return "=== Edit item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter ID: ");
        String editName = input.askStr("Enter new name: ");
        Item editItem = new Item(editName);
        boolean edit = tracker.replace(id, editItem);
        if (edit) {
            output.accept("Item modified");
        } else {
            output.accept("ID not found");
        }
        return true;
    }
}
