package ru.job4j.collection.generic;

import org.junit.Assert;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class RoleStoreTest {

    @Test
    public void whenAddAndGetSameElementShouldEquals() {
        RoleStore roleStore = new RoleStore(4);
        Role role = new Role("role");
        roleStore.add(role);
        assertThat(roleStore.findById("role"), is(role));
    }

    @Test(expected = NoSuchElementException.class)
    public void replaceTest() {
        RoleStore roleStore = new RoleStore(5);
        Role role1 = new Role("role1");
        Role role2 = new Role("role2");
        Role role3 = new Role("role3");
        roleStore.add(role1);
        roleStore.add(role2);
        roleStore.replace("role2", role3);
        assertThat(roleStore.findById("role1"), is(role1));
        assertThat(roleStore.findById("role3"), is(role3));
        roleStore.findById("role2");
    }

    @Test(expected = NoSuchElementException.class)
    public void deleteTest() {
        RoleStore roleStore = new RoleStore(5);
        Role role1 = new Role("role1");
        Role role2 = new Role("role2");
        Role role3 = new Role("role3");
        roleStore.add(role1);
        roleStore.add(role2);
        roleStore.add(role3);
        roleStore.delete("role2");
        assertThat(roleStore.findById("role1"), is(role1));
        assertThat(roleStore.findById("role3"), is(role3));
        roleStore.findById("role2");
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenAddGreaterThanSizeShouldException() {
        RoleStore roleStore = new RoleStore(1);
        Role role1 = new Role("role1");
        Role role2 = new Role("role2");
        roleStore.add(role1);
        roleStore.add(role2);
    }

    @Test
    public void whenDeleteNotEddedShouldFalse() {
        RoleStore roleStore = new RoleStore(3);
        Role role1 = new Role("role1");
        roleStore.add(role1);
        Assert.assertFalse(roleStore.delete("role2"));
    }

    @Test
    public void whenDeleteEmptyArrayShouldFalse() {
        RoleStore roleStore = new RoleStore(3);
        Assert.assertFalse(roleStore.delete("role"));
    }

    @Test
    public void whenReplaceEmptyArrayShouldFalse() {
        RoleStore roleStore = new RoleStore(3);
        Role role = new Role("role");
        Assert.assertFalse(roleStore.replace("role", role));
    }

    @Test
    public void whenReplaceIdNotPresentShouldFalse() {
        RoleStore roleStore = new RoleStore(3);
        Role role1 = new Role("role1");
        Role role2 = new Role("role2");
        roleStore.add(role1);
        Assert.assertFalse(roleStore.replace("role", role2));
    }
}