package ru.job4j.tracker;

public class FindItemsByName implements UserAction {
    @Override
    public String name() {
        return "===== Find item by name =====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter name: ");
        for (Item item : tracker.findByName(name())) {
            System.out.println(item);
        }
        return true;
    }
}
