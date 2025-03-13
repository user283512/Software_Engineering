public class Entry {
	public static void main(String[] args) {
		System.out.println("Creating a shopping cart...");

		ShoppingCart shoppingCart = new ShoppingCart();

		Product p1 = new Product("Product_1", 10.99);
		Product p2 = new Product("Product_2", 5.49);
		Product p3 = new Product("Product_3", 20.00);

		// Aggiungi prodotti di prova
		shoppingCart.addItem(p1);
		shoppingCart.addItem(p2);
		shoppingCart.addItem(p3);

		// Stampa il contenuto del carrello
		shoppingCart.printItems();

		try {
			shoppingCart.removeItem(p3);
			shoppingCart.removeItem(p3);
		} catch (ProductNotFoundException e) {
			e.printStackTrace();
		}

		shoppingCart.printItems();
	}
}