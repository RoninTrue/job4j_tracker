package ru.job4j.tracker;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.sql.*;
import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.Assertions.*;

public class SqlTrackerTest {

    private  static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        Store tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    public void whenFindByNameThenMustBeTheSame() {
        Store tracker = new SqlTracker(connection);
        Item item = new Item("First");
        Item item1 = new Item("First");
        tracker.add(item);
        tracker.add(item1);
        List<Item> result = List.of(item, item1);
        assertThat(tracker.findByName("First")).isEqualTo(result);
    }

    @Test
    public void whenFindByIdThenMustBeSame() {
        Store tracker = new SqlTracker(connection);
        Item item = new Item("First");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    public void whenFindAllThenMustBeSame() {
        Store tracker = new SqlTracker(connection);
        Item first = new Item("First");
        Item second = new Item("Second");
        Item third = new Item("Third");
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        List<Item> result = List.of(first, second, third);
        assertThat(tracker.findAll()).isEqualTo(result);
    }

    @Test
    public void whenReplaceItemThenIsSuccessful() {
        Store tracker = new SqlTracker(connection);
        Item item = new Item("Item");
        tracker.add(item);
        int id = item.getId();
        Item newItem = new Item("Replace Item");
        tracker.replace(id, newItem);
        assertThat(tracker.findById(id).getName()).isEqualTo("Replace Item");
    }

    @Test
    public void whenReplaceItemThenIsNotSuccessful() {
        Store tracker = new SqlTracker(connection);
        Item item = new Item("Item");
        Item newItem = new Item("Replace Item");
        tracker.add(item);
        boolean result = tracker.replace(1000, newItem);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo("Item");
        assertThat(result).isFalse();
    }

    @Test
    public void whenDeleteItemThenIsSuccessful() {
        Store tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        int id = item.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id)).isNull();
    }

    @Test
    public void whenDeleteItemThenIsNotSuccessful() {
        Store tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        tracker.delete(1000);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }
}