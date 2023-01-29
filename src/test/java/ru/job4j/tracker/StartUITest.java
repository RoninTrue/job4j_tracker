package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {

    @Test
    public void whenCreateItem() {
        Input in = new StubInput(new String[] {"0", "Item name", "1"});
        Tracker tracker = new Tracker();
        Output output = new StubOutput();
        UserAction[] actions = {new CreateAction(output), new ExitAction(output)};
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Item name");
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Output output = new StubOutput();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(new String[] {"0", String.valueOf(item.getId()), replacedName, "1"});
        UserAction[] actions = {new EditAction(output), new ExitAction(output)};
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo(replacedName);
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Output output = new StubOutput();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(new String[] {"0", String.valueOf(item.getId()), "1"});
        UserAction[] actions = {new DeleteAction(output), new ExitAction(output)};
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    public void whenEditItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test"));
        String replaceName = "New test";
        Input in = new StubInput(new String[] {"0", String.valueOf(one.getId()), replaceName, "1"});
        UserAction[] actions = new UserAction[] {new EditAction(out), new ExitAction(out)};
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu." + ln
                + "0. Edit item" + ln
                + "1. Exit from the program" + ln
                + "=== Edit item ===" + ln
                + "Заявка изменена успешно." + ln
                + "Menu." + ln
                + "0. Edit item" + ln
                + "1. Exit from the program" + ln
                + "=== Exit Program ===" + ln);
    }

    @Test
    public void whenShowAllItemsTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test"));
        Input in = new StubInput(new String[] {"0", "1"});
        UserAction[] actions = new UserAction[] {new ShowAllAction(out), new ExitAction(out)};
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu." + ln
                + "0. Show all items" + ln
                + "1. Exit from the program" + ln
                + "=== Show all items ===" + ln
                + one + ln
                + "Menu." + ln
                + "0. Show all items" + ln
                + "1. Exit from the program" + ln
                + "=== Exit Program ===" + ln);
    }

    @Test
    public void whenFindByNameItemTest() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        String name = "test";
        Item one = tracker.add(new Item(name));
        Item two = tracker.add(new Item("TEST"));
        Item three = tracker.add(new Item(name));
        Input in = new StubInput(new String[] {"0", name, "1"});
        UserAction[] actions = new UserAction[] {new FindByNameAction(out), new ExitAction(out)};
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu." + ln
                + "0. Find item by name" + ln
                + "1. Exit from the program" + ln
                + "=== Find items by name ===" + ln
                + one + ln
                + three + ln
                + "Menu." + ln
                + "0. Find item by name" + ln
                + "1. Exit from the program" + ln
                + "=== Exit Program ===" + ln);
    }

    @Test
    public void whenFindByIdItemTestIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test"));
        Item two = tracker.add(new Item("output test"));
        Input in = new StubInput(new String[] {"0", String.valueOf(two.getId()), "1"});
        UserAction[] actions = new UserAction[] {new FindByIdAction(out), new ExitAction(out)};
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("Menu." + ln
                + "0. Find item by id" + ln
                + "1. Exit from the program" + ln
                + "=== Find item by id ===" + ln
                + two + ln
                + "Menu." + ln
                + "0. Find item by id" + ln
                + "1. Exit from the program" + ln
                + "=== Exit Program ===" + ln);
    }
}