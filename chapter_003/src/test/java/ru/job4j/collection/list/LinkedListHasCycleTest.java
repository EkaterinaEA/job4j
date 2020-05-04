package ru.job4j.collection.list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListHasCycleTest {

    ForwardLinkedList.Node<Integer> first;
    ForwardLinkedList.Node<Integer> two;
    ForwardLinkedList.Node<Integer> third;
    ForwardLinkedList.Node<Integer> four;

    @Before
    public void initNodes() {
        first = new ForwardLinkedList.Node<>(1);
        two = new ForwardLinkedList.Node<>(2);
        third = new ForwardLinkedList.Node<>(3);
        four = new ForwardLinkedList.Node<>(4);
    }

    @Test
    public void whenHasLoopShouldTrue() {
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;
        assertTrue(new ForwardLinkedList().hasLoop(first));
    }

    @Test
    public void whenHasLoopInsideShouldTrue() {
        first.next = two;
        two.next = third;
        third.next = two;
        four.next = first;
        assertTrue(new ForwardLinkedList().hasLoop(first));
    }

    @Test
    public void whenHasNoCycleShouldFalse() {
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = null;
        assertFalse(new ForwardLinkedList().hasLoop(first));
    }
}
