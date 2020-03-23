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
        next.setCurrentElement(e);
        firstNode = new Node<E>(null, next, null);
        next.setPrevElement(firstNode);
        size++;
        modCount++;
    }

    public void addLast(E e) {
        Node<E> prev = lastNode;
        prev.setCurrentElement(e);
        lastNode = new Node<E>(null, null, prev);
        prev.setNextElement(lastNode);
        size++;
        modCount++;
    }

    public int size() {
        return size;
    }

    public E getElementByIndex(int counter) {
        checkElementIndex(counter);
        Node<E> target = firstNode.getNextElement();
        for (int i = 0; i < counter; i++) {
            target = getNextElement(target);
        }
        return target.getCurrentElement();
    }

    private Node<E> getNextElement(Node<E> current) {
        return current.getNextElement();
    }

    private void checkElementIndex(int index) {
        if (!(index >= 0 && index < size)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", size: " + size);
        }
    }

    public Iterator<E> iterator() {

        final int expectedModCount = modCount;

        return new Iterator<E>() {
            int counter = 0;

            @Override
            public boolean hasNext() {
                return counter < size;
            }

            @Override
            public E next() {
                checkForModification();
                return getElementByIndex(counter++);
            }

            final void checkForModification() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }

    public Iterator<E> descendingIterator() {
        return new Iterator<E>() {
            int counter = size - 1;

            @Override
            public boolean hasNext() {
                return counter >= 0;
            }

            @Override
            public E next() {
                return getElementByIndex(counter--);
            }
        };
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

        public E getCurrentElement() {
            return currentElement;
        }

        public void setCurrentElement(E currentElement) {
            this.currentElement = currentElement;
        }

        public Node<E> getNextElement() {
            return nextElement;
        }

        public void setNextElement(Node<E> nextElement) {
            this.nextElement = nextElement;
        }

        public void setPrevElement(Node<E> prevElement) {
            this.prevElement = prevElement;
        }
    }

}
