/**
 * 
 */
package invoicingSystem;

/**
 * @author LAP-8
 *
 */
public class MenuItem {
   
	int id;
	String description;
	Menu menu = null;

	public MenuItem(int id, String description) {
		this.id = id;
		this.description = description;
	}

	public boolean isMenu() {
		return menu != null;
	}

	public void MarkItemAsMenu(Menu menu1) {
		this.menu = menu1;
	}
	
	public void printItem() {
		System.out.println(this.id + " : " + this.description);
//    	if (this.isMenu())
//    		menu.printMenu();
	}
}
