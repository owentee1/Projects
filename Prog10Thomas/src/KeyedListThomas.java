/**
 * This class represents a linked list of Pokemon objects.
 * This allows you to manage your army. You can alter your army in several ways as shown in the menu.
 * You can add, remove, print, and search for a Pokemon in your army.
 * You can also receive total power of army, receive total bonus power of your army,
 * see if your army is full or empty and finally clear your army.
 */
 /**
  * myHead - head of linked list
  * myList - Pokemon objects
  * curr - current node in Linked List
  * prev - previous node in Linked List
  */
public class KeyedListThomas 
{
	private NodeThomas myHead;
	private PokemonThomas[] myList;
	NodeThomas curr;
	NodeThomas prev;
/**
* null constructor for KeyedListThomas
*/
	public KeyedListThomas()
	{
		myHead = null;
	}//KeyedListThomas
/**
* getter for size of army that will be used through program. It returns value of mySize (the number of Pokemon objects currly in the army).
* @return mySize - size of army.
*/
	public int getSize()
	{
		int count = 0;
		NodeThomas curr = myHead;
		while (curr != null)
		{
			count++;
			curr = curr.getNext();
		}//while
		return count;
	}//getSize
/**
This method clears the keyed list (the army) it creates a new army (empty) of Pokemon objects and sets mySize to 0.
*/
	public void clear()
	{
		myHead = null;
	}//clear method
/**
* This method adds a new Pokemon to the army.
* If the army is empty, the new Pokemon becomes the head of the list.
* Otherwise it traverses the list to find the correct position to insert
* the Pokemon based on the name (String) and updates the references.
* Also does not allow duplicate Pokemon to be added using retrieve method if a pokemon with
* the same name as newPoke exists (not null) it will be found and not allowed to be added.
* @param newPoke - new Pokemon being added.
* @return added - successfully added.
*/
	public boolean add(PokemonThomas newPoke)
	{
		boolean added = false;
		boolean found = false;
		NodeThomas curr = myHead;
		NodeThomas prev = null;
		String currentName = null;
		PokemonThomas currentPokemon = null;
		NodeThomas newGuy = new NodeThomas();
		newGuy.setData(newPoke);
		newGuy.setNext(null);
		
		if (newPoke == null)
		{
			return false;
		}//if
		
		while (curr != null && !found)
		{
			currentPokemon = curr.getData();
			if (currentPokemon != null)
			{
				currentName = currentPokemon.getName();
			}
			if (newPoke.getName().compareToIgnoreCase(currentName) < 0)
			{
				found = true;
			}//if
			else
			{
				prev = curr;
				curr = curr.getNext();
			}//else
		}//while
		
		if (retrieve(newPoke.getName()) != null)
		{
			System.out.println("You cant add a duplicate Pokemon");
		}//if
		else
		{
			if (prev == null)
			{
				newGuy.setNext(myHead);
				myHead = newGuy;
			}//if
			else
			{
				newGuy.setNext(curr);
				prev.setNext(newGuy);
			}//else
			added = true;
		}//else
		return added;
	}//add method

/**
* Removes a Pokemon from the army based on its name (String).
* If the army is empty or if the Pokemon to delete doesn't exist, returns false.  
* Otherwise it travels through the list to find the Pokemon to delete (deletes it)
* and updates references
* 
* @param keyValue Pokemon to be removed.
* @return Pokemon removed successfully.
*/
	public boolean remove(String keyValue)
	{
		boolean removed = false;
		PokemonThomas currentPokemon;
		String currentName;
		NodeThomas curr = myHead;
		NodeThomas prev = null;
		
		while (curr != null)
		{
			currentPokemon = curr.getData();
			currentName = currentPokemon.getName();
			
			if (currentName.equalsIgnoreCase(keyValue))
			{
				if (prev == null)
				{
					myHead = curr.getNext();
				}//if
				else
				{
					prev.setNext(curr.getNext());
				}
				removed = true;
			}//if
			prev = curr;
			curr = curr.getNext();
		}//while
		return removed;
	}//removed method
/**
* This method iterates through keyed list and retrieves the Pokemon of your choice by name and assigns it to foundYourPokemon (if found).
* @param keyValue the name of the Pokemon object you want to retrieve.
* @return the Pokemon object you were looking for if it existed.
*/
	public PokemonThomas retrieve(String keyValue)
	{
		NodeThomas curr = myHead;
		PokemonThomas currentPokemon;
		String currentPokemonName;
		
		while (curr != null)
		{
			currentPokemon = curr.getData();
			currentPokemonName = currentPokemon.getName();
			
			if (currentPokemonName.equalsIgnoreCase(keyValue))
			{
				return currentPokemon;
			}//if
			curr = curr.getNext();
		}
		return null;
	}//retrieve method
/**
* Checks whether the army is empty or not
* @return True if army is empty
*/
	public boolean isEmpty()
	{
		return myHead == null;
	}//isEmpty method
/**
* Checks whether the army is full. Linked list cannot be full with the exception of allocating all of computers RAM.
* @return returns false.   
*/
	public boolean isFull()
	{
		return false;
	}//isFull method
/**
* This method prints the details of all of the Pokemon objects in the list.
*/
	public void print()
	{
		NodeThomas curr = myHead;
		while (curr != null)
		{
			System.out.println(curr.getData().toString());
			curr = curr.getNext();
		}//while
	}//print method
/**
* This method calculates the total power of your army by summing up all individual powers
* @return total power of your army.
*/
	public double calcTotalPower()
	{
		PokemonThomas currentPokemon = null;
		double totalPower = 0.00;
		double power = 0.00;
		NodeThomas curr = myHead;
		
		while (curr != null)
		{
			currentPokemon = curr.getData();
			power = currentPokemon.getPower();
			totalPower += power;
			curr = curr.getNext();
		}
		return totalPower;
	}
/**
 * calcBonus method- calculates the bonus power of the Pokemon Army.
 * @return - Total bonus power of the Army.
 */
	public double calcBonusPower()
	{
		PokemonThomas currentPokemon = null;
		double bonusPower = 0.00;
		NodeThomas curr = myHead;
		double power = 0.00;
		double multiplier = 0.00;
		
		while (curr != null)
		{
			currentPokemon = curr.getData();
			power = currentPokemon.getPower();
			multiplier = currentPokemon.getMulitplier();
			bonusPower += power * multiplier;
			curr = curr.getNext();
		}//while
		return bonusPower;
	}//calcBonusPower
}//KeyedListThomas
