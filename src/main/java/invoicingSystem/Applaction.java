/**
 * 
 */
package invoicingSystem;

import myEvaluation.MenuItem;
import myEvaluation.UserInputHandler;

/**
 * @author LAP-8
 *
 */
public class Applaction {

	public static void main(String[] args) {
	   
		//create the application main menu
		Menu applicationMainMenu = new Menu();
		
		//create the sub menu for Shop Settings
		Menu subMenuShopSettings = new Menu();
		subMenuShopSettings.addItem(new MenuItem(1 , "Load Data"));
		subMenuShopSettings.addItem(new MenuItem(2 , "Set Shop Name"));
		subMenuShopSettings.addItem(new MenuItem(3 , "Set Invoice Header"));
		subMenuShopSettings.addItem(new MenuItem(4 , "Go Back"));
		//add the sub menu for Shop setting to application main menu
		MenuItem shopSettingsMenuItem = new MenuItem(1, "Shop Settings");
		shopSettingsMenuItem.MarkItemAsMenu(subMenuShopSettings);
		//create the sub menu for Manage Shop Items
		Menu subMenuManageShopItems = new Menu();
		subMenuManageShopItems.addItem(new MenuItem(1 , "Add Items"));
		subMenuManageShopItems.addItem(new MenuItem(2 , "Delete Items"));
		subMenuManageShopItems.addItem(new MenuItem(3 , "Change Item Price"));
		subMenuManageShopItems.addItem(new MenuItem(4 , "Report All Items"));
		subMenuManageShopItems.addItem(new MenuItem(5 , "Go Back"));
		
		//add the sub menu for Manage Shop Items to application main menu
		MenuItem manageShopItemsMenuItem = new MenuItem(1, "Manage Shop Items");
		manageShopItemsMenuItem.MarkItemAsMenu(subMenuManageShopItems);
		
		//add items to the application main menu and set the name
		applicationMainMenu.setName("application Main Menu");
		applicationMainMenu.addItem(shopSettingsMenuItem);
		applicationMainMenu.addItem(manageShopItemsMenuItem);
		applicationMainMenu.addItem(new MenuItem(3, "Create New Invoice"));
		applicationMainMenu.addItem(new MenuItem(4, "Report: Statistics"));
		applicationMainMenu.addItem(new MenuItem(5, "Report: All Invoices"));
		applicationMainMenu.addItem(new MenuItem(6, "Search (1) Invoice"));
		applicationMainMenu.addItem(new MenuItem(7, "Program Statistics"));
		applicationMainMenu.addItem(new MenuItem(8, "Exit"));
		//print the menu with all sub menu
		System.out.println(applicationMainMenu.getName());
		System.out.println();
		applicationMainMenu.printMenu(0);
		
		
		UserInputHandler manager = new UserInputHandler();
		int choice = manager.getUserChoice();
		
		switch(choice) {
		case 1: 
		{
	    	MenuItem currMenuItem = applicationMainMenu.getMenuItem(1);
            currMenuItem.menu.printMenu();
            System.out.println();
		}
		case 2:
		{
			MenuItem currMenuItem = applicationMainMenu.getMenuItem(2);
            currMenuItem.menu.printMenu();
            System.out.println();
		}
		}//
	}

}
