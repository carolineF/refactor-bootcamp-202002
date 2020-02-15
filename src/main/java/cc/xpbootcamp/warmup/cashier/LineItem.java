package cc.xpbootcamp.warmup.cashier;

public class LineItem {
	private String description;
	private double price;
	private int quantity;

	public LineItem(String description, double price, int quantity) {
		super();
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}

    double totalAmount() {
        return price * quantity;
    }

    double lineItemSalesTax() {
		return totalAmount() * .10;
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