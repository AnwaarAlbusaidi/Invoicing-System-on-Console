/**
 * 
 */
package invoicingSystem;

import java.util.ArrayList;



public class Menu {
		   private String name;
		    private ArrayList<MenuItem> items = new ArrayList<MenuItem>();

		    public Menu() {
		    }
		    public void setName(String name) {
		    	this.name = name;
		    }
			public String getName() {
		        return name;
		    }
			public void addItem(MenuItem item) {
				items.add(item);
				
			}
			public MenuItem getMenuItem(int id) {        
		        return items.get(id-1);
		    }
			public void Show(int level)
			{
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
			
			public void printMenu()
			{
				for (MenuItem currentItem : items)
					currentItem.printItem();
			}
}
