package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ItemSorter {

    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
                new Item("name1"),
                new Item("name3"),
                new Item("name2")
        );
        System.out.println(items);
        Collections.sort(items, new SortAscending());
        System.out.println(items);
        Collections.sort(items, new SortDescending());
        System.out.println(items);
    }

}

