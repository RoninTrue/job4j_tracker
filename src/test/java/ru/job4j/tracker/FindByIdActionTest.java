package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.*;

class FindByIdActionTest {
    @Test
    public void whenItemWasFindByIdSuccessfully() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Item"));
        FindByIdAction findByIdAction = new FindByIdAction(output);
        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(item.getId());
        findByIdAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Find item by id ===" + ln
                        + item + ln
        );
    }

    @Test
    public void whenItemWasFindByIdNotSuccessfully() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        FindByIdAction findByIdAction = new FindByIdAction(output);
        Input input = mock(Input.class);
        int testId = 5;

        when(input.askInt(any(String.class))).thenReturn(testId);
        findByIdAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Find item by id ===" + ln
                        + "Заявка с ведённым id: "
                        + testId + " не найдена."
                        + ln
        );
    }
}