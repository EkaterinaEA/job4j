package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ComparatorTest {

    @Test
    public void sort() {
        List<Item> items = Arrays.asList(new Item("name1"), new Item("name2"), new Item("name3"));
        Collections.sort(items, new ItemComparator());
        List<Item> expected = Arrays.asList(new Item("name1"), new Item("name2"), new Item("name3"));
        assertThat(items, is(expected));
    }

    @Test
    public void sortReverse() {
        List<Item> items = Arrays.asList(new Item("name1"), new Item("name2"), new Item("name3"));
        Collections.sort(items, new ItemReverseComparator());
        List<Item> expected = Arrays.asList(new Item("name3"), new Item("name2"), new Item("name1"));
        assertThat(items, is(expected));
    }

}
