
package invoicingSystem;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

public class Invoice {
	private String customerName;
	private String phoneNumber;
	private Date invoiceDate;
	private Shop shop;
	private ArrayList<Product> items;
	private double totalAmount;
	private double paidAmount;

	public Invoice(String customerName, String phoneNumber, Date invoiceDate, ArrayList<Product> products) {
		this.customerName = customerName;
		this.phoneNumber = phoneNumber;
		this.invoiceDate = invoiceDate;
		this.items = products;

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
		return items;
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

	public void setInvoiceHeader(Shop shop) {
		this.shop = shop;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}
}
