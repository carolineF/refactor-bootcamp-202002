package cc.xpbootcamp.warmup.fibonacci;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 *
 */
public class Fibonacci {
    Integer number = 50;

    public Fibonacci(Integer number) {
        this.number = number;
    }

    public String getFibonacci() {
        StringBuilder fibonacciString = new StringBuilder();
        fibonacciString.append(this.number);
        return fibonacciString.toString();
    }
}