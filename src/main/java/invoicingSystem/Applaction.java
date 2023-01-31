/**
 * 
 */
package invoicingSystem;

/**
 * @author LAP-8
 *
 */
public class Applaction {

	public static void main(String[] args) {

		// create the application main menu
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
		int choice = manager.getUserChoice();
	do {
			switch (choice) {
			case 1: {
				MenuItem currMenuItem = applicationMainMenu.getMenuItem(1);
				System.out.println(subMenuShopSettings.getName());
				System.out.println();
				currMenuItem.menu.Show(0);
				System.out.println("Enter your choice: ");
				int userChoice = manager.getUserChoice();
				switch (userChoice) {
				case 1: {
					System.out.println("Load Data");
					break;
				}
				case 2: {
					System.out.println("Set Shop Name");
					shop.SetShopName();
					shop.saveShopDetails(shop, "shop.json");
					break;
				}
				case 3: {
					System.out.println("Set Invoice Header");
					break;
				}
				case 4: {
					applicationMainMenu.Show(0);
					choice = 0;
					System.out.println("Enter your choice: ");
					choice = manager.getUserChoice();
					break;
				}
				}
				break;
			} // End of case 1
			case 2: {
				MenuItem currMenuItem = applicationMainMenu.getMenuItem(2);
				System.out.println(subMenuManageShopItems.getName());
				System.out.println();
				currMenuItem.menu.Show(1);
				System.out.println("Enter your choice: ");
				int userChoice2 = manager.getUserChoice();
				;
				switch (userChoice2) {
				case 1: {
					System.out.println("Add item");
					shop.addItem();
					break;
				}
				case 2: {
					System.out.println("Delete item");
					break;
				}
				case 3: {
					System.out.println("change item price");
					break;
				}
				case 4: {
					System.out.println("Report all item");
					shop.deserialize();
					break;
				}
				case 5: {
					applicationMainMenu.Show(0);
					choice = 0;
					System.out.println("Enter your choice: ");
					choice = manager.getUserChoice();
					break;
				}
				}// End of switch userChoice2
			} // End of case 2
			case 3: {
				break;
			}
			case 4: {
				break;
			}
			case 5: {
				break;
			}
			case 6: {
				break;
			}
			case 7: {
				break;
			}
			case 8: 
			   while (choice == 8) {
				System.out.println("Are you sure you want to exit? If yes, program ends, if No , then main menu reprinted again");
				System.out.println("Enter your input: ");
				String choiceString = manager.getUserChoiceString();
				if (choiceString.equals("yes") ) {
					System.out.println("Exiting program...");
					break;
				}
				else if(choiceString.equals("no"))
				{
					applicationMainMenu.Show(0);
					choice = 0;
					System.out.println("Enter your choice: ");
					choice = manager.getUserChoice();
					break;
				}
			}
			break;
			}// End of switch
		}while(choice != 8); // End of while
	}//End of class Main
}// End of Application class
