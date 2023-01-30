
package invoicingSystem;

import java.util.ArrayList;

public class Product {
	  private int itemId;
	  private String itemName;
	  private double unitPrice;
	  private int quantity;
	  private ArrayList<Product> allItems;
	  
	  public Product(int itemId, String itemName, double unitPrice, int quantity) {
	    this.itemId = itemId;
	    this.itemName = itemName;
	    this.unitPrice = unitPrice;
	    this.quantity = quantity;
	  }
	  
	  public int getItemId() {
	    return itemId;
	  }
	  
	  public String getItemName() {
	    return itemName;
	  }
	  
	  public double getUnitPrice() {
	    return unitPrice;
	  }
	  
	  public int getQuantity() {
	    return quantity;
	  }
	  
	  public double getAmount() {
	    return unitPrice * quantity;
	  }

	public void setUnitPrice(double unitPrice2) {
		this.unitPrice= unitPrice2;
	}
	}

