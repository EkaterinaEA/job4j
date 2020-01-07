package ru.job4j.tracker;

public class DeleteAction implements UserAction {

    @Override
    public String name() {
        return "=== Delete item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String deleteId = input.askStr("Enter ID: ");
        boolean delete = tracker.delete(deleteId);
        if (delete) {
            System.out.println("Item deleted");
        } else {
            System.out.println("ID not found");
        }
        return true;
    }
}
