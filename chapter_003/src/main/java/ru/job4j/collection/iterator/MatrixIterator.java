package ru.job4j.collection.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIterator implements Iterator<Integer> {

    private final int[][] array;
    private int x = 0;
    private int y = 0;

    public MatrixIterator(int[][] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return x < this.array.length && y < this.array[x].length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int next = this.array[x][y];
        if (array[x].length - 1 > y) {
            y++;
        } else {
            x++;
            y = 0;
        }
        return next;
    }
}
