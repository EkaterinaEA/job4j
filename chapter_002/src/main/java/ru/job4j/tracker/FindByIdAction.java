package ru.job4j.tracker;

import java.util.function.Consumer;

public class FindByIdAction implements UserAction {

    @Override
    public String name() {
        return "=== Find item by Id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
        String findId = input.askStr("Enter ID: ");
        Item foundById = tracker.findById(findId);
        if (foundById != null) {
            output.accept("Item ID: " + foundById.getId() + ", Item name: " + foundById.getName());
        } else {
            output.accept("Not found");
        }
        return true;
    }
}
