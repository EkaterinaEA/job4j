package ru.job4j.collection.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements Iterable<E> {

    private Node<E> firstNode;
    private Node<E> lastNode;
    private int size = 0;
    private int modCount = 0;

    public LinkedList() {
        lastNode = new Node<E>(null, null, firstNode);
        firstNode = new Node<E>(null, lastNode, null);
    }

    public void addFirst(E e) {
        Node<E> next = firstNode;
        next.currentElement = e;
        firstNode = new Node<E>(null, next, null);
        next.prevElement = firstNode;
        size++;
        modCount++;
    }

    public void addLast(E e) {
        Node<E> prev = lastNode;
        prev.currentElement = e;
        lastNode = new Node<E>(null, null, prev);
        prev.nextElement = lastNode;
        size++;
        modCount++;
    }

    public int size() {
        return size;
    }

    public E getElementByIndex(int counter) {
        checkElementIndex(counter);
        Node<E> target = firstNode.nextElement;
        for (int i = 0; i < counter; i++) {
            target = getNextElement(target);
        }
        return target.currentElement;
    }

    private Node<E> getNextElement(Node<E> current) {
        return current.nextElement;
    }

    private void checkElementIndex(int index) {
        if (!(index >= 0 && index < size)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", size: " + size);
        }
    }

    public Iterator<E> iterator() {

        final int expectedModCount = modCount;

        return new Iterator<E>() {
            Node<E> current = firstNode.nextElement;

            @Override
            public boolean hasNext() {
                return current.nextElement != null;
            }

            @Override
            public E next() {
                if (current.nextElement == null) {
                    throw new IndexOutOfBoundsException();
                }
                E next = current.currentElement;
                checkForModification();
                current = current.nextElement;
                return next;
            }

            final void checkForModification() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }

    public Iterator<E> descendingIterator() {
        final int expectedModCount = modCount;
        return new Iterator<E>() {
            Node<E> current = lastNode.prevElement;

            @Override
            public boolean hasNext() {
                return current.prevElement != null;
            }

            @Override
            public E next() {
                if (current.prevElement == null) {
                    throw new IndexOutOfBoundsException();
                }
                E next = current.currentElement;
                checkForModification();
                current = current.prevElement;
                return next;
            }

            final void checkForModification() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }

    private E unlinkFirst(Node<E> f) {
        final E element = f.nextElement.currentElement;
        final Node<E> next = f.nextElement;
        f.currentElement = null;
        f.nextElement = null;
        firstNode = next;
        if (next == null) {
            lastNode = null;
        } else {
            next.prevElement = null;
        }
        size--;
        modCount++;
        return element;
    }

    public E removeFirst() {
        final Node<E> f = firstNode;
        E removed = null;
        if (f != null) {
            removed = unlinkFirst(f);
        }
        return removed;
    }

    public E pop(){
        if (size == 0) {
            System.out.println("List is empty");
        }
        Node<E> lastFirst = firstNode;
        firstNode = firstNode.nextElement;
        size --;
        return lastFirst.nextElement.currentElement;
    }

    private class Node<E> {

        private E currentElement;
        private Node<E> nextElement;
        private Node<E> prevElement;

        public Node(E currentElement, Node<E> nextElement, Node<E> prevElement) {
            this.currentElement = currentElement;
            this.nextElement = nextElement;
            this.prevElement = prevElement;
        }
    }

}
