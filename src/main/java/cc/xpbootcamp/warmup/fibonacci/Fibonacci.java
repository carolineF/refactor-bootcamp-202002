package cc.xpbootcamp.warmup.fibonacci;

import java.math.BigInteger;

/**
 *
 *
 */
public class Fibonacci {
    private Integer indexLimit;

    public Fibonacci(Integer indexLimit) {
        this.indexLimit = indexLimit;
    }

    public Long getFibonacciNumber(long index) {
        if (index == 1 || index == 2) {
            return Long.valueOf(1);
        }
        return getFibonacciNumber(index - 1) + getFibonacciNumber(index - 2);
    }

    public String getFibonacci() {
        StringBuilder fibonacciString = new StringBuilder();

        if(this.indexLimit < 1) {
            return String.valueOf('0');
        }

        for (int i = 1; i <= this.indexLimit; i++) {
            fibonacciString.append(getFibonacciNumber(i).toString() + ',');
        }
        fibonacciString.deleteCharAt(fibonacciString.length() -1);

        System.out.println(fibonacciString);
        return fibonacciString.toString();
    }


}