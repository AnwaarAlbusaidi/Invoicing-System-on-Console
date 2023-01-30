package invoicingSystem;

/**
 * Description: The MenuItem class represents an item in a menu. The class
 * contains information about the item's ID, description, and whether or not it
 * is a sub-menu.
 */
public class MenuItem {

	int id;
	String description;
	Menu menu = null;

	/**
	 * 
	 * @param id(integer), description (String)
	 * @param description Output: None Description: This constructor creates a new
	 *  instance of the MenuItem class with the specified ID and description.
	 */
	public MenuItem(int id, String description) {
		this.id = id;
		this.description = description;
	}

	/**
	 * Input: None Output: Boolean value Description: This method returns a boolean
	 * value indicating whether the current item is a sub-menu or not.
	 * @return true if the menu is sub menu
	 */
	public boolean isMenu() {
		return menu != null;
	}

	/**
	 * @param menu1 Input: An instance of the Menu class Output: None Description:
	 *  This method sets the current item as a sub-menu by passing in an
	 * instance of the Menu class
	 */
	public void MarkItemAsMenu(Menu menu1) {
		this.menu = menu1;
	}

	/**
	 * Input: None Output: None Description: This method prints the ID and
	 * description of the current item.
	 */
	public void printItem() {
		System.out.println(this.id + " : " + this.description);
	}
}
