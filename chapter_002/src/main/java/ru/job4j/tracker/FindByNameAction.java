package ru.job4j.tracker;

import java.util.List;
import java.util.function.Consumer;

public class FindByNameAction implements UserAction {

    @Override
    public String name() {
        return "=== Find items by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
        String findName = input.askStr("Enter name: ");
        List<Item> foundByName = tracker.findByName(findName);
        if (foundByName != null) {
            for (Item found : foundByName) {
                output.accept("Item ID: " + found.getId() + ", Item name: " + found.getName());
            }
        } else {
            output.accept("Not found");
        }
        return true;
    }
}

