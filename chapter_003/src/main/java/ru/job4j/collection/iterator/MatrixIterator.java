package ru.job4j.collection.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIterator implements Iterator<Integer> {

    private final Integer[][] array;
    private int x = 0;
    private int y = 0;

    public MatrixIterator(Integer[][] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        while (compareWithLength() && array[x][y] == null) {
            moveItemIndex();
        }
        return compareWithLength();
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int next = this.array[x][y];
        moveItemIndex();
        return next;
    }

    private void moveItemIndex() {
        if (array[x].length - 1 > y) {
            y++;
        } else {
            x++;
            y = 0;
        }
    }

    private boolean compareWithLength() {
        return x < this.array.length && y < this.array[x].length;
    }
}
