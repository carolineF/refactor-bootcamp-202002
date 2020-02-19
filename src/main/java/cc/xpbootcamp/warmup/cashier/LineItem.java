package cc.xpbootcamp.warmup.cashier;

public class LineItem {
	private static final double SALES_TAX = 0.1d;
	private String description;
	private double price;
	private int quantity;

	public LineItem(String description, double price, int quantity) {
		super();
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public double totalAmount() {
        return price * quantity;
    }

    public double lineItemSalesTax() {
		return totalAmount() * SALES_TAX;
	}

}