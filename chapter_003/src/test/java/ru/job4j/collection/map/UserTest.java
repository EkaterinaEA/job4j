package ru.job4j.collection.map;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void whenEqualsAnsHashCodeNotRedefined() {
        User user1 = new User("user", 0, new GregorianCalendar(2017, 0, 25));
        User user2 = new User("user", 0, new GregorianCalendar(2017, 0, 25));

        Map<User, Object> map = new HashMap<>();
        map.put(user1, new Object());
        map.put(user2, new Object());

        assertThat(map.size(), is(2));
        System.out.println(map);
        System.out.println(map.get(user1));
        System.out.println(map.get(user2));
        assertTrue(user1.equals(user2));
    }

}