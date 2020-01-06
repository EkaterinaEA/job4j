package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {

    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод реализующий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        if (item != null){
            item.setId(this.generateId());
            this.items[this.position++] = item;
        }
        return item;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, position);
    }

    public Item[] findByName(String key) {
        Item[] itemsFindByName = new Item[items.length];
        int size = 0;
        for (int index = 0; index < position; index++) {
                if (items[index] != null && items[index].getName().equals(key)) {
                    itemsFindByName[size++] = items[index];
                }
            }
        return Arrays.copyOf(itemsFindByName, size);
    }

    public Item findById(String id) {
        int index = indexOf(id);
        if (index == -1){
            return null;
        } else {
            return items[index];
        }
    }

    public boolean replace(String id, Item item) {
        int index = indexOf(id);
        if (index != -1) {
            items[index] = item;
            items[index].setId(id);
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(String id) {
        int index = indexOf(id);
        if (index != -1) {
            items[index] = null;
            System.arraycopy(items, index + 1, items, index, position - index);
            items[position] = null;
            position--;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }

    private int indexOf(String id) {
        int rsl = -1;
        for (int index = 0; index < position; index++) {
            if (items[index] != null && items[index].getId().equals(id)) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }
}
