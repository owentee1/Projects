import java.text.*;
/**
 * This class represents a menu item with name, quantity, and price. It includes getters and
 * setters to do so. It also includes a toString that organizes the information in an organized format.<br>
 * 
 * @author Owen Thomas<br>
 * 
 * Prog 7 <br>
 * Due Date  and Time: 3/21/24 before 9:00 AM <br>
 * 
 * Purpose: This program acts as an ordering system for what I imagine to be a fast food restaurant. It takes the customer's order and keep tracks of it.
 * 			It tells the customer (if they desire) the number of items, the total cost of the order, the most expensive and least expensive item and brief text
 * 			description of their order.
 * 
 * Input: Adding menu item including the name, quantity, price.<br>
 * 
 * Output: After adding item(s) to the menu, you are able to ask for the least/most expensive item, 
 * 		   number of items, total cost of all items and details of your order <br>
 * Certification of Authenticity: <br> 
 * I certify that this lab is entirely my own work. <br>
 */

public class MenuItemThomas 
{
/**
 * moneyStyle used to format price or total to 2 decimal places representing common currency representation.
 */
	static DecimalFormat moneyStyle = new DecimalFormat("0.00");
/**
 * myName - name of the menu item.
 */
	private String myName; //myName 
/**
 * myQuant - Quantity of the Menu Items.
 */
	private int myQuant;
/**
* myPrice - Price of the Menu Items.
*/
	private double myPrice;
/**
* Null Constructor for MenuItem assigning default values.
*/
	public MenuItemThomas()
	{
		myName = "None";
		myQuant = 0;
		myPrice = 0;
	}//null
/**
* Full Constructor for MenuItem newName, newQuant, newPrice
* @param newName - name of menu item being created.
* @param newQuant - quantity of the menu item being created.
* @param newPrice - price of the menu item being created.
*/
	public MenuItemThomas(String newName, int newQuant, double newPrice)
	{
		myName = newName;
		myQuant = newQuant;
		myPrice = newPrice;
	}//full
/**
* Getter - gets the name of the menu items.
* @return - the name of the menu item.
*/
	public String getName()
	{
		return myName;
	}//getter Name
/**
* Setter- sets the name of the menu items.
* @param newName Name of the new menu items.
*/
	public void setName(String newName)
	{	myName = newName;	}//setter Name
/**
 * Getter - gets the quantity of the menu items.	
 * @return - the quantity of the menu items.
 */
	public int getQuant()
	{
		return myQuant;
	}//getter Quant
/**
 * Setter- sets the quantity of the menu item.
 * @param newQuant - new quantity of the menu items.
 */
	public void setQuant(int newQuant)
	{	myQuant = newQuant;	}//setter Quant
/**
 * Getter- gets price of the menu items.
 * @return - price of the menu items.
 */
	public double getPrice()
	{
		return myPrice;
	}//getter Price
/**
 * Setter - sets the price of the menu items.
 * @param newPrice new price of the menu items.
 */
	public void setPrice(double newPrice)
	{	myPrice = newPrice;	}//setter Price
/**
 * toString Method - details for the order including name, quantity and total
 * @return - returns a string containing the name, quantity and price of the menu items.
 */
	public String toString()
	{
		String ans = "Name: " + myName + "\n";
        ans += "Quantity: " + myQuant + "\n";
        ans += "Total: $" + moneyStyle.format(myPrice) + "\n";
        return ans;
	}//toString Method
}//MenuItemThomasClass
