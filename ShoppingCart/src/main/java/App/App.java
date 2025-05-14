package App;

public class App {
	public static void main(String[] args) {

		ShoppingCart shoppingCart = new ShoppingCart();
		System.out.println("Current balance: " + shoppingCart.getBalance());

		shoppingCart.addItem(new Product("tv", 99.99));
		System.out.println("Current balance: " + shoppingCart.getBalance());
	}
}
