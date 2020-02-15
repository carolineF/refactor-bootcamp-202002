package cc.xpbootcamp.warmup.fibonacci;

/**
 *
 *
 */
public class Fibonacci {
    private Integer indexLimit;

    public Fibonacci(Integer indexLimit) {
        this.indexLimit = indexLimit;
    }

    public Integer getFibonacciNumber(Integer index) {
        if (index == 1 || index == 2) {
            return 1;
        }
        return 1;
    }

    public String getFibonacci() {
        StringBuilder fibonacciString = new StringBuilder();
        for (int i = 1; i <= this.indexLimit; i++) {
            fibonacciString.append(getFibonacciNumber(i).toString() + ',');
        }
        fibonacciString.deleteCharAt(fibonacciString.length() -1);

        return fibonacciString.toString();
    }


}