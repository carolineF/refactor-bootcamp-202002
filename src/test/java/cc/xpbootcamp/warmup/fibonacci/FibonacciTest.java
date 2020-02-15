package cc.xpbootcamp.warmup.fibonacci;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

class FibonacciTest {

    @Test
    void should_return_0_when_calculate_given_position_is_0() {
        Fibonacci fibonacci = new Fibonacci();

        Long fibonacciNumber = fibonacci.getFibonacciNumber(0);

        assertEquals(Long.valueOf(0), fibonacciNumber);
    }

    @Test
    void should_return_12586269025_when_calculate_given_position_is_50() {
        Fibonacci fibonacci = new Fibonacci();

        Long fibonacciNumber = fibonacci.getFibonacciNumber(50);

        assertEquals(Long.valueOf(12586269025L), fibonacciNumber);
    }

    @Test
    void should_return_1_when_calculate_given_position_is_1() {
        Fibonacci fibonacci = new Fibonacci();

        Long fibonacciNumber = fibonacci.getFibonacciNumber(1);

        assertEquals(Long.valueOf(1), fibonacciNumber);
    }

    @Test
    void should_return_1_when_calculate_given_position_is_2() {
        Fibonacci fibonacci = new Fibonacci();

        Long fibonacciNumber = fibonacci.getFibonacciNumber(1);

        assertEquals(Long.valueOf(1), fibonacciNumber);
    }

    @Test
    void should_return_3_when_calculate_given_position_is_4() {
        Fibonacci fibonacci = new Fibonacci();

        Long fibonacciNumber = fibonacci.getFibonacciNumber(4);

        assertEquals(Long.valueOf(3), fibonacciNumber);
    }
}