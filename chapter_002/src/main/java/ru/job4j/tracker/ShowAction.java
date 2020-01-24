package ru.job4j.tracker;

import java.util.List;

public class ShowAction implements UserAction {

    @Override
    public String name() {
        return "=== Show all Items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        List<Item> resultList = tracker.findAll();
        if (resultList.size() == 0) {
            System.out.println("Not found");
        } else {
            for (Item show : resultList) {
                System.out.println("Item ID: " + show.getId() + ", Item name: " + show.getName());
            }
        }
        return true;
    }
}