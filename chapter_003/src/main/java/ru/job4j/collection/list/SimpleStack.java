package ru.job4j.collection.list;

public class SimpleStack<T> {

    private final LinkedList<T> linkedList = new LinkedList<>();

    public T poll() {
        return linkedList.removeFirst();
    }

    public void push(T value) {
        linkedList.addFirst(value);
    }

    public int size() {
        return linkedList.size();
    }

    public T get(int index) {
        return linkedList.getElementByIndex(index);
    }

    public T pop() {
        return linkedList.pop();
    }
}
