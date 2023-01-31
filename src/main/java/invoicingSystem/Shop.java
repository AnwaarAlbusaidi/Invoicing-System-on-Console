package invoicingSystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class Shop {
	String shopName;
	private String tel;
	private String fax;
	private String email;
	private String website;
	private ArrayList<Product> items = new ArrayList<Product>();
	private ArrayList<Invoice> invoices = new ArrayList<Invoice>();
	private Gson gson = new GsonBuilder().setPrettyPrinting().create();;
	private UserInputHandler manager = new UserInputHandler();

	public Shop(String shopName, String tel, String fax, String email, String website) {
		this.shopName = shopName;
		this.tel = tel;
		this.fax = fax;
		this.email = email;
		this.website = website;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName() {
		String newShopName;
		System.out.print("Enter the new shop name: ");
		newShopName = manager.getUserChoiceString();
		this.shopName = newShopName;
	}

	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	/**
	 * Saves the given shop details to a file with the specified file name.
	 * @param shop     The shop details to be saved.
	 * @param fileName The name of the file to save the shop details to.
	 */
	public static void saveShopDetails(Shop shop, String fileName) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		ArrayList<Shop> shopList = new ArrayList<Shop>();

		try (FileReader reader = new FileReader(fileName)) {
			shopList = gson.fromJson(reader, new TypeToken<ArrayList<Shop>>() {
			}.getType());
		} catch (IOException e) {
			e.printStackTrace();
		}

		shopList.add(shop);

		try (FileWriter writer = new FileWriter(fileName)) {
			gson.toJson(shopList, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Adds a new item to the list of items and writes the updated list to a JSON
	 * file.
	 * The item is created based on user input for item ID, item name, unit price,
	 * and quantity.
	 */
	public void addItem() {
		System.out.print("Enter item ID: ");
		int itemId = manager.getUserChoice();
		System.out.print("Enter item name: ");
		String itemName = manager.getUserChoiceString();
		System.out.print("Enter unit price: ");
		double unitPrice = Double.parseDouble(manager.getUserChoiceString());
		System.out.print("Enter quantity: ");
		int quantity = manager.getUserChoice();

		Product product = new Product(itemId, itemName, unitPrice, quantity);
		items.add(product);

		try (FileWriter writer = new FileWriter("items.json")) {
			Gson gson = new Gson();
			String json = gson.toJson(items);
			writer.write(json);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deserializes a JSON file containing a list of products and prints each
	 * product's details.
	 */
	public void deserialize() {
		try (Reader reader = new BufferedReader(new FileReader("items.json"))) {
			ArrayList<Product> itemsList = gson.fromJson(reader, new TypeToken<ArrayList<Product>>() {
			}.getType());
			for (Product product : itemsList) {
				System.out.println("Product id: " + product.getItemId());
				System.out.println("Product Name: " + product.getItemName());
				System.out.println("Product Unit Price: " + product.getUnitPrice());
				System.out.println("Product Quantity : " + product.getQuantity());
				System.out.println();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deletes an item from the inventory based on the item ID entered by the user.
	 * Reads the items from a JSON file "items.json" using Gson library, searches
	 * for the item with the given ID, removes it from the list and writes the
	 * updated list back to the file.
	 */
	public void deleteItem() {
		System.out.print("Enter item ID: ");
		int itemId = manager.getUserChoice();

		try (Reader reader = new BufferedReader(new FileReader("items.json"))) {
			ArrayList<Product> itemsList = gson.fromJson(reader, new TypeToken<ArrayList<Product>>() {
			}.getType());
			for (Product product : itemsList) {
				if (product.getItemId() == itemId) {
					itemsList.remove(product);
					break;
				}
			}
			try (Writer writer = new FileWriter("items.json")) {
				gson.toJson(itemsList, writer);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Updates the unit price of a product by its ID Prompts user to enter the item
	 * ID of the product to update. Prompts user to enter the new price. Reads the
	 * "items.json" file and converts the content to a list of products. Loops
	 * through the list of products and finds the product with matching ID. Updates
	 * the unit price of the found product. Writes the updated list of products to
	 * the "items.json" file. Handles and logs any IOExceptions that might occur
	 * during the reading and writing process.
	 */
	public void updatePrice() {

		System.out.print("Enter item ID: ");
		int itemId = manager.getUserChoice();

		System.out.print("Enter the new price: ");
		double newPrice = Double.parseDouble(manager.getUserChoiceString());

		try (Reader reader = new BufferedReader(new FileReader("items.json"))) {
			ArrayList<Product> itemsList = gson.fromJson(reader, new TypeToken<ArrayList<Product>>() {
			}.getType());
			for (Product product : itemsList) {
				if (product.getItemId() == itemId) {
					product.setUnitPrice(newPrice);
					break;
				}
			}
			try (Writer writer = new FileWriter("items.json")) {
				gson.toJson(itemsList, writer);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setInvoiceHeader()
	{
		Invoice invoice = new Invoice(fax, email, null, items);
	}
	
}// End of class
