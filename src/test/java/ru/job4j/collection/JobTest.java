package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import static org.assertj.core.api.Assertions.assertThat;

class JobTest {
    @Test
    public void whenAscByName() {
        Comparator<Job> cmpAscName = new JobAscByName();
        int rsl = cmpAscName.compare(new Job("Alex", 21),
                new Job("Sergey", 20));
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenDescByName() {
        Comparator<Job> cmpDescName = new JobDescByName();
        int rsl = cmpDescName.compare(new Job("Alex", 21),
                new Job("Sergey", 20));
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenAscByPriority() {
        Comparator<Job> cmpAscPriority = new JobAscByName();
        int rsl = cmpAscPriority.compare(new Job("Alex", 21),
                new Job("Sergey", 20));
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenDescByPriority() {
        Comparator<Job> cmpDescPriority = new JobDescByName();
        int rsl = cmpDescPriority.compare(new Job("Alex", 21),
                new Job("Sergey", 20));
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByNameAndAscPriority() {
        Comparator<Job> cpm = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cpm.compare(new Job("Alex", 21),
                new Job("Alex", 20));
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByNameAndDescPriority() {
        Comparator<Job> cpm = new JobAscByName().thenComparing(new JobDescByPriority());
        int rsl = cpm.compare(new Job("Alex", 21),
                new Job("Alex", 20));
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByPriorityAndAscName() {
        Comparator<Job> cpm = new JobAscByPriority().thenComparing(new JobAscByName());
        int rsl = cpm.compare(new Job("Alex", 20),
                new Job("Petr", 20));
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByPriorityAndDescName() {
        Comparator<Job> cpm = new JobAscByPriority().thenComparing(new JobDescByName());
        int rsl = cpm.compare(new Job("Alex", 20),
                new Job("Petr", 20));
        assertThat(rsl).isGreaterThan(0);
    }
}