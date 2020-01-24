package ru.job4j.tracker;

import java.util.List;

public class FindByNameAction implements UserAction {

    @Override
    public String name() {
        return "=== Find items by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String findName = input.askStr("Enter name: ");
        List<Item> foundByName = tracker.findByName(findName);
        if (foundByName != null) {
            for (Item found : foundByName) {
                System.out.println("Item ID: " + found.getId() + ", Item name: " + found.getName());
            }
        } else {
            System.out.println("Not found");
        }
        return true;
    }
}

