package invoicingSystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.sound.midi.VoiceStatus;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class Shop {
	   String shopName;
	   private String tel;
	   private String fax;
	   private String email;
	   private String website;
	  // ArrayList<HashMap<Product, Object>> items = new ArrayList<>();
	   private ArrayList<Product> items = new ArrayList<Product>();
	   private ArrayList<Invoice> invoices = new ArrayList<Invoice>();
	   private Gson gson = new GsonBuilder().setPrettyPrinting().create();;
	   private UserInputHandler manager = new UserInputHandler();
	   
	   public Shop(String shopName,String tel,String fax,String email,String website)
	   {
		   this.shopName = shopName;
		   this.tel = tel;
		   this.fax = fax;
		   this.email = email;
		   this.website = website;
	   }
//	   
//	   public Shop getShopData() {
//		   return this.shop;
//	   }
	   
	   public void SetShopName()
	   {
		   String newShopName;
		   System.out.print("Enter the new shop name: ");
		   newShopName = manager.getUserChoiceString();
		   this.shopName = newShopName;
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

		   try (FileWriter writer = new FileWriter("items.json", true)) {
		        Gson gson = new Gson();
				String json = gson.toJson(items);
				writer.write(json);
				writer.write(System.getProperty("line.separator"));
				writer.flush();
		   } catch (IOException e) {
		     e.printStackTrace();
		   }
		 }
	   
	   public void deserialize() {
		   try (Reader reader = new BufferedReader(new FileReader("items.json"))) {
			List<Product> itemsList = gson.fromJson(reader, new TypeToken<List<Product>>(){}.getType());
		     for (Product product : itemsList) 
		     {
		       System.out.println("Product id: " + product.getItemId());
		       System.out.println("Product Name: " + product.getItemName());
		       System.out.println("Product Unit Price: " + product.getUnitPrice());
		       System.out.println("Product Quantity : " + product.getQuantity());
   	     }
		   } catch (IOException e) {
		     e.printStackTrace();
		   }
		 }
	
}//End of class
