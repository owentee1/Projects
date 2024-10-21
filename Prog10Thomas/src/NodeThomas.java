/**
* This class is for a node in a linked list. The constructor creates a new node
* with a Pokemon object with data(name, power multiplier). It also give you a reference
* to the next node in the linked list.
*/
public class NodeThomas 
{
/**
* myData - stores a Pokemon object.
* myNext - a reference for the next node in the linked list
*/
	private PokemonThomas myData;
	private NodeThomas myNext;
/**
* null constructor
* myData
* MyNext
*/
	public NodeThomas()
	{
		myData = null;
		myNext = null;
	}//Node
/**
* Full Constructor for new node
* @param newData -Pokemon data used/stored in node.
* @param newNext - the reference to the following node in linked list.
*/
	public NodeThomas(PokemonThomas newData, NodeThomas newNext)
	{
		myData = newData;
		myNext = newNext;
	}//Node
/**
* getter method for getting the Pokemon object stored in the node.
* @return myData - the Pokemon object stored in the node.
*/
	public PokemonThomas getData()
	{	return myData;	}//getter method myData
/** setter method for setting the Pokemon object to be stored in the node.
* 
* @param newData - the Pokemon object to be stored in the node.
*/
	public void setData(PokemonThomas newData)
	{	myData = newData;	}//setter method newData
/**
* getter method for getting the reference for the next node in the linked list.
* @return myNext - the next node in the list.
*/
	public NodeThomas getNext()
	{	return myNext;	}//getter method myNext
/**
* setter method for setting the reference for the next node in the linked list.
* @param newNext - reference to next node in the list.
*/
	public void setNext(NodeThomas newNext)
	{	myNext = newNext;	}//setter method newNext
}//NodeThomas
