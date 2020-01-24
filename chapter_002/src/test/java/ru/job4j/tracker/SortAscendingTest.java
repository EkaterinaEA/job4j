package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SortAscendingTest {

    @Test
    void sortAscending() {
        List<Item> items = Arrays.asList(
                new Item("name1"),
                new Item("name3"),
                new Item("name2")
        );
        Collections.sort(items, new SortAscending());
        assertEquals(items.get(0).getName(), "name1");
        assertEquals(items.get(1).getName(), "name2");
        assertEquals(items.get(2).getName(), "name3");
    }

}