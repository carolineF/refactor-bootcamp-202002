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
    private static final String SPLIT_LINE = "\n\n";
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        output.append(generateReceiptHeader());

        output.append(generateReceiptLineItem());

        output.append("-----------------------------------\n");

        output.append(generateReceiptFooter());
        System.out.println(output.toString());
        return output.toString();
    }

    public String getLineItemString(LineItem lineItem) {
        return new StringBuilder()
                .append(lineItem.getDescription())
                .append(", ")
                .append(lineItem.getPrice())
                .append(" x ")
                .append(lineItem.getQuantity())
                .append(", ")
                .append(priceFormatter.format(lineItem.totalAmount()))
                .append('\n')
                .toString();
    }

    private String generateReceiptFooter() {
        return generateReceiptSalesTax() +
                generateReceiptDiscount() +
                generateReceiptTotalAmount();
    }

    private String generateReceiptSalesTax() {
        return "税额:\t" + priceFormatter.format(order.getTotalSalesTax()) + '\n';
    }

    private String generateReceiptDiscount() {
        return order.calculateDiscountAmount() > 0
                ? "折扣:\t" + priceFormatter.format(order.calculateDiscountAmount()) + '\n'
                : "";
    }

    private String generateReceiptTotalAmount() {
        return "总价:\t" + priceFormatter.format(order.getTotalAmountWithDiscount()) + '\n';
    }

    private String generateReceiptLineItem() {
        StringBuilder lineItemString = new StringBuilder();
        for (LineItem lineItem : order.getLineItemList()) {
            lineItemString.append(getLineItemString(lineItem));
        }
        return lineItemString.toString();
    }

    private String generateReceiptHeader() {
        return "====== 老王超市，值得信赖 ======" + SPLIT_LINE +
                dateTimeFormatter.format(order.getOrderDate()) + SPLIT_LINE;
    }
}