package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class HbmTrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            Item result = tracker.findById(item.getId());
            assertThat(result.getName()).isEqualTo(item.getName());
        }
    }

    @Test
    void whenItemWasReplacedSuccessfully() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item testItem = new Item();
            testItem.setName("testItem");
            tracker.add(testItem);
            Item newItem = new Item();
            newItem.setName("replacesItem");
            assertThat(tracker.replace(testItem.getId(), newItem)).isTrue();
            assertThat(tracker.findById(testItem.getId()).getName()).isEqualTo(newItem.getName());
        }
    }

    @Test
    void whenDeleteItemThenGetNull() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item testItem = new Item();
            testItem.setName("testItem");
            tracker.add(testItem);
            tracker.delete(testItem.getId());
            assertThat(tracker.findById(testItem.getId())).isNull();
        }
    }

    @Test
    void whenFindByNameThenTrackerHasSameItems() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item1 = new Item();
            Item item2 = new Item();
            item1.setName("name");
            item2.setName("name");
            tracker.add(item1);
            tracker.add(item2);
            var expected = List.of(item1, item2);
            var result = tracker.findByName("name");
            assertThat(result).isEqualTo(expected);
        }
    }

    @Test
    void whenFindAllThenTrackerHasSameItems() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item1 = new Item();
            Item item2 = new Item();
            Item item3 = new Item();
            item1.setName("name1");
            item2.setName("name2");
            item3.setName("name3");
            tracker.add(item1);
            tracker.add(item2);
            tracker.add(item3);
            var expected = List.of(item1, item2, item3);
            var result = tracker.findAll();
            assertThat(result).isEqualTo(expected);
        }
    }
}