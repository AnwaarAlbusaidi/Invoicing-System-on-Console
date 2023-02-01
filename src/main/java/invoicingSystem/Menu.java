package invoicingSystem;

import java.util.ArrayList;

/**
 * Description: The Menu class represents a menu in a program. The class
 * contains a list of MenuItem instances and has methods to add and retrieve
 * items, set the name of the menu, show the menu, and print the menu.
 */
public class Menu {
	private String name;
	private ArrayList<MenuItem> items = new ArrayList<MenuItem>();

	/**
	 * Input: name (String)
	 *  Output: None 
	 *  Description: This method sets the name of
	 * the current menu.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Input: None 
	 * Output: String 
	 * Description: This method returns the name of the
	 * current menu.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Input: An instance of the MenuItem class
	 * Output: None
	 * Description: This method adds a new item to the current menu by passing in an instance of the
	 * MenuItem class.
	 */
	public void addItem(MenuItem item) {
		items.add(item);

	}

	/**
	 * Input: id (integer) 
	 * Output: An instance of the MenuItem class Description: This
	 * method returns the item in the menu with the specified ID.
	 */
	public MenuItem getMenuItem(int id) {
		return items.get(id - 1);
	}

	/**
	 * Input: level (integer)
	 * Output: None Description: This method shows the current
	 * menu and any sub-menus in a hierarchical format, with the level of
	 * indentation indicating the level of the menu in the hierarchy.
	 */
	public void Show(int level) {
		for (MenuItem currentItem : items) {
			for (int i = 0; i < level; i++) {
				System.out.print("\t");
			}
			System.out.println(currentItem.id + "- " + currentItem.description);
			if (currentItem.isMenu()) {
				currentItem.menu.Show(level + 1);
			}
		}
	}

	/**
	 * Input: None
	 * Output: None 
	 * Description: This method prints the items in the current menu.
	 */
	public void printMenu() {
		for (MenuItem currentItem : items)
			currentItem.printItem();
	}
}
