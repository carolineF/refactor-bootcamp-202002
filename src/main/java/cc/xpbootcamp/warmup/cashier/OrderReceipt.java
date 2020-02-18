package cc.xpbootcamp.warmup.cashier;

import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 *
 */
public class OrderReceipt {
    private static final DecimalFormat priceFormatter = new DecimalFormat("#.00");
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年M月dd日，EEEE", Locale.CHINA);
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        output.append("====== 老王超市，值得信赖 ======\n");

        output.append(dateTimeFormatter.format(order.getOrderDate()) + '\n');

        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());

        for (LineItem lineItem : order.getLineItemList()) {
            output.append(lineItem.getLineItemString());
        }

        output.append("税额:").append('\t').append(priceFormatter.format(order.getTotalSalesTax()) + '\n');

        output.append("总价:").append('\t').append(priceFormatter.format(order.getTotalAmount()) + '\n');
        return output.toString();
    }
}