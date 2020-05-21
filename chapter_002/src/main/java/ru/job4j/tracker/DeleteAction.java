package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "===== Delete a new Item =====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("Enter id: ");
        String id = input.askStr("");
        tracker.delete(id);
        System.out.println("Item deleted");
        return true;
    }
}
