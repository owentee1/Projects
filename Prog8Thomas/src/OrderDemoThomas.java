import java.util.*;
import java.io.*;
import java.text.*;
/**
 * This Class holds the methods for the customer to interact with the menu(kiosk).
 */
/**
 * Default Constructor for OrderDemoThomas
 */
public class OrderDemoThomas 
{
/**
 * Scanner is used to make inputs from keyboard
 */
static Scanner keyboard = new Scanner(System.in);
/**
 * Format for displaying price or total.
 */
static DecimalFormat moneyStyle = new DecimalFormat("0.00");
/**
 * Main Method
 * @param args - standard
 */

public static void main(String[] args)
{
	OrderThomas order = new OrderThomas();
	char choice;
	String currItem = "None";
	int quantity = 0;
	double price = 0;
	int numberOfItems = 0;
	String fileName = null;
	MenuItemThomas item = null;
	MenuItemThomas leastExpItem = null;
	MenuItemThomas mostExpItem = null;
	int i = 0;
	
	System.out.print("Welcome to MickeyD's Please enter a file name: ");
	fileName = keyboard.next();
	
	File inputFile = new File(fileName);
	
	try
    {
      
      Scanner input = new Scanner(inputFile);
      
      
      numberOfItems = input.nextInt();
      for (i = 0; i < numberOfItems; i++)
      {
    	  String itemName = input.next();
    	  int itemQuantity = input.nextInt();
    	  double itemPrice =input.nextDouble();
    	  item = new MenuItemThomas(itemName, itemQuantity, itemPrice);
    	  order.addToOrder(item);
      }//for
      input.close();
    }//try
    catch(FileNotFoundException ex)
    {
      System.out.println("Failed to find file: " + inputFile.getAbsolutePath()); 
    }//catch
    catch(InputMismatchException ex)
    {
    	System.out.println("Type mismatch for the number I just tried to read.");
        System.out.println(ex.getMessage());
    }//catch
    catch(NumberFormatException ex)
    {
      System.out.println("Failed to convert String text into an integer value.");
      System.out.println(ex.getMessage());
    }//catch
    catch(NullPointerException ex)
    {
      System.out.println("Null pointer exception.");
      System.out.println(ex.getMessage());
    }//catch
    catch(Exception ex)
    {
      // Like an "else" catch(Exception should come last as the catchall.
    	System.out.println("Something went wrong");
      ex.printStackTrace();
    }//catch

	do
	{
		System.out.println("Welcome to MickyD's! May I take your order?");
		System.out.println("Menu");
		System.out.println("A - Add a MenuItem to the Order");
		System.out.println("L - Find the Least Expensive MenuItem in the Order");
		System.out.println("M - Find the Most Expensive MenuItem in the Order");
		System.out.println("N - Find the number of MenuItems in the Order ");
		System.out.println("T - Find the total cost of all MenuItems in the Order");
		System.out.println("P - Print out details about all the MenuItems in the Order");
		System.out.println("Q - Quit");
		
		System.out.println("Enter your choice here please: ");
		choice = keyboard.next().toUpperCase().charAt(0);
	
	switch(choice)
	{
	case 'A':
		System.out.println("Enter the name of your Menu Item here: ");
		currItem = keyboard.next();
		System.out.println("Enter the quantity of item here: ");
		quantity = keyboard.nextInt();
		System.out.println("Enter price of item here: ");
		price = keyboard.nextDouble();
		item = new MenuItemThomas(currItem, quantity, price);
				if (order.addToOrder(item))
				{
					System.out.println("Your Menu Item has been added to order!");
				}//if
				else
				{
					System.out.println("Error! Your Item was not added to order!");
				}//else
				break;
	case 'L':
			leastExpItem = order.findLeastExpensive();
			if (leastExpItem != null)
			{
				System.out.println("Your least expensive item " + leastExpItem.toString());
			
			}//if
			else
			{
				System.out.println("There are no Menu Items in your order");
			}//else
			break;
		case 'M':
			mostExpItem = order.findMostExpensive();
			if (mostExpItem != null)
			{
				System.out.println("Your most expensive item " + mostExpItem.toString());
			}//if
			else
			{
				System.out.println("There are no Menu Items in your order");
			}//else
			break;
		case 'N':
			System.out.println("There are " + order.getCount() + " items in your order");
			break;
		case 'T':
			System.out.println("Your total: $" + moneyStyle.format(order.calcTotal()));
			break;
		case 'P':
			System.out.println("Your order details:");
			System.out.println();
			order.printList();
			break;
		case 'Q':
			System.out.println("Quiting...Thank you...come again!");
			break;
		default:
			System.out.println("You entered an invalid menu option, please try again!");
			}//switch
		}while (choice != 'Q'); //do-while
	keyboard.close();
	}//main
}//OrderDemoThomas Class
