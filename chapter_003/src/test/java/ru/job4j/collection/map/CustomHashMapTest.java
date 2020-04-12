package ru.job4j.collection.map;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CustomHashMapTest {

    @Test
    public void whenInsertValueByKeyShouldGetByKeySameValue() {
        CustomHashMap<String, Integer> hashMap = new CustomHashMap<>();
        hashMap.insert("first", 101);
        assertThat(hashMap.get("first"), is(101));
    }

    @Test
    public void getKeyDoesNotExistShouldNull() {
        CustomHashMap<String, Integer> hashMap = new CustomHashMap<>();
        assertNull(hashMap.get("first"));
    }

    @Test
    public void whenInsertOneKeyMoreOneTimesShouldGetByKeyLastValue() {
        CustomHashMap<String, Integer> hashMap = new CustomHashMap<>();
        hashMap.insert("first", 101);
        assertTrue(hashMap.insert("first", 10101));
        assertThat(hashMap.get("first"), is(10101));
    }

    @Test
    public void whenDeleteValueShouldGetNullByKey() {
        CustomHashMap<String, Integer> hashMap = new CustomHashMap<>();
        assertTrue(hashMap.insert("first", 101));
        assertThat(hashMap.get("first"), is(101));
        assertTrue(hashMap.delete("first"));
        assertNull(hashMap.get("first"));
    }

    @Test
    public void whenAddMoreThan16ValuesShouldIncreaseSize() {
        CustomHashMap<Integer, Integer> hashMap = new CustomHashMap<>();
        for (int i = 0; i < 16; i++) {
            hashMap.insert(i , i);
        }
        assertTrue(hashMap.insert(17, 17));
        assertThat(hashMap.get(17), is(17));
    }

    @Test
    public void whenDeleteValueNotPresentShouldFalse() {
        CustomHashMap<String, Integer> hashMap = new CustomHashMap<>();
        assertFalse(hashMap.delete("first"));
    }

    @Test
    public void whenUseIteratorShouldReturnAllValue() {
        CustomHashMap<Integer, Integer> hashMap = new CustomHashMap<>();
        List<Integer> expected = new ArrayList<>(List.of(5, 7, 8));
        expected.forEach(s -> assertTrue(hashMap.insert(s, s)));
        List<Integer> actual = new ArrayList<>();
        for (Integer value : hashMap) {
            actual.add(value);
        }
        assertThat(actual, containsInAnyOrder(expected.toArray()));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNextMoreElementsShouldException() {
        CustomHashMap<Integer, Integer> hashMap = new CustomHashMap<>();
        List<Integer> expected = new ArrayList<>(List.of(5, 7, 8, 15));
        expected.forEach(s -> assertTrue(hashMap.insert(s, s)));
        Iterator<Integer> iterator = hashMap.iterator();
        assertThat(iterator.next(), is(5));
        assertThat(iterator.next(), is(7));
        assertThat(iterator.next(), is(8));
        assertThat(iterator.next(), is(15));
        iterator.next();
    }

    @Test
    public void whenHasNextManyTimesAndNext1TimesShouldNextElement() {
        CustomHashMap<Integer, Integer> hashMap = new CustomHashMap<>();
        List<Integer> expected = new ArrayList<>(List.of(5, 7, 8));
        expected.forEach(s -> assertTrue(hashMap.insert(s, s)));
        Iterator<Integer> iterator = hashMap.iterator();
        assertTrue(iterator.hasNext());
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is(5));
    }

}
