package cc.xpbootcamp.warmup.cashier;

import java.util.List;

public class Order {
    String customerName;
    String address;
    double totalSalesTax = 0d;
    double totalAmount = 0d;
    List<LineItem> lineItemList;

    public Order(String customerName, String address, List<LineItem> lineItemList) {
        this.customerName = customerName;
        this.address = address;
        this.lineItemList = lineItemList;
        this.calculate();
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
        // prints lineItems
        for (LineItem lineItem : this.lineItemList) {
            // calculate sales tax @ rate of 10%
            totalSalesTax += lineItem.lineItemSalesTax();

            // calculate total amount of lineItem = price * quantity + 10 % sales tax
            totalAmount += lineItem.totalAmount() + lineItem.lineItemSalesTax();
        }
    }
}
