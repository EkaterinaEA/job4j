package ru.job4j.tracker;

import java.util.function.Consumer;

public class DeleteAction implements UserAction {

    @Override
    public String name() {
        return "=== Delete item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
        String deleteId = input.askStr("Enter ID: ");
        boolean delete = tracker.delete(deleteId);
        if (delete) {
            output.accept("Item deleted");
        } else {
            output.accept("ID not found");
        }
        return true;
    }
}
