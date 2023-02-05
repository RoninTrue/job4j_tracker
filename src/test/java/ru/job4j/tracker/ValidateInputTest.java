package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ValidateInputTest {
    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"one", "1"});
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"5"});
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(5);
    }

    @Test
    public void whenMultipleValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"3", "1", "6"});
        ValidateInput input = new ValidateInput(out, in);
        int[] array = new int[3];
        for (int index = 0; index < array.length; index++) {
            int selected = input.askInt("Enter menu:");
            array[index] = selected;
        }
        assertThat(array).containsExactly(3, 1, 6);
    }

    @Test
    public void whenMinusValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"-1"});
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-1);
    }
}