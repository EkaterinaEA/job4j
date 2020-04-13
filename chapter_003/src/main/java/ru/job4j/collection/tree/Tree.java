package ru.job4j.collection.tree;

import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    private final Node<E> root;

    public Tree(E rootValue) {
        this.root = new Node<>(rootValue);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        if (findBy(child).isEmpty()) {
            Optional<Node<E>> node = findBy(parent);
            if (node.isPresent()) {
                node.get().add(new Node<>(child));
                result = true;
            }
        }
        return result;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el != null) {
                if (el.eqValue(value)) {
                    rsl = Optional.of(el);
                    break;
                }
                for (Node<E> child : el.showChildren()) {
                    data.offer(child);
                }
            }
        }
        return rsl;
    }

    public boolean isBinary() {
        boolean isBinary = true;
        final Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (Objects.requireNonNull(el).showChildren().size() > 2) {
                isBinary = false;
                break;
            }
            for (Node<E> child : Objects.requireNonNull(el).showChildren()) {
                data.offer(child);
            }
        }
        return isBinary;
    }

    @Override
    public Iterator<E> iterator() {
        return new TreeIterator<>();
    }

    private class TreeIterator<T extends Comparable<T>> implements Iterator<T> {

        private final Queue<Node<T>> data = new LinkedList<>();

        public TreeIterator() {
            data.offer((Node<T>) root);
        }

        @Override
        public boolean hasNext() {
            return !data.isEmpty();
        }

        @Override
        public T next() {
            Node<T> value = data.poll();
            for (Node<T> child : Objects.requireNonNull(value).showChildren()) {
                data.offer(child);
            }
            return value.getValue();
        }
    }
}
