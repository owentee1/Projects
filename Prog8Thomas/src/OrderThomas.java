/**
 * This class handles the ordering of menu items. You can add items to your order,
 * you can find the least expensive item/most expensive item, have your total calculated
 * for your order, get the count(number of items in your order) of your items, and receive
 * a small detail printout of your order.
 */

public class OrderThomas 
{
	/**
	 * myMenuItems - is an Array to store up to 8 menu items.
	 */
	private MenuItemThomas[] myMenuItems;

	/**
	 * mySize - the number of menu items in your order.
	 */
	private int mySize;
/**
 * Constructor for a non-filled order.
 */
	public OrderThomas()
	{
		myMenuItems = new MenuItemThomas[8];
		int i = 0;
		for (i = 0; i < myMenuItems.length; i++)
		{
			myMenuItems[i] = new MenuItemThomas();
		}//for
		mySize = 0;
	}//constructor
/**
 * 	Getter method - get the size (number of menu items in current order)
 * @return mySize
 */
public int getSize()
{
	return mySize;
}//getter Size
/**
 * addToOrder - adds menu items to your order.
 * @param item - menu item that was added.
 * @return True/False depending on whether the item was added successfully or not.
 */
public boolean addToOrder(MenuItemThomas item)
{
	boolean added = false;
	if (mySize < myMenuItems.length)
	{
		myMenuItems[mySize++] = item;
		added = true;
	}//if
	return added;
}//addToOrder Method
/**
 * findMostExpensive - this method initializes the mostExpItem variable to the first item then iterates 
 * through the remainder to see if there is a more expensive item.
 * @return - either null or most expensive item.
 */
public MenuItemThomas findMostExpensive()
{
	MenuItemThomas mostExpItem = null;
	int i = 1;
	for (i = 0; i < mySize; i++)
	{
		if (mostExpItem == null || myMenuItems[i].getPrice() > mostExpItem.getPrice())
		{
			mostExpItem = myMenuItems[i];
		}//if
	}//for
	return mostExpItem;	
}//findMostExp Method
/**
 * findLeastExpensive - this method initializes leastExpItem variable to the first item, then iterates through the
 *  remainder to see if there is a less expensive item exists.
 * @return - null or least expensive item.
 */
public MenuItemThomas findLeastExpensive()
{
	int i = 1;
	MenuItemThomas leastExpItem = null;
	if (mySize > 0)
	{
		leastExpItem = myMenuItems[0];
	  for (i = 1; i < mySize; i++)
	  {
		  if (myMenuItems[i].getPrice() < leastExpItem.getPrice())
		  {
			  leastExpItem = myMenuItems[i];
		  }//if
			
	  }//for
	}//if
	return leastExpItem;
}//findLeastExpensive Method
/**
 * calcTotal - this method initializes total to 0 then, iterates through all menu items in your order. 
 * For each menu item it multiplies price of item by its quantity and adds to total variable, then returns total.
 * @return total double which is what you owe.
 */
public double calcTotal()
{
	double total = 0;
	int i = 0;
	for(i = 0; i < mySize; i++)
	{
		total += myMenuItems[i].getPrice() * myMenuItems[i].getQuant();
	}//for
	return total;
}//calcTotal Method
/**
 * getCount- this method initializes count to 0 then iterates through all menu items. For every item it uses
 *  getQuant to get quantity then adds it to count variable and returns count.
 * @return total count of items in your order.
 */
public int getCount()
{
	int count = 0;
	int i = 0;
	for (i = 0; i < mySize; i++)
	{
		count += myMenuItems[i].getQuant();
	}//for
	return count;
}//getCount method
/**
 * printList - this method prints the details of all the items in your order. 
 * Seen at most fast food ordering screens.
 */
public void printList()
	{
		int i = 0;
		for (i = 0; i < mySize; i++)
		{
			System.out.println(myMenuItems[i].toString());
		}//for
	}//printList Method 
}//OrderThomasClass
