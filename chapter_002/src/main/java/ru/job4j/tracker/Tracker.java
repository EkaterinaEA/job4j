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
        }
        this.items[this.position++] = item;
        return item;
    }

    public Item[] findAll() {
        int size = 0;
        if (items != null) {
            for (Item item : items) {
                if (item != null) {
                    items[size] = item;
                    size++;
                }
            }
        }
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] itemsFindByName = new Item[items.length];
        int size = 0;
        if (items != null) {
            for (Item item : items) {
                if (item != null && item.getName().equals(key)) {
                    itemsFindByName[size] = item;
                    size++;
                }
            }
        }
        return Arrays.copyOf(itemsFindByName, size);
    }

    public Item findById(String id) {
        if (indexOf(id) == -1){
            return null;
        } else {
            return items[indexOf(id)];
        }
    }

    public void replace(String id, Item item) {
        int index = indexOf(id);
        items[index] = item;
        items[index].setId(id);
    }

    public void delete(String id) {
        int index = indexOf(id);
        items[indexOf(id)] = null;
        System.arraycopy(items, index + 1, items, index, position - index);
        items[position] = null;
        position--;
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
