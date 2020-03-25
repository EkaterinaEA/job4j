package ru.job4j.collection.set;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleSetTest {

    @Test
    public void whenAdd3ElementsShouldGetSame3() {
        List<String> expected = List.of("one", "two", "three");
        SimpleSet<String> set = new SimpleSet<>();
        expected.forEach(set::add);
        List<String> actual = new ArrayList<>();
        for (String str : set) {
            actual.add(str);
        }
        assertThat(actual, is(expected));
    }

    @Test
    public void whenAdd2DifferentElements4TimesShouldGetOnly2Diff() {
        List<String> expected = List.of("one", "two");
        SimpleSet<String> set = new SimpleSet<>();
        expected.forEach(set::add);
        expected.forEach(set::add);
        expected.forEach(set::add);
        expected.forEach(set::add);
        List<String> actual = new ArrayList<>();
        for (String str : set) {
            actual.add(str);
        }
        assertThat(actual, is(expected));
    }

    @Test
    public void whenAddOneNullFiveShouldGetOneNullFive() {
        List<Integer> expected = Arrays.asList(1, null, 5);
        SimpleSet<Integer> set = new SimpleSet<>();
        expected.forEach(set::add);
        List<Integer> actual = new ArrayList<>();
        for (Integer value: set) {
            actual.add(value);
        }
        assertThat(actual, is(expected));
    }

    @Test
    public void whenAdd2SameElementsShouldGetOnly() {
        List<String> list = List.of("one", "one");
        SimpleSet<String> set = new SimpleSet<>();
        list.forEach(set::add);
        List<String> actual = new ArrayList<>();
        for (String str : set) {
            actual.add(str);
        }
        assertThat(actual.size(), is(1));
        assertThat(actual.get(0), is("one"));
    }
}
