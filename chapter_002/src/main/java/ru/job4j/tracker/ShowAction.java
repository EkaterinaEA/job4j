package ru.job4j.tracker;

import java.util.List;
import java.util.function.Consumer;

public class ShowAction implements UserAction {

    private Consumer<String> output;

    @Override
    public String name() {
        return "=== Show all Items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        List<Item> resultList = tracker.findAll();
        if (resultList.size() == 0) {
            output.accept("Not found");
        } else {
            for (Item show : resultList) {
                output.accept("Item ID: " + show.getId() + ", Item name: " + show.getName());
            }
        }
        return true;
    }
}