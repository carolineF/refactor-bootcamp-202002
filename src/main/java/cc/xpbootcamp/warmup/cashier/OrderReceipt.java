package cc.xpbootcamp.warmup.cashier;

import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.stream.Collectors;

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
    private static final String NEW_LINE = "\n";
    private static final String RECEIPT_HEADER = "====== 老王超市，值得信赖 ======\n";
    public static final String ITEM_SPLIT_LINE = "-----------------------------------\n";
    public static final String SALES_TAX = "税额:\t";
    public static final String DISCOUNT = "折扣:\t";
    public static final String TOTAL_AMOUNT = "总价:\t";
    public static final String SEPARATED_COMMA = ", ";
    public static final String MULTIPLICATION_SIGN = " x ";
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        output.append(generateReceiptHeader());

        output.append(generateReceiptLineItem());

        output.append(ITEM_SPLIT_LINE);

        output.append(generateReceiptFooter());

        return output.toString();
    }

    private String getLineItemString(LineItem lineItem) {
        return new StringBuilder()
                .append(lineItem.getDescription())
                .append(SEPARATED_COMMA)
                .append(lineItem.getPrice())
                .append(MULTIPLICATION_SIGN)
                .append(lineItem.getQuantity())
                .append(SEPARATED_COMMA)
                .append(priceFormatter.format(lineItem.totalAmount()))
                .append(NEW_LINE)
                .toString();
    }

    private String generateReceiptFooter() {
        return generateReceiptSalesTax() +
                generateReceiptDiscount() +
                generateReceiptTotalAmount();
    }

    private String generateReceiptSalesTax() {
        return SALES_TAX + priceFormatter.format(order.getTotalSalesTax()) + NEW_LINE;
    }

    private String generateReceiptDiscount() {
        return order.calculateDiscountAmount() > 0
                ? DISCOUNT + priceFormatter.format(order.calculateDiscountAmount()) + NEW_LINE
                : "";
    }

    private String generateReceiptTotalAmount() {
        return TOTAL_AMOUNT + priceFormatter.format(order.getTotalAmountWithDiscount()) + NEW_LINE;
    }

    private String generateReceiptLineItem() {
        return order.getLineItemList().stream().map(lineItem -> getLineItemString(lineItem)).collect(Collectors.joining());
    }

    private String generateReceiptHeader() {
        return RECEIPT_HEADER + NEW_LINE +
                dateTimeFormatter.format(order.getOrderDate()) + NEW_LINE + NEW_LINE;
    }
}