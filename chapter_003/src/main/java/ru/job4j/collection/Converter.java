package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter implements Iterator<Integer> {

    private Iterator<Iterator<Integer>> iterators;
    private Iterator<Integer> current;

    public Converter() {}

    public Converter(Iterator<Iterator<Integer>> iterators) {
        this.iterators = iterators;
        this.current = iterators.hasNext() ? iterators.next() : null;
    }

    public Iterator<Integer> convert(Iterator<Iterator<Integer>> iterators) {
        return new Converter(iterators);
    }

    @Override
    public boolean hasNext() {
        boolean hasNext = false;
        if (current != null) {
            hasNext = current.hasNext();
            while (!hasNext && iterators.hasNext()) {
                current = iterators.next();
                hasNext = current.hasNext();
            }
        }
        return hasNext;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException("no next element");
        }
        if (!current.hasNext()) {
            current = iterators.next();
        }
        return current.next();
    }
}
