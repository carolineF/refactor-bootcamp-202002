package cc.xpbootcamp.warmup.cashier;

import java.util.List;
import java.time.LocalDate;

public class Order {
    String customerName;
    String address;
    double totalSalesTax = 0d;
    double totalAmount = 0d;
    List<LineItem> lineItemList;
    LocalDate orderDate;

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
        return totalAmount;
    }

    private void calculate() {
        for (LineItem lineItem : this.lineItemList) {
            totalSalesTax += lineItem.lineItemSalesTax();

            totalAmount += lineItem.totalAmount() + lineItem.lineItemSalesTax();
        }
    }
}
