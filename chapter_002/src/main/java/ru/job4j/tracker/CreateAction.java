package ru.job4j.tracker;

import java.util.function.Consumer;

public class CreateAction implements UserAction {

    private Consumer<String> output;

    @Override
    public String name() {
        return "=== Create a new Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        output.accept("Item created");
        return true;
    }
}
