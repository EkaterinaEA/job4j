package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;

class TrackerTest {

    @Test
    void tracker() {

        Item item = new Item("name");
        Item item1 = null;
        Item item2 = new Item("name2");
        Item item3 = new Item("name2");
        Tracker tracker = new Tracker();
        tracker.add(item);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);

        Item resultFindById1 = tracker.findById(item.getId());
        Item resultFindById2 = tracker.findById(item2.getId());

        assertThat(resultFindById1.getName(), is(item.getName()));
        assertThat(resultFindById2.getName(), is(item2.getName()));

        Item[] resultFindByName1 = tracker.findByName(item.getName());
        Item[] resultFindByName2 = tracker.findByName(item2.getName());

        assertThat(resultFindByName1[0].getName(), is(item.getName()));
        assertThat(resultFindByName1[0].getId(), is(item.getId()));
        assertThat(resultFindByName2[0].getName(), is(item2.getName()));
        assertThat(resultFindByName2[0].getId(), is(item2.getId()));
        assertThat(resultFindByName2[1].getName(), is(item2.getName()));
        assertThat(resultFindByName2[1].getName(), is(item3.getName()));
        assertThat(resultFindByName2[1].getId(), is(item3.getId()));

        Item[] resultList = tracker.findAll();

        assertThat(resultList[0].getName(), is(item.getName()));
        assertThat(resultList[1].getName(), is(item2.getName()));
        assertThat(resultList[2].getName(), is(item3.getName()));

    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        tracker.add(bug);
        String id = bug.getId();
        Item bugWithDesc = new Item("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        tracker.add(bug);
        String id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }

}