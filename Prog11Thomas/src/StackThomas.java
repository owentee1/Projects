/**
 * This class shows a stack structure with a linked list implementation
 */
public class StackThomas 
{
/**
 * reference for the top node in stack
 */
	private NodeThomas myTop;
/**
 * Size of stack
 */
	private int mySize;
/**
 * Constructor for an empty stack.
 */
	public StackThomas()
	{
		myTop = null;
		mySize = 0;
	}//StackThomas
/**
 * checks to see if stack is empty. 
 * @return true if stack is empty else false.
 */
	public boolean isEmpty()
	{	return myTop == null;	}//isEmpty method
/**
 * checks if stack is full
 * @return true if the stack is full which it should never return true.
 */
	public boolean isFull()
	{	return false;	}//full method
/**
 * Pushes new Pokemon card on to top of a stack
 * @param newData the card being pushed onto stack.
 */
	public void push(PokemonCardThomas newData)
	{
		if (!isFull())
		{
			NodeThomas newNode = new NodeThomas(newData, myTop);
			myTop = newNode;
			mySize++;
		}//if
	}//push method
/**
 * Pops the Pokemon card from the stack
 * @return The popped Pokemon Card.
 */
	public PokemonCardThomas pop()
	{
		PokemonCardThomas data = null;
		if (!isEmpty())
		{
			data = myTop.getData();
			myTop = myTop.getNext();
			mySize--;
		}//if
		return data;
	}//pop method

	public int getSize()
	{
		return mySize;
	}//getSize method
}//StackThomas
