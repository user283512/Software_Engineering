package shoppingcart;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShoppingCartTest {

  private ShoppingCart shoppingCart;
  private Product p1;
  private Product p2;
  private Product p3;

  @BeforeEach
  public void setUp() {
    shoppingCart = new ShoppingCart();
    p1 = new Product("Product_1", 10.99);
    p2 = new Product("Product_2", 5.49);
    p3 = new Product("Product_3", 20.00);
  }

  @Test
  public void testAddItem() {
    shoppingCart.addItem(p3);
    assertEquals(1, shoppingCart.getItemCount());
    assertEquals(20.00, shoppingCart.getBalance());
  }

  @Test
  public void testRemoveItem() throws ProductNotFoundException {
    shoppingCart.addItem(p1);
    shoppingCart.removeItem(p1);
    assertEquals(0, shoppingCart.getItemCount());
    assertEquals(0.00, shoppingCart.getBalance());

    assertThrows(ProductNotFoundException.class, () -> {
      shoppingCart.removeItem(p1);
    });
  }

  @Test
  public void testGetBalance() {
    shoppingCart.addItem(p1);
    shoppingCart.addItem(p2);
    assertEquals(16.48, shoppingCart.getBalance());
  }

  @Test
  public void testEmpty() {
    shoppingCart.addItem(p1);
    shoppingCart.addItem(p2);
    shoppingCart.empty();
    assertEquals(0, shoppingCart.getItemCount());
    assertEquals(0.00, shoppingCart.getBalance());
  }
}