package exercise1.shoppingcart;

import java.util.ArrayList;
import java.util.Iterator;

public class ShoppingCart {

  private ArrayList<Product> items;

  public ShoppingCart() {
    items = new ArrayList();
  }

  public double getBalance() {
    double balance = 0.00;

    for (Iterator i = items.iterator(); i.hasNext();) {
      Product item = (Product) i.next();
      balance += item.getPrice();
    }
    return balance;
  }

  public void addItem(Product item) {
    items.add(item);
  }

  public void removeItem(Product item) throws ProductNotFoundException {
    if (!items.remove(item))
      throw new ProductNotFoundException();
  }

  public int getItemCount() {
    return items.size();
  }

  public void empty() {
    items.clear();
  }

  public void printItems() {
    for (Product item : items) {
      System.out.println("Product: " + item.getTitle() + ", Price: " + item.getPrice() + "€");
    }
    System.out.println("Balance: " + getBalance() + "€");
  }
}