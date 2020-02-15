package cc.xpbootcamp.warmup.fibonacci;


import cc.xpbootcamp.warmup.cashier.OrderReceipt;
import cc.xpbootcamp.warmup.fibonacci.Fibonacci;
import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

class FibonacciTest {
    @Test
    void shouldReturnFirstValueOfFibonacciWithNumberOne() {
        Fibonacci fibonacci = new Fibonacci(1);

        String fibonacciString = fibonacci.getFibonacci();

        assertThat(fibonacciString, containsString("1"));
    }

    @Test
    void shouldReturnFirstTwoFibonacciSplitWithCommaSeparated() {
        Fibonacci fibonacci = new Fibonacci(2);

        String fibonacciString = fibonacci.getFibonacci();

        assertThat(fibonacciString, containsString("1,1"));
    }

    @Test
    void shouldReturnFirstFiveFibonacciSplitWithCommaSeparated() {
        Fibonacci fibonacci = new Fibonacci(5);

        String fibonacciString = fibonacci.getFibonacci();

        assertThat(fibonacciString, containsString("1,1,2,3,5"));
    }

    @Test
    void should_return_0_when_calculate_given_position_is_0() {
        Fibonacci fibonacci = new Fibonacci(5);

        Long fibonacciNumber = fibonacci.getFibonacciNumber(0);

        assertEquals(Long.valueOf(0), fibonacciNumber);
    }

    @Test
    void should_return_12586269025_when_calculate_given_position_is_50() {
        Fibonacci fibonacci = new Fibonacci(1);

        Long fibonacciNumber = fibonacci.getFibonacciNumber(50);

        assertEquals(Long.valueOf(12586269025L), fibonacciNumber);
    }
}