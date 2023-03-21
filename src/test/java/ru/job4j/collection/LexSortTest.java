package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Arrays;

class LexSortTest {

    @Test
    public void sortNum1and2and10() {
        String[] input = {
                "10. Task.",
                "1. Task.",
                "2. Task."
        };
        String[] out = {
                "1. Task.",
                "2. Task.",
                "10. Task."
        };
        Arrays.sort(input, new LexSort());
        assertThat(input).containsExactly(out);
    }
}