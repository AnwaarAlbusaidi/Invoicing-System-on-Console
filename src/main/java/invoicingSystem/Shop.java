package invoicingSystem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;

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

	public void saveShopDetails(Shop shop1) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try (FileWriter writer = new FileWriter("shop.json")) {
			gson.toJson(shop1, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Adds a new item to the list of items and writes the updated list to a JSON
	 * file. The item is created based on user input for item ID, item name, unit
	 * price, and quantity.
	 */
	public void addItem() {

		try (FileReader reader = new FileReader("items.json")) {
			Gson gson = new Gson();
			items = gson.fromJson(reader, new TypeToken<ArrayList<Product>>() {
			}.getType());
		} catch (FileNotFoundException e) {
			System.out.println("File not found, creating new file.");
			items = new ArrayList<>();
		} catch (IOException e) {
			e.printStackTrace();
		}

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
			 Gson gson = new GsonBuilder().setPrettyPrinting().create();
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
			 Gson gson = new GsonBuilder().setPrettyPrinting().create();
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
			 Gson gson = new GsonBuilder().setPrettyPrinting().create();
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
    //set the Header of the invoice 
	public void setHeader(Shop shop) {

		HashMap<String, String> header = new HashMap<>();
		header.put("tel", shop.getTel());
		header.put("fax", shop.getFax());
		header.put("email", shop.getEmail());
		header.put("website", shop.getWebsite());
		
		Gson gson = new Gson();
		String json = gson.toJson(header);

		try (FileWriter writer = new FileWriter("Invoice header.json")) {
		    writer.write(json);
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	//Loads the data of the shop and prints it to the console.
	public void loadData()
	{
		System.out.println("-------------------------------------------");
		System.out.println("Shop name: " + getShopName());
		System.out.println("Shop Telephone: " + getTel());
		System.out.println("Shop Fax: " + getFax());
		System.out.println("Shop Email: " + getEmail());
		System.out.println("Shop Website: " + getWebsite());
		System.out.println("-------------------------------------------");
		deserialize();
	}
}// End of class
