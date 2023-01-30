package invoicingSystem;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
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
		     gson.toJson(product, writer);
		     writer.write(System.getProperty("line.separator"));
		   } catch (IOException e) {
		     e.printStackTrace();
		   }
		 }

	   
	   public void deleteItem() {
		    System.out.print("Enter item ID: ");
		    int itemId = manager.getUserChoice();
		 
		    int index = -1;
		    for (int i = 0; i < items.size(); i++) {
		      if (items.get(i).getItemId() == itemId) {
		        index = i;
		        break;
		      }
		    }
		    
		    if (index == -1) {
		      System.out.println("Item not found.");
		    } else {
		      items.remove(index);
		      
		      try (FileWriter writer = new FileWriter("items.json")) {
		        gson.toJson(items, writer);
		      } catch (IOException e) {
		        e.printStackTrace();
		      }
		    }
		  }
	   
	   public void changeItemPrice() {
		    System.out.print("Enter item ID: ");
		    int itemId = manager.getUserChoice();
		    
		    int index = -1;
		    for (int i = 0; i < items.size(); i++) {
		      if (items.get(i).getItemId() == itemId) {
		        index = i;
		        break;
		      }
		    }
		    
		    if (index == -1) {
		      System.out.println("Item not found.");
		      return;
		    }
		    
		    System.out.print("Enter new price: ");
		    double unitPrice = Double.parseDouble(manager.getUserChoiceString());
		    
		    Product product = items.get(index);
		    product.setUnitPrice(unitPrice);
	   }
	   
	   
	   public void readAndPrintItems() {
		   try (Reader reader = new FileReader("items.json")) {
		     items = gson.fromJson(reader, ArrayList.class);
		     for (Product product : items) {
		       System.out.println(product);
		     }
		   } catch (IOException e) {
		     e.printStackTrace();
		   }
		 }
}
