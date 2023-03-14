package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;

class ItemAscByNameTest {

    @Test
    void whenCompareByNameByAsc() {
        Item item1 = new Item("Petr");
        Item item2 = new Item("Sergey");
        Item item3 = new Item("Alex");
        List<Item> items = Arrays.asList(item1, item2, item3);
        items.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(item3, item1, item2);
        assertThat(expected).isEqualTo(items);
    }

    @Test
    void whenNotCompareByNameByAsc() {
        Item item1 = new Item("Petr");
        Item item2 = new Item("Sergey");
        Item item3 = new Item("Alex");
        List<Item> items = Arrays.asList(item1, item2, item3);
        items.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(item1, item2, item3);
        assertThat(expected).isNotEqualTo(items);
    }
}