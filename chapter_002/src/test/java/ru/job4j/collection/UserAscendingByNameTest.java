package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.hamcrest.core.Is.is;

import static org.junit.Assert.*;

class UserAscendingByNameTest {

    @Test
    void compare() {
        List<User> users = Arrays.asList(
                new User("name2", 10),
                new User("name1", 20),
                new User("name2", 20)

        );
        Collections.sort(users, new UserAscendingByName());
        assertEquals(users.get(0).getName(), "name1");
        assertEquals(users.get(1).getName(), "name2");
        assertEquals(users.get(2).getName(), "name2");
        assertThat(users.get(0).getAge(), is(20));
        assertThat(users.get(1).getAge(), is(10));
        assertThat(users.get(2).getAge(), is(20));
    }
}