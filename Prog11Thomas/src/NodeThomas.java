public class NodeThomas 
{
private PokemonCardThomas myData;
private NodeThomas myNext;

/**
 * Default constructor to create node with no data and no next.
 */
public NodeThomas()
{
	myData = null;
	myNext = null;
}//NodeThomas
/**
 * Constructor initialized with the data and reference
 * @param newData - The PokemonCard data is stored into the node.
 * @param newnext - The next Node in the linked list (referencing)
 */
public NodeThomas(PokemonCardThomas newData, NodeThomas newNext)
{
	myData = newData;
	myNext = newNext;
}//NodeThomas
/**
 * getter method data returns PokemonCard stored in the node.
 * @return myData.
 */
public PokemonCardThomas getData()
{	return myData;	}//getter method data
/**
 * Setter method for the PokemonCard to store in node.
 * @param newData
 */
public void setData(PokemonCardThomas newData)
{	myData = newData;	}//setter method data
/**
 * Returns or gets the next node in the stack
 * @return myNext
 */
public NodeThomas getNext()
{	return myNext;	}//getter next node.
/**
 * Sets the reference for the next node
 * @param newNext
 */
public void setNext(NodeThomas newNext)
{	myNext = newNext;	}//setter method next node
}//NodeThomas
