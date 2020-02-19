package cc.xpbootcamp.warmup.cashier;

import java.util.List;
import java.time.LocalDate;

public class Order {
    private static double NO_DISCOUNT = 0d;
    private static double WEDNESDAY_DISCOUNT = 0.02d;
    private static byte WEDNESDAY = 3;
    public String customerName;
    public String address;
    public double totalSalesTax = 0d;
    public double totalAmount = 0d;
    public List<LineItem> lineItemList;
    public LocalDate orderDate;

    public Order(String customerName, String address, List<LineItem> lineItemList, LocalDate orderDate) {
        this.customerName = customerName;
        this.address = address;
        this.lineItemList = lineItemList;
        this.orderDate = orderDate;
        this.calculate();
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return address;
    }

    public List<LineItem> getLineItemList() {
        return lineItemList;
    }

    public double getTotalSalesTax() {
        return totalSalesTax;
    }

    public double getTotalAmount() {
        return totalAmount - totalAmount*calculateDiscount();
    }

    private double calculateDiscount() {
        return orderDate.getDayOfWeek().getValue() == WEDNESDAY ? WEDNESDAY_DISCOUNT : NO_DISCOUNT;
    }

    private void calculate() {
        for (LineItem lineItem : this.lineItemList) {
            totalSalesTax += lineItem.lineItemSalesTax();

            totalAmount += lineItem.totalAmount() + lineItem.lineItemSalesTax();
        }
    }
}
