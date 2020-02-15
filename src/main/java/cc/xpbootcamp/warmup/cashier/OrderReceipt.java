package cc.xpbootcamp.warmup.cashier;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 *
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        // print headers
        output.append("======Printing Orders======\n");

        // print date, bill no, customer name
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());

        // prints lineItems
        for (LineItem lineItem : order.getLineItemList()) {
            output.append(lineItem.getLineItemString());
        }

        // prints the state tax
        output.append("Sales Tax").append('\t').append(order.getTotSalesTx());

        // print total amount
        output.append("Total Amount").append('\t').append(order.getTot());
        return output.toString();
    }
}