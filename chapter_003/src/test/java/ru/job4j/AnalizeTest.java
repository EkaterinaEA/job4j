package ru.job4j;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AnalizeTest {

    private List<Analize.User> previous;
    private List<Analize.User> current;
    private Analize analize = new Analize();
    private Analize.User user1;
    private Analize.User user2;
    private Analize.User user3;
    private Analize.User user4;

    @Before
    public void setUp() {
        user1 = new Analize.User(1, "user1");
        user2 = new Analize.User(2, "user2");
        user3 = new Analize.User(3, "user3");
        user4 = new Analize.User(4, "user4");
    }

    @Test
    public void addTest() {
        previous = List.of(user1);
        current = List.of(user1, user2, user3);
        assertThat(analize.diff(previous, current).added, is(2));
    }

    @Test
    public void deleteTest() {
        previous = List.of(user1, user2, user3);
        current = List.of(user1);
        assertThat(analize.diff(previous, current).deleted, is(2));
    }

    @Test
    public void changeTest() {
        current = List.of(user1, user2);
        Analize.User changeUser1 = new Analize.User(1, "change");
        Analize.User changeUser2 = new Analize.User(2, "change");
        previous = List.of(changeUser1, changeUser2);
        assertThat(analize.diff(previous, current).changed, is(2));
    }

    @Test
    public void addAndDeleteAndChangeTest() {
        current = List.of(user1, user2);
        Analize.User changeUser1 = new Analize.User(1, "change");
        previous = List.of(changeUser1, user3);
        assertThat(analize.diff(previous, current).added, is(1));
        assertThat(analize.diff(previous, current).changed, is(1));
        assertThat(analize.diff(previous, current).deleted, is(1));
    }
}