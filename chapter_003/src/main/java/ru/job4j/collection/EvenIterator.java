package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator<Integer> {

    private final int[] array;
    private int count = 0;

    public EvenIterator(int[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        boolean hasNext = false;
        for (int i = count; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                hasNext = true;
                break;
            }
        }
        return hasNext;
    }

    @Override
    public Integer next() {
        Integer next = null;
        for (int i = count; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                next = array[i];
                count = ++i;
                break;
            }
        }
        if (next == null) {
            throw new NoSuchElementException("no next element");
        }
        return next;
    }

}
