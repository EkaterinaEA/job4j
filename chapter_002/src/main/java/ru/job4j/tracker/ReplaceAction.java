package ru.job4j.tracker;

import java.util.function.Consumer;

public class ReplaceAction implements UserAction {

    @Override
    public String name() {
        return "=== Edit item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
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
