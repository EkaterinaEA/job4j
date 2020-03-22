package ru.job4j.collection.list;

import java.util.*;

public class SimpleArrayList<E> implements Iterable<E> {

    private int size;
    private Object[] container;
    private int modCount;
    private static final int DEFAULT_CAPACITY = 10;

    public SimpleArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public SimpleArrayList(int capacity) {
        this.container = new Object[capacity];
        modCount = 0;
    }

    public int increaseCapacity() {
        int oldCapacity = container.length;
        return (oldCapacity + (oldCapacity / 2));
    }

    private Object[] increaseArray() {
        container = Arrays.copyOf(container, increaseCapacity());
        return container;
    }

    private void addElement(E element, Object[] container, int currentSize) {
        if (currentSize == container.length) {
            container = increaseArray();
        }
        container[currentSize] = element;
        size = currentSize + 1;
    }

    public void add(E element) {
        modCount++;
        addElement(element, container, size);
    }

    public E get(int index) {
        Objects.checkIndex(index, size);
        return (E) container[index];
    }

    private class IteratorArrayList implements Iterator<E> {

        int marker;
        final int expectedModCount = modCount;

        IteratorArrayList() {}

        final void checkModification() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        @Override
        public boolean hasNext() {
            return marker != size;
        }

        @Override
        public E next() {
            checkModification();
            int i = marker;
            if (i >= size) {
                throw new NoSuchElementException();
            }
            Object[] container = SimpleArrayList.this.container;
            if (i >= container.length) {
                throw new ConcurrentModificationException();
            }
            marker = i + 1;
            return (E) container[i];
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new SimpleArrayList.IteratorArrayList();
    }
}
