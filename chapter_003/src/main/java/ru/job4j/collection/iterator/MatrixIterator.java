package ru.job4j.collection.iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIterator implements Iterator<Integer> {

    private final int[][] array;
    private final long size;
    private int x = 0;
    private int y = 0;
    private long count = 0;

    public MatrixIterator(int[][] array) {
        this.array = array;
        this.size = Arrays.stream(array).flatMapToInt(Arrays::stream).count();
    }

    @Override
    public boolean hasNext() {
        return count < this.size;
    }

    @Override
    public Integer next() {
        int next;
        try {
            next = this.array[this.x][this.y];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new NoSuchElementException("no next element");
        }
        if (this.array[this.x].length - 1 > this.y) {
            this.y++;
        } else {
            if (this.array.length - 1 > this.x) {
                this.x++;
                this.y = 0;
            }
        }
        count++;
        return next;
    }
}
