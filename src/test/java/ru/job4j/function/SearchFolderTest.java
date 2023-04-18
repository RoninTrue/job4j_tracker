package ru.job4j.function;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

class SearchFolderTest {

    @Test
    public void whenFilterSize() {
        List<Folder> list = List.of(
                new Folder("fix", 110),
                new Folder("bug", 75),
                new Folder("bug", 90)
        );
        List<Folder> expected = List.of(new Folder("fix", 110));
        List<Folder> rsl = SearchFolder.filter(list, f -> f.getSize() > 100);
        assertThat(rsl).containsAll(expected);
    }

    @Test
    public void whenFilterName() {
        List<Folder> list = List.of(
                new Folder("fix", 110),
                new Folder("bug", 75),
                new Folder("bug", 90)
        );
        List<Folder> expected = List.of(
                new Folder("bug", 75),
                new Folder("bug", 90)
        );
        List<Folder> rsl = SearchFolder.filter(list, f -> f.getName().contains("bug"));
        assertThat(rsl).containsAll(expected);
    }
}