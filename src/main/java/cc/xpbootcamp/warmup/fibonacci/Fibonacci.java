package cc.xpbootcamp.warmup.fibonacci;

/**
 * getFibonacci function output Fiftieth of FibonacciString
 *
 * getFibonacciNumber function output position of fibonacci number
 *
 */
public class Fibonacci {
    private Integer indexLimit = 50;

    public Long getFibonacciNumber(long position) {
        if(position <= 0) {
            return Long.valueOf(0);
        }

        if (position == 1 || position == 2) {
            return Long.valueOf(1);
        }
        return getFibonacciNumber(position - 1) + getFibonacciNumber(position - 2);
    }

    public String getFibonacci() {
        StringBuilder fibonacciString = new StringBuilder();

        for (int i = 1; i <= this.indexLimit; i++) {
            fibonacciString.append(getFibonacciNumber(i).toString() + ',');
        }
        fibonacciString.deleteCharAt(fibonacciString.length() -1);

        System.out.println(fibonacciString);
        return fibonacciString.toString();
    }
}