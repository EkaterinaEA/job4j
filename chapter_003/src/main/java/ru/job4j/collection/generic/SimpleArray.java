package ru.job4j.collection.generic;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {

    private final Object[] array;
    private int marker;

    public SimpleArray(int size) {
        this.array = new Object[size];
    }

    public void add(T model) throws ArrayIndexOutOfBoundsException {
        this.array[marker++] = model;
    }

    public void set(int index, T model) throws ArrayIndexOutOfBoundsException {
        if (marker != 0) {
            checkSize(index);
        }
        this.array[index] = model;
    }

    public void remove(int index) throws ArrayIndexOutOfBoundsException {
        checkSize(index);
        System.arraycopy(this.array, index + 1, this.array, index, marker - index);
        this.array[marker] = null;
        marker--;
    }

    public T get(int index) {
        return (index < this.array.length) ? (T) this.array[index] : null;
    }

    private void checkSize(int index) throws ArrayIndexOutOfBoundsException {
        if (index > marker || marker == 0) {
            throw new ArrayIndexOutOfBoundsException("no element");
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new SimpleArrayIterator(marker, (Iterator<T>) Arrays.stream(this.array).iterator());
    }

    private class SimpleArrayIterator implements Iterator<T> {

        private final int size;
        private int marker;
        private final Iterator<T> arrayIterator;

        public SimpleArrayIterator(int size, Iterator<T> arrayIterator) {
            this.size = size;
            this.arrayIterator = arrayIterator;
            marker = 0;
        }

        @Override
        public boolean hasNext() {
            return (marker <= size - 1) && arrayIterator.hasNext();
        }

        @Override
        public T next() {
            if (marker > size - 1) {
                throw new NoSuchElementException("no element");
            }
            marker++;
            return arrayIterator.next();
        }
    }
}
