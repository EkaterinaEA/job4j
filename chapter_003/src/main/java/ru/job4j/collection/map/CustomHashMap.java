package ru.job4j.collection.map;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomHashMap<K, V> implements Iterable<V> {

    private int size = 0;

    private static class Node<K, V> {
        final K key;
        final V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public final String toString() {
            return key + " = " + value;
        }
    }

    private Node<K, V>[] table;

    static int hash(Object key) {
        int h;
        if (key == null) {
            h = 0;
        } else {
            h = key.hashCode();
            h = h ^ (h >>> 16);
        }
        return h;
    }

    public CustomHashMap() {
        table = (Node<K, V>[]) new Node[16];
    }

    private int indexFor(int hash) {
        return hash & (table.length - 1);
    }

    private void resize(int size) {
        Node<K, V>[] oldTab = table;
        table = (Node<K, V>[]) new Node[size];
        for (Node<K, V> node : oldTab) {
            if (node != null) {
                K key = node.key;
                V value = node.value;
                int hash = hash(key);
                int index = indexFor(hash);
                table[index] = new Node<>(key, value);
            }
        }
    }

    public boolean insert(K key, V value) {
        boolean result = false;
        if (size == table.length) {
            resize(size * 2);
        }
        int hash = hash(key);
        int index = indexFor(hash);
        Node<K, V> oldValue = table[index];
        if (oldValue == null) {
            table[index] = new Node<>(key, value);
            result = true;
            size++;
        } else if (oldValue.key.equals(key)) {
            table[index] = new Node<>(key, value);
            result = true;
        }
        return result;
    }

    public V get(K key) {
        int hash = hash(key);
        int index = indexFor(hash);
        V value = null;
        Node<K, V> node = table[index];
        if (node != null) {
            if ((node.key == null && key == null) || (node.key != null && node.key.equals(key))) {
                value = node.value;
            }
        }
        return value;
    }

    public boolean delete(K key) {
        boolean result = false;
        if (table.length > 0) {
            int hash = hash(key);
            int index = indexFor(hash);
            Node<K, V> node = table[index];
            if (node != null && key.equals(node.key)) {
                table[index] = null;
                result = true;
                size--;
            }
        }
        return result;
    }

    private class CustomHashMapIterator implements Iterator<V> {

        private int index = 0;
        Node<K, V> node = null;

        @Override
        public boolean hasNext() {
            boolean hasNext = false;
            if (index < table.length) {
                do {
                    node = table[index++];
                } while (node == null && index < table.length);
                hasNext = (node != null);
                index--;
            }
            return hasNext;
        }

        @Override
        public V next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return table[index++].value;
        }
    }

    @Override
    public Iterator<V> iterator() {
        return new CustomHashMapIterator();
    }
}
