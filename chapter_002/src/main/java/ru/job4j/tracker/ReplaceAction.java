package ru.job4j.tracker;

public class ReplaceAction implements UserAction {

    @Override
    public String name() {
        return "=== Edit item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter ID: ");
        String editName = input.askStr("Enter new name: ");
        Item editItem = new Item(editName);
        boolean edit = tracker.replace(id, editItem);
        if (edit) {
            System.out.println("Item modified");
        } else {
            System.out.println("ID not found");
        }
        return true;
    }
}
