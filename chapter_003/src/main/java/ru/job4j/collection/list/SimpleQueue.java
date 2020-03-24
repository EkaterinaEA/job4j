package ru.job4j.collection.list;

public class SimpleQueue<T> {

    private final SimpleStack<T> stack = new SimpleStack<>();
    private final SimpleStack<T> stackReverse = new SimpleStack<>();

    public void push(T value) {
        stack.push(value);
    }

    public T poll() {
        if (stackReverse.size() == 0) {
            int stackSize = stack.size();
            for(int i = 0; i < stackSize; i++) {
                stackReverse.push(stack.poll());
            }
        }
        return stackReverse.poll();
    }

    public int size() {
        return stack.size() + stackReverse.size();
    }

}
