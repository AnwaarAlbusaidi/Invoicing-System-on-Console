package invoicingSystem;

/**
 * @author LAP-8
 *
 */
public class Applaction {

	public static void main(String[] args) {

		// create the application main menu
		int choice ; //for the application main menu
		int userChoice; //for the sub menu
		boolean turn = true;
		Menu applicationMainMenu = new Menu();
		Shop shop = new Shop("grocerie Shop", "91234567", "24412345", "grocerieShop@gamil.com", "grocerie.com");
		// create the sub menu for Shop Settings
		Menu subMenuShopSettings = new Menu();
		subMenuShopSettings.setName("Shop Settings");
		subMenuShopSettings.addItem(new MenuItem(1, "Load Data"));
		subMenuShopSettings.addItem(new MenuItem(2, "Set Shop Name"));
		subMenuShopSettings.addItem(new MenuItem(3, "Set Invoice Header"));
		subMenuShopSettings.addItem(new MenuItem(4, "Go Back"));
		// add the sub menu for Shop setting to application main menu
		MenuItem shopSettingsMenuItem = new MenuItem(1, "Shop Settings");
		shopSettingsMenuItem.MarkItemAsMenu(subMenuShopSettings);
		// create the sub menu for Manage Shop Items
		Menu subMenuManageShopItems = new Menu();
		subMenuManageShopItems.setName("Manage Shop Items");
		subMenuManageShopItems.addItem(new MenuItem(1, "Add Items"));
		subMenuManageShopItems.addItem(new MenuItem(2, "Delete Items"));
		subMenuManageShopItems.addItem(new MenuItem(3, "Change Item Price"));
		subMenuManageShopItems.addItem(new MenuItem(4, "Report All Items"));
		subMenuManageShopItems.addItem(new MenuItem(5, "Go Back"));

		// add the sub menu for Manage Shop Items to application main menu
		MenuItem manageShopItemsMenuItem = new MenuItem(2, "Manage Shop Items");
		manageShopItemsMenuItem.MarkItemAsMenu(subMenuManageShopItems);

		// add items to the application main menu and set the name
		applicationMainMenu.setName("application Main Menu");
		applicationMainMenu.addItem(shopSettingsMenuItem);
		applicationMainMenu.addItem(manageShopItemsMenuItem);
		applicationMainMenu.addItem(new MenuItem(3, "Create New Invoice"));
		applicationMainMenu.addItem(new MenuItem(4, "Report: Statistics"));
		applicationMainMenu.addItem(new MenuItem(5, "Report: All Invoices"));
		applicationMainMenu.addItem(new MenuItem(6, "Search (1) Invoice"));
		applicationMainMenu.addItem(new MenuItem(7, "Program Statistics"));
		applicationMainMenu.addItem(new MenuItem(8, "Exit"));
		// print the menu with all sub menu
		System.out.println(applicationMainMenu.getName());
		System.out.println();
		applicationMainMenu.printMenu();

		UserInputHandler manager = new UserInputHandler();
		System.out.println("Enter your choice: ");
	    choice = manager.getUserChoice();
	do {
			switch (choice) {
			case 1:{
				MenuItem currMenuItem = applicationMainMenu.getMenuItem(1);
				System.out.println(subMenuShopSettings.getName());
				System.out.println();
				currMenuItem.menu.Show(0);
				System.out.println("Enter your choice: ");
				userChoice = manager.getUserChoice();
				switch (userChoice) {
				case 1: 
					System.out.println("Load Data");
					break;
				case 2: 
					System.out.println("Set Shop Name");
					shop.setShopName();
					shop.saveShopDetails(shop, "shop.json");
					break;
				case 3: 
					shop.setHeader(shop);
					break;
				case 4: 
					applicationMainMenu.printMenu();
					System.out.println("Enter your choice: ");
					choice = manager.getUserChoice();
					continue;
				}
				break;
			}
			case 2: {
				MenuItem currMenuItem = applicationMainMenu.getMenuItem(2);
				System.out.println(subMenuManageShopItems.getName());
				System.out.println();
				currMenuItem.menu.Show(1);
				System.out.println("Enter your choice: ");
				userChoice = manager.getUserChoice();
				switch (userChoice) {
				case 1: 
					System.out.println("Add item");
					shop.addItem();
					break;
				case 2: 
					shop.deleteItem();
					System.out.println("Delete item Done");
					break;
				case 3:
					shop.updatePrice();
					System.out.println("update price Done");
					break;
				case 4: 
					shop.deserialize();
					break;
				case 5: 
					applicationMainMenu.printMenu();
					System.out.println("Enter your choice: ");
					choice = manager.getUserChoice();
					continue;
				}// End of switch userChoice2
			break;
			}
			case 3: 
				break;
			case 4: 
				break;
			case 5: 
				break;
			case 6: 
				break;
			case 7: 
				break;
			case 8: 
			   while (choice == 8) {
				System.out.println("Are you sure you want to exit? If yes, program ends, if No , then main menu reprinted again");
				System.out.println("Enter your input: ");
				String choiceString = manager.getUserChoiceString();
				if (choiceString.equals("yes") ) {
					System.out.println("Exiting program...");
					turn = false;
					break;
				}
				else if(choiceString.equals("no"))
				{
					applicationMainMenu.printMenu();
					System.out.println("Enter your choice: ");
					choice = manager.getUserChoice();
					break;
				}
			}
			break;
			}// End of switch
		}while(turn != false); // End of while
	}//End of class Main
}// End of Application class
