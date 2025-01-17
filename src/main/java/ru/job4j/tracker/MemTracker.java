package ru.job4j.tracker;

import java.util.List;
import java.util.ArrayList;

public class MemTracker implements Store {
    private List<Item> items = new ArrayList<>();
    private int ids = 1;

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public List<Item> findAll() {
        return List.copyOf(items);
    }

    public List<Item> findByName(String key) {
        List<Item> copy = new ArrayList<>();
        for (Item item : items) {
            if (key.equals(item.getName())) {
                copy.add(item);
            }
        }
        return copy;
    }

    public Item findById(Integer id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public boolean replace(Integer id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
            items.set(index, item);
        }
        return rsl;
    }

    public void delete(Integer id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            items.remove(items.get(index));
        }
    }

    @Override
    public void close() throws Exception {

    }
}