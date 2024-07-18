package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FindByNameActionTest {
    @Test
    public void whenItemWasFindByNameSuccessfully() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        String name = "Item";
        Item item1 = tracker.add(new Item(name));
        Item item2 = tracker.add(new Item(name));
        FindByNameAction findByNameAction = new FindByNameAction(output);
        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn(name);
        findByNameAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Find items by name ===" + ln
                        + item1 + ln + item2 + ln
        );
    }

    @Test
    public void whenItemWasFindByNameNotSuccessfully() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        String name = "Item";
        FindByNameAction findByNameAction = new FindByNameAction(output);
        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn(name);
        findByNameAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Find items by name ===" + ln
                        + "Заявки с именем: " + name + " не найдены." + ln
        );
    }
}