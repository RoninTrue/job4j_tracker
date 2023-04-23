package ru.job4j.function;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

class FunctionCalculatorTest {

    @Test
    void whenLinearFunction5To8() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result).containsAll(expected);
    }

    @Test
    void whenLinearFunction10To13() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(10, 13, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(21D, 23D, 25D);
        assertThat(result).containsAll(expected);
    }

    @Test
    void whenLinearFunction100To102() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(100, 102, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(201D, 203D);
        assertThat(result).containsAll(expected);
    }

    @Test
    void whenQuadraticFunction2To5() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(2, 5, x -> Math.pow(x, 2));
        List<Double> expected = Arrays.asList(4D, 9D, 16D);
        assertThat(result).containsAll(expected);
    }

    @Test
    void whenQuadraticFunction100To101() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(100, 100, x -> Math.pow(x, 2));
        assertTrue(result.isEmpty());
    }

    @Test
    void whenQuadraticFunction10To12() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(10, 12, x -> Math.pow(x, 2));
        List<Double> expected = Arrays.asList(100D, 121D);
        assertThat(result).containsAll(expected);
    }

    @Test
    void whenExponentialFunction0To11() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(0, 11, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(1D, 2D, 4D, 8D, 16D, 32D, 64D, 128D, 256D, 512D, 1024D);
        assertThat(result).containsAll(expected);
    }
}