package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {

    private final ArrayList<Item> items = new ArrayList<>();

    public Item add(Item item) {
        if (item != null) {
            item.setId(generateId());
            items.add(item);
            return item;
        }
        return null;
    }

    public ArrayList<Item> findAll() {
        return items;
    }

    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> itemsFindByName = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                itemsFindByName.add(item);
            }
        }
        return itemsFindByName;
    }

    public Item findById(String id) {
        if (items.size() != 0) {
            for (Item item : items) {
                if (item.getId().equals(id)) {
                    return item;
                }
            }
        }
        return null;
    }

    public boolean replace(String id, Item item) {
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            items.set(index, item);
            return true;
        }
        return false;
    }

    public boolean delete(String id) {
        int index = indexOf(id);
        if (index != -1) {
            items.remove(findById(id));
            return true;
        }
        return false;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     *
     * @return Уникальный ключ.
     */
    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }

    private int indexOf(String id) {
        int rsl = -1;
        for (Item item : items) {
            if (item.getId().equals(id)) {
                rsl = items.indexOf(item);
            }
        }
        return rsl;
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
