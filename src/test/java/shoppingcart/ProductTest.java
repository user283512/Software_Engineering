package shoppingcart;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ProductTest {

  @Test
  public void testProductCreation() {
    Product product = new Product("Product_1", 10.99);
    assertEquals("Product_1", product.getTitle());
    assertEquals(10.99, product.getPrice());
  }
}