package cc.xpbootcamp.warmup.fibonacci;

/**
 * getFibonacci function output Fiftieth of FibonacciString
 *
 * getFibonacciNumber function output position of fibonacci number
 *
 */
public class Fibonacci {

    public Long getFibonacciNumber(long position) {
        if(position <= 0) {
            return Long.valueOf(0);
        }

        if (position == 1 || position == 2) {
            return Long.valueOf(1);
        }
        return getFibonacciNumber(position - 1) + getFibonacciNumber(position - 2);
    }

}