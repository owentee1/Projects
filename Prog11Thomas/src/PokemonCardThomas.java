/**
 * This class is used to create a Pokemon Card with a name, multiplier and power.
 */
public class PokemonCardThomas 
{
/**
 * Name of the Pokemon on the Pokemon Card.
 */
private String myName;
/**
 * The multiplier of the Pokemon on the Pokemon Card.
 */
private int myMultiplier;
/**
 * The power of the Pokemon on the Pokemon Card.
 */
private double myPower;
/**
 * Null constructor that initialized the Pokemon Card variables with default values.
 */
public PokemonCardThomas()
{
	myName = "None";
	myMultiplier = 0;
	myPower = 0.00;
}//PokemonCard null
/**
 * Full constructor that initializes the previously default values into the values give in the input
 * file or in the Master Deck.
 * @param newName - name of Pokemon
 * @param newMultiplier - power of Pokemon
 * @param newPower - power of Pokemon
 */
public PokemonCardThomas(String newName, int newMultiplier, double newPower)
{
	myName = newName;
	myMultiplier = newMultiplier;
	myPower = newPower;
}//PokemonCard Full constructor 
/**
 * Getter method to retrieve the name of the Pokemon Card.
 * @return the name of the Pokemon
 */
public String getName()
{	return myName;	}//getter method name
/**
 * setter method to set the name of Pokemon Card
 * @param newName
 */
public void setName(String newName)
{	myName = newName;	}//setter method name.
/**
 * getter method for multiplier
 * @return the multiplier for the Pokemon card.
 */
public int getMultiplier()
{	return myMultiplier;	}//getter method multiplier
/**
 * setter method multiplier sets the multiplier for the Pokemon card
 * @param newMultiplier
 */
public void setMultiplier(int newMultiplier)
{	myMultiplier = newMultiplier;	}//setter method multiplier
/**
 * getter method to retieve power of the Pokemon card.
 * @return the power of the Pokemoncard
*/
public double getPower()
{	return myPower;		}//getter method power
/**
 * Setter method to set the power of Pokemon Card.
 */
public void setPower(double newPower)
{	myPower = newPower;		}//setter method power
}//PokemonCardThomas
