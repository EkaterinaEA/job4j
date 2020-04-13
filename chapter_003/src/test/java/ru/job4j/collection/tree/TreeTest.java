package ru.job4j.collection.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TreeTest {
    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }

    @Test
    public void whenAddDuplicateChildShouldFalse() {
        Tree<Integer> tree = new Tree<>(5);
        assertTrue(tree.add(5, 7));
        assertFalse(tree.add(7, 7));
    }

    @Test
    public void whenBinaryShouldIsBinaryTrue() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(3, 4);
        tree.add(3, 5);
        assertTrue(tree.isBinary());
    }

    @Test
    public void whenNotBinaryShouldIsBinaryFalse() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(3, 4);
        tree.add(3, 5);
        tree.add(3, 6);
        assertFalse(tree.isBinary());
    }

    @Test
    public void whenAddSomeElementsShouldGetIterator() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(3, 4);
        tree.add(3, 5);
        List<Integer> list = new ArrayList<>();
        for (Integer el : tree) {
            list.add(el);
        }
        assertThat(List.of(1, 2, 3, 4, 5), containsInAnyOrder(list.toArray()));
    }
}
