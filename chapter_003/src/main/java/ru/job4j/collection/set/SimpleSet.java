package ru.job4j.collection.set;

import ru.job4j.collection.list.SimpleArrayList;

import java.util.Iterator;

public class SimpleSet<E> implements Iterable<E> {

    private final SimpleArrayList<E> list;

    public SimpleSet() {
        this.list = new SimpleArrayList<E>();
    }

    public void add(E e) {
        if (contains(e)) {
            list.add(e);
        }
    }

    private boolean contains(E e) {
        boolean isNew = true;
        for (E item : list) {
            if (item == null) {
                if (e == null) {
                    isNew = false;
                    break;
                }
            } else if (item.equals(e)) {
                isNew = false;
                break;
            }
        }
        return isNew;
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }
}
