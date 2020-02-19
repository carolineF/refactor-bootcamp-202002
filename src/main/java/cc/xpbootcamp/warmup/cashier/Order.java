package cc.xpbootcamp.warmup.cashier;

import java.util.List;
import java.time.LocalDate;

public class Order {
    private static double NO_DISCOUNT = 0d;
    private static double WEDNESDAY_DISCOUNT = 0.02d;
    private static byte WEDNESDAY = 3;

    public List<LineItem> lineItemList;
    public LocalDate orderDate;

    public Order(List<LineItem> lineItemList, LocalDate orderDate) {
        this.lineItemList = lineItemList;
        this.orderDate = orderDate;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public List<LineItem> getLineItemList() {
        return lineItemList;
    }

    public double getTotalAmountWithDiscount() {
        return getTotalAmount() - calculateDiscountAmount();
    }

    public double getTotalSalesTax() {
        double totalSalesTax = 0d;
        for (LineItem lineItem : lineItemList) {
            totalSalesTax += lineItem.lineItemSalesTax();
        }
        return totalSalesTax;
    }

    public double calculateDiscountAmount() {
        return getTotalAmount() * calculateDiscount();
    }

    private double getTotalAmount() {
        double totalAmount = 0d;
        for (LineItem lineItem : lineItemList) {
            totalAmount += lineItem.totalAmount() + lineItem.lineItemSalesTax();
        }
        return totalAmount;
    }

    private double calculateDiscount() {
        return orderDate.getDayOfWeek().getValue() == WEDNESDAY ? WEDNESDAY_DISCOUNT : NO_DISCOUNT;
    }
}
