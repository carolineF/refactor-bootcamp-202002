package cc.xpbootcamp.warmup.cashier;

public class LineItem {
	private static double SALES_TAX = 0.1d;
	private String description;
	private double price;
	private int quantity;

	public LineItem(String description, double price, int quantity) {
		super();
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}

    public double totalAmount() {
        return price * quantity;
    }

    public double lineItemSalesTax() {
		return totalAmount() * SALES_TAX;
	}

    public String getLineItemString() {
		return new StringBuilder()
				.append(description)
				.append('\t')
				.append(price)
				.append('\t')
				.append(quantity)
				.append('\t')
				.append(totalAmount())
				.append('\n')
				.toString();
	}
}