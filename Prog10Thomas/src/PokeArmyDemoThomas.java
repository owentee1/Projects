/**
* @author Owen Thomas <br>
* 
* Prog 10 <br>
* Due Date  and Time: 4/11/24 before 9:00 AM <br>
* 
* Purpose: This program allows you build input an army using an input file. Once your army is added you are able to
* add a Pokemon, remove a Pokemon, print your army with details, search for a Pokemon in your army, get the total
* power of your army, get the total bonus power of your army, determine whether your army is empty or full,
*  and clear your army.<br>
* 
* Input: Any properly formated input file. I used the sample input file from Dr. Schwartz, I also built a input file
* 		 that consisted of a full army, and empty army for testing purposes. <br>
* 
* Output: the output is tells you whether your input file was loaded successfully or not along with feedback after each
* 		  each menu choice is executed.<br>
* Certification of Authenticity: <br> 
* I certify that this lab is entirely my own work. <br>

* This class allows you to manage your army using the convenient menu.
*/

import java.util.*;
import java.io.*;
/**
 * Default Constructor for PokeArmyDemoThomas
 */
public class PokeArmyDemoThomas 
{
/**
 * Scanner is used to make inputs from keyboard
 */
static Scanner keyboard = new Scanner(System.in);
/**
 * Main default
 * 
 * @param args standard
 */
public static void main(String[] args)
{
	KeyedListThomas army = new KeyedListThomas();
	String name = "None";
	int multiplier = 0;
	double power = 0.00;
	String choice;
	boolean added;
	boolean removed;
	boolean empty;
	boolean full;
	String pokeToDelete = null;
	String pokeToSearch = null;
	PokemonThomas foundPokemon = null;
	String fileName;
	int numberOfPoke = 0;
	PokemonThomas newPoke = null;
	PokemonThomas newPokemon = new PokemonThomas(name, multiplier, power);
	
	System.out.println("Enter the input file for your Pokemon Army please!: ");
	fileName = keyboard.next();
	File inputFile = new File(fileName);

	try
	{
		Scanner input = new Scanner(inputFile);
		
		numberOfPoke = input.nextInt();
		int i = 0;
		for (i = 0; i < numberOfPoke; i++)
		{
			name = input.next();
			multiplier = input.nextInt();
			power = input.nextDouble();
			newPokemon = new PokemonThomas(name, multiplier, power);
			army.add(newPokemon);
		}//for
		System.out.println("Pokemon input file loaded succesfully!");
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
		System.out.println("Something went wrong");
	  ex.printStackTrace();
	}//catch

	do
	{
		System.out.println("Menu:");
		System.out.println("1. Add a Pokemon to the army");
		System.out.println("2. Delete a Pokemon from the army");
		System.out.println("3. Print each Pokemon in the army");
		System.out.println("4. Search for a user-specified Pokemon in the army");
		System.out.println("5. Get the total power of the Pokemon army");
		System.out.println("6. Get the bonus power of the Pokemon army");
		System.out.println("7. Determine whether the army is empty");
		System.out.println("8. Determine whether the army is full");
		System.out.println("9. Clear the army");
		System.out.println("0. Quit");
		
		System.out.println("Enter your choice here please: ");
		choice = keyboard.next();
		
		switch (choice)
		{
		case "1":
			System.out.println("You chose the menu option to add a Pokemon");
			System.out.println("Enter the name of your Pokemon here:");
			name = keyboard.next();
			System.out.println("Enter the multiplier for your Pokemon here: ");
			multiplier = keyboard.nextInt();
			while (multiplier <= 0) 
			{
			    System.out.println("Multiplier must be greater than 0. Please enter a valid multiplier: ");
			    multiplier = keyboard.nextInt();
			}//while
			System.out.println("Enter your Pokemon's power here: ");
			power = keyboard.nextDouble();
			while (power <= 0) 
			{
			    System.out.println("Power must be greater than 0. Please enter a valid power: ");
			    power = keyboard.nextDouble();
			}//while

			
			newPoke = new PokemonThomas(name, multiplier, power);
			
			added = army.add(newPoke);
			if (added)
			{
				System.out.println(name + " added to your Army successfully!");
			}//if
			else
			{
				System.out.println("Your Pokemon " + name + " was not added to army. "
						+ "Your army may be full or you tried adding a Pokemon that already exists.");
			}//else
			break;
		case "2":
			System.out.println("You chose the menu option to delete a Pokemon");
			System.out.println("Enter the name of the Pokemon you would like to delete:");
			pokeToDelete = keyboard.next();
			removed = army.remove(pokeToDelete);
			if (removed)
			{
				System.out.println(pokeToDelete + " was removed from army successfully");
			}//if
			else
			{
				System.out.println("Sorry, but your army does not contain the Pokemon " + pokeToDelete);
			}//else
			break;
		case "3":
			System.out.println("You chose the menu option to print each Pokemon in your army.");
			if (army.getSize() == 0)
			{
				System.out.println("Your army is currently empty");
			}//if
			else
			{
				army.print();
			}//else
			break;
		case "4":
			System.out.println("You chose the menu option to search for a Pokemon");
			System.out.println("Enter the name of the Pokemon you want to search for here: ");
			pokeToSearch = keyboard.next();
			foundPokemon = army.retrieve(pokeToSearch);
			if (foundPokemon != null)
			{
				System.out.println("Pokemon found:\n" + foundPokemon.toString());
			}//if
			else
			{
				System.out.println("Pokemon " + pokeToSearch + " was not found");
			}//else
			break;
		case "5":
			System.out.println("You chose the menu option to calculate the total power of your army");
			System.out.println("Total power of your Pokemon army: " + army.calcTotalPower());
			break;
		case "6":
			System.out.println("You chose the menu option to calculate the bonus power of your army.");
			System.out.println("Bonus power of your Pokemon army: " + army.calcBonusPower());
			break;
		case "7":
			System.out.println("You chose the option to see whether your army is empty or not");
			empty = army.isEmpty();
			if(empty)
			{
				System.out.println("Your army is empty");
			}//if
			else
			{
				System.out.println("Your army is not empty");
			}//else
			break;
		case "8":
			System.out.println("You chose the option to see whether your army is full or not");
			full = army.isFull();
			if (full)
			{
				System.out.println("Your army is full!");
			}//if
			else
			{
				System.out.println("Your army is not full!");
			}//else
			break;
		case "9":
			System.out.println("You chose the option to clear your army");
			army.clear();
			System.out.println("Your army was cleared successfully!");
			break;
		case "0":
			System.out.println("Quiting...Thanks!...Come back again and build your army!");
			break;
		default:
			System.out.println("Invalid menu choice. Please enter a valid option");
			break;
		}//switch	
	  }while (!choice.equals("0"));//while
   }//main
}//PokeArmyDemoThomas

	

