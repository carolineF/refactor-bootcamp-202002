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
        Fibonacci fibonacci = new Fibonacci(50);

        String fibonacciString = fibonacci.getFibonacci();

        assertThat(fibonacciString, containsString("1,1,2,3,5"));
    }
    //TODO how to compare two long number
//
//    @Test
//    void shouldGetNumber0WhenIndexIs0() {
//        Fibonacci fibonacci = new Fibonacci(5);
//
//        Long fibonacciNumber = fibonacci.getFibonacciNumber(0);
//
//        assertEquals(java.util.Optional.of(0), fibonacciNumber);
//    }

//    @Test
//    void shouldReturnFiftiethFibonacciWithNumber12586269025() {
//        Fibonacci fibonacci = new Fibonacci(50);
//
//        BigInteger fibonacciNumber = fibonacci.getFibonacciNumber(50);
//
//        Assert.isTrue(fibonacciNumber.subtract(BigInteger.valueOf(12586269025)) == 0);
//    }
}