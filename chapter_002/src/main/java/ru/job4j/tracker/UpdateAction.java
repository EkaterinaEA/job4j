package ru.job4j.tracker;

public class UpdateAction implements UserAction {
    @Override
    public String name() {
        return "===== Find item by name =====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter id: ");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.update(id, item);
        System.out.println("Item updated");
        return true;
    }
}
