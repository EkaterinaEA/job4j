package ru.job4j.tracker;

public class FindByIdAction implements UserAction {

    @Override
    public String name() {
        return "=== Find item by Id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String findId = input.askStr("Enter ID: ");
        Item foundById = tracker.findById(findId);
        if (foundById != null) {
            System.out.println("Item ID: " + foundById.getId() + ", Item name: " + foundById.getName());
        } else {
            System.out.println("Not found");
        }
        return true;
    }
}
