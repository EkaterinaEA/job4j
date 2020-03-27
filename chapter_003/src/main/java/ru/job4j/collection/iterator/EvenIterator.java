package ru.job4j.collection.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator<Integer> {

    private final int[] array;
    private int count = 0;
    private int nextEvenIndex;

    public EvenIterator(int[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        boolean hasNext = false;
        while (count < array.length && array[count] % 2 != 0) {
            count++;
        }
        if (count < array.length) {
            nextEvenIndex = count;
            hasNext = true;
        }
        return hasNext;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException("no next element");
        }
        count = nextEvenIndex + 1;
        return array[nextEvenIndex];
    }

}
