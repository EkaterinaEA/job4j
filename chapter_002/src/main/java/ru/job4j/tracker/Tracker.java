package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Random;

public class Tracker {

    private final ArrayList<Item> items = new ArrayList<>();

    public Item add(Item item) {
        item.setId(this.generateId());
        items.add(item);
        return item;
    }

    public void update(String id, Item item) {
        if (indexOf(id) != -1) {
            item.setId(id);
            items.set(indexOf(id), item);
        } else {
            System.out.println("id doesn't exist!");
        }
    }

    public void delete(String id) {
        if (indexOf(id) != 1) {
            items.remove(indexOf(id));
        } else {
            System.out.println("id doesn't exist!");
        }
    }

    public ArrayList<Item> findAll() {
        ArrayList<Item> itemsWithoutNull = new ArrayList<>();
        for (Item item : items) {
            if (item != null) {
                itemsWithoutNull.add(item);
            }
        }
        return itemsWithoutNull;
    }

    public ArrayList<Item> findByName(String name) {
        ArrayList<Item> itemsEqualByName = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(name)) {
                itemsEqualByName.add(item);
            }
        }
        return itemsEqualByName;
    }

    public Item findById(String id) {
        if (indexOf(id) != -1) {
            return items.get(indexOf(id));
        } else {
            System.out.println("id doesn't exist!");
            return null;
        }
    }

    private int indexOf(String id) {
        int rsl = -1;
        for(int index = 0; index < items.size(); index++) {
            if (items.get(index).getId().equals(id)) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    private String generateId() {
        Random random = new Random();
        return String.valueOf(random.nextLong() + System.currentTimeMillis());
    }
}
