package ru.job4j.collection.generic;

import org.junit.Assert;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class UserStoreTest {

    @Test
    public void whenAddAndGetSameElementShouldEquals() {
        UserStore userStore = new UserStore(4);
        User user = new User("user");
        userStore.add(user);
        assertThat(userStore.findById("user"), is(user));
    }

    @Test(expected = NoSuchElementException.class)
    public void replaceTest() {
        UserStore userStore = new UserStore(5);
        User user1 = new User("user1");
        User user2 = new User("user2");
        User user3 = new User("user3");
        userStore.add(user1);
        userStore.add(user2);
        userStore.replace("user2", user3);
        assertThat(userStore.findById("user1"), is(user1));
        assertThat(userStore.findById("user3"), is(user3));
        userStore.findById("user2");
    }

    @Test(expected = NoSuchElementException.class)
    public void deleteTest() {
        UserStore userStore = new UserStore(5);
        User user1 = new User("user1");
        User user2 = new User("user2");
        User user3 = new User("user3");
        userStore.add(user1);
        userStore.add(user2);
        userStore.add(user3);
        userStore.delete("user2");
        assertThat(userStore.findById("user1"), is(user1));
        assertThat(userStore.findById("user3"), is(user3));
        userStore.findById("user2");
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenAddGreaterThanSizeShouldException() {
        UserStore userStore = new UserStore(1);
        User user1 = new User("user1");
        User user2 = new User("user2");
        userStore.add(user1);
        userStore.add(user2);
    }

    @Test
    public void whenDeleteNotEddedShouldFalse() {
        UserStore userStore = new UserStore(3);
        User user1 = new User("user1");
        userStore.add(user1);
        Assert.assertFalse(userStore.delete("user2"));
    }

    @Test
    public void whenDeleteEmptyArrayShouldFalse() {
        UserStore userStore = new UserStore(3);
        Assert.assertFalse(userStore.delete("user"));
    }

    @Test
    public void whenReplaceEmptyArrayShouldFalse() {
        UserStore userStore = new UserStore(3);
        User user = new User("user");
        Assert.assertFalse(userStore.replace("user", user));
    }

    @Test
    public void whenReplaceIdNotPresentShouldFalse() {
        UserStore userStore = new UserStore(3);
        User user1 = new User("user1");
        User user2 = new User("user2");
        userStore.add(user1);
        Assert.assertFalse(userStore.replace("user", user2));
    }
}
