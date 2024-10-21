/**
 * his class includes the getter and setters that allow you to assign and retrieve the Pokemon's
 * name, multiplier and power.
 */
public class PokemonThomas 
{
/**
* private String myName - Pokemon's name
* private int myMultiplier - multiplier for the Pokemon
* private double myPower - power for the Pokemon
*/
	private String myName;
	private int myMultiplier;
	private double myPower;
/**
* Constructor for a new Pokemon object including its name, multiplier, and power.
* @param newName new name assigned to the Pokemon
* @param newMultiplier new multiplier assigned to the Pokemon
* @param newPower new power assigned to the Pokemon
*/
	public PokemonThomas(String newName, int newMultiplier, double newPower)
	{
		myName = newName;
		myMultiplier = newMultiplier;
		myPower = newPower;
	}//PokemonThomas
/**
* Getter for the Pokemon's name
* @return name of the Pokemon
*/
	public String getName()
	{	return myName;	}//getter name
/**
* Setter for the Pokemon's name
* @param newName name of the new Pokemon
*/
	public void setName(String newName)
	{	myName = newName;	}//setter name
/**
* Getter for the multiplier for the Pokemon
* @return multiplier for the Pokemon
*/
	public int getMulitplier()
	{	return myMultiplier;	}//getter multiplier
/**
* Setter for the multiplier for the Pokemon
* @param newMultiplier the new multiplier for the Pokemon
*/
	public void setMultiplier(int newMultiplier)
	{	myMultiplier = newMultiplier;	}//setter multiplier
/**
* getter for the power of the Pokemon
* @return power of the Pokemon
*/
	public double getPower()
	{	return myPower;	}//getter power
/**
* Setter for the power of the Pokemon
* @param newPower new power for the Pokemon
*/
	public void setPower(double newPower)
	{ myPower = newPower;	}//setter multiplier
/**
* Prints out a 3 neatly formatted lines showing Pokemon's name, multiplier and power.
* @return ans - 3 neatly formatted lines
*/   
	public String toString()
	{
		String ans = "Pokemon name: " + myName + "\n";
		ans += "Multiplier: " + myMultiplier + "\n";
		ans += "Power: " + myPower;
		return ans;
	}//toString method
}//PokemonThomas
