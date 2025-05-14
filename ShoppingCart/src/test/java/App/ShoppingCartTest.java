package App;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class ShoppingCartTest {

	private ShoppingCart shoppingCart;
	private Product p1;
	private Product p2;

	@BeforeEach
	public void initCart() {
		shoppingCart = new ShoppingCart();
		p1 = new Product("P1", 99.0);
		p2 = new Product("P2", 19.0);
	}

	@Test
	public void testCreationCart() {
		assertEquals(shoppingCart.getItemCount(), 0);
		assertEquals(shoppingCart.getBalance(), 0);
	}

	@Test
	public void testAddItem() {
		shoppingCart.addItem(p1);
		shoppingCart.addItem(p2);
		assertEquals(shoppingCart.getItemCount(), 2);
	}

	@Test
	public void testRemoveItem() throws ProductNotFoundException {
		shoppingCart.addItem(p1);
		shoppingCart.addItem(p2);
		assertEquals(shoppingCart.getItemCount(), 2);

		shoppingCart.removeItem(p2);
		assertEquals(shoppingCart.getItemCount(), 1);

		shoppingCart.removeItem(p1);
		assertEquals(shoppingCart.getItemCount(), 0);

		assertThrows(ProductNotFoundException.class, () -> {
			shoppingCart.removeItem(new Product("notexisting", 0.0));
		});
	}

	@Test
	public void testBalance() {
		shoppingCart.addItem(p1);
		shoppingCart.addItem(p2);
		assertEquals(
				shoppingCart.getBalance(),
				p1.getPrice() + p2.getPrice());
	}

	@Test
	public void testEmpty() {
		shoppingCart.addItem(p1);
		shoppingCart.addItem(p2);
		shoppingCart.empty();
		assertEquals(shoppingCart.getBalance(), 0);
		assertEquals(shoppingCart.getItemCount(), 0);
	}
}