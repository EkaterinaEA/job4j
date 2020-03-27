package ru.job4j.collection.generic;

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
        marker++;
    }

    public void remove(int index) throws ArrayIndexOutOfBoundsException {
        checkSize(index);
        System.arraycopy(this.array, index + 1, this.array, index, marker - index);
        this.array[marker] = null;
        marker--;
    }

    public T get(int index) {
        return (index < marker) ? (T) this.array[index] : null;
    }

    private void checkSize(int index) throws ArrayIndexOutOfBoundsException {
        if (index > marker || marker == 0) {
            throw new ArrayIndexOutOfBoundsException("no element");
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < array.length;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) array[index++];
            }
        };
    }
}
