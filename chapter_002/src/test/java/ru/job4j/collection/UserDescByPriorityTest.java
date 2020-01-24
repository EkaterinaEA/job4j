package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserDescByPriorityTest {

    @Test
    void compare() {
        List<User> users = Arrays.asList(
                new User("name3", 10),
                new User("name1", 30),
                new User("name2", 20)

        );
        Collections.sort(users, new UserDescByPriority());
        assertEquals(users.get(0).getName(), "name1");
        assertEquals(users.get(1).getName(), "name2");
        assertEquals(users.get(2).getName(), "name3");
        assertThat(users.get(0).getAge(), is(30));
        assertThat(users.get(1).getAge(), is(20));
        assertThat(users.get(2).getAge(), is(10));
    }
}