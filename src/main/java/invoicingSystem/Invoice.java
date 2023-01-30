
package invoicingSystem;

import java.sql.Date;
import java.util.ArrayList;

public class Invoice {
	 private String customerName;
	  private String phoneNumber;
	  private Date invoiceDate;
	  private ArrayList<Product> products;
	  private double totalAmount;
	  private double paidAmount;
	  
	  public Invoice(String customerName, String phoneNumber, Date invoiceDate, ArrayList<Product> products) {
	    this.customerName = customerName;
	    this.phoneNumber = phoneNumber;
	    this.invoiceDate = invoiceDate;
	    this.products = products;
	    
	    for (Product product : products) {
	      totalAmount += product.getAmount();
	    }
	  }
	  
	  public String getCustomerName() {
	    return customerName;
	  }
	  
	  public String getPhoneNumber() {
	    return phoneNumber;
	  }
	  
	  public Date getInvoiceDate() {
	    return invoiceDate;
	  }
	  
	  public ArrayList<Product> getProducts() {
	    return products;
	  }
	  
	  public double getTotalAmount() {
	    return totalAmount;
	  }
	  
	  public double getPaidAmount() {
	    return paidAmount;
	  }
	  
	  public void setPaidAmount(double paidAmount) {
	    this.paidAmount = paidAmount;
	  }
	  
	  public double getBalance() {
	    return totalAmount - paidAmount;
	  }
	}




