package ru.job4j.collection.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinkedList<T> implements Iterable<T> {

    private Node<T> head;
    private int size = 0;
    private int modCount = 0;

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
        this.size++;
        this.modCount++;
    }

    public int size() {
        int length = 0;
        Node current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    public void revert() {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            Node<T> node = head;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                checkForModifications();
                return node != null;
            }

            @Override
            public T next() {
                checkForModifications();
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }

            private void checkForModifications() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }

    public static class Node<T> {
        public T value;
        public Node<T> next;

        public Node(T value) {
            this.value = value;
        }

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }


    // Алгоритм «черепахи и зайца» Флойда определяющий, что список содержит замыкания.
    // список может быть замкнут и в середине. К примеру, 3-й узел будет ссылаться на 2-й узел.
    // Определение зацикленности реализовано путем прохода по узлам, без использования коллекций.
    public boolean hasLoop(Node first) {
        Node tortoise = first;
        Node hare = first;

        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if (tortoise == hare) {
                return true;
            }
        }
        return false;
    }

}
