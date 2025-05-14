package App;

public class Product {
	private String title;
	private double price;

	public Product(String title, double price) {
		this.title = title;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public double getPrice() {
		return price;
	}

	public boolean equals(Product other) {
		return other.getTitle().equals(this.title);
	}
}
