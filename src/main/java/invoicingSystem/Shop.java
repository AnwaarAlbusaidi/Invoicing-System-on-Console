package invoicingSystem;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class Shop {
	   private String shopName;
	   private String tel;
	   private String fax;
	   private String email;
	   private String website;
	   private ArrayList<Product> items;
	   private ArrayList<Invoice> invoices;
	   private Gson gson = new Gson();
	   
	   
	   public Shop(String shopName,String tel,String fax,String email,String website)
	   {
		   this.shopName = shopName;
		   this.tel = tel;
		   this.fax = fax;
		   this.email = email;
		   this.website = website;
	   }
	   
	   public static void saveShopDetails(Shop shop, String fileName) {
		      Gson gson = new GsonBuilder().setPrettyPrinting().create();
		      ArrayList<Shop> shopList = new ArrayList<Shop>();
		      try (FileReader reader = new FileReader(fileName)) {
		         shopList = gson.fromJson(reader, new TypeToken<ArrayList<Shop>>(){}.getType());
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
	   
	   public void addItem() {
		   UserInputHandler manager = new UserInputHandler();
			
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
		      gson.toJson(items, writer);
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		  }
}
