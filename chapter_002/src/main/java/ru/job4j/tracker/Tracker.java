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

    public Item[] findAll(){
        Item[] itemsWithoutNull = new Item[items.length];
        int size = 0;
        for (int index = 0; index < items.length; index++) {
            Item temp = items[index];
            if (temp != null) {
                itemsWithoutNull[size] = temp;
                size++;
            }
        }
        itemsWithoutNull = Arrays.copyOf(itemsWithoutNull, size);
        return itemsWithoutNull;
    }

    public ArrayList<Item> findByName(String key){
        ArrayList<Item> itemsFindByName = new ArrayList<Item>();
        for (Item item : items) {
            if (item != null && item.getName().equals(key)){
                itemsFindByName.add(item);
            }
        }
        return itemsFindByName;
    }

    public Item findById(String id){
        for (Item item : items) {
            if (item != null && item.getId().equals(id)){
                return item;
            }
        }
        return null;
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

    public static void main(String[] args) {
        Item item = new Item("name");
        Item item1 = null;
        Item item2 = new Item("name2");
        Tracker tracker = new Tracker();
        tracker.add(item);
        tracker.add(item1);
        tracker.add(item2);
        tracker.findAll();
        System.out.println(tracker.findById(tracker.findAll()[0].getId()).getName());
        System.out.println(tracker.findByName("name").get(0).getName());
    }
}
