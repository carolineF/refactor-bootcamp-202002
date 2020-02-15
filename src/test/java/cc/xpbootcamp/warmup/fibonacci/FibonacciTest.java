package cc.xpbootcamp.warmup.fibonacci;


import cc.xpbootcamp.warmup.cashier.OrderReceipt;
import cc.xpbootcamp.warmup.fibonacci.Fibonacci;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

class FibonacciTest {
    @Test
    void shouldReturnFirstValueOfFibonacciWithNumberOne() {
        Fibonacci fibonacci = new Fibonacci(1);

        String fibonacciString = fibonacci.getFibonacci();


        assertThat(fibonacciString, containsString("1"));
    }


}