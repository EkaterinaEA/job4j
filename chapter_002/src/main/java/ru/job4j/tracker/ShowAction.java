package ru.job4j.tracker;

public class ShowAction implements UserAction {

    @Override
    public String name() {
        return "=== Show all Items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] resultList = tracker.findAll();
        if (resultList.length == 0) {
            System.out.println("Not found");
        } else {
            for (Item show : resultList) {
                System.out.println("Item ID: " + show.getId() + ", Item name: " + show.getName());
            }
        }
        return true;
    }
}