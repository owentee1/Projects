import java.util.*;
import java.io.*;
/**
 * This class simulates a card game between 2 players  where each player deals a card and the
 * power (or multiplier) of the card is compared between the other. Whoever wins that hand 
 * (if there is not a tie) collects both cards. The game ends when one of the players collects
 * all of the cards that are in play or the game surpasses 1000 plays.
 */
public class BattleDemoThomas 
{
/**
* Keyboard used to input file containing the master Pokemon deck to be dealt.
*/
static Scanner keyboard = new Scanner(System.in);
/**
 * Play stack for player 1
 */
static StackThomas player1PlayStack = new StackThomas();
/**
 * Player stack for player 2
 */
static StackThomas player2PlayStack = new StackThomas();
/**
 * Discard stack for player 1
 */
static StackThomas player1DiscardStack = new StackThomas();
/**
 * Discard stack for player 2
 */
static StackThomas player2DiscardStack = new StackThomas();
/**
 * Counter for the number if plays that take place during a game.
 */
static int playCount = 0;
/**
 * Main orchestrates the simulation battle between player 1 and player 2.
 * @param args standard
 */
public static void main(String[] args)
{
	System.out.print("Enter the input file to load your Pokemon Master Deck: ");
	String fileName = keyboard.next();
	File inputFile = new File(fileName);
	
	String name = "None";
	int multiplier = 0;
	double power = 0.00;
	int numberOfCards = 0;
	int totalNumOfCards = 0;
	int player1TotalCards = 0;
	int player2TotalCards = 0;
	StackThomas tempStack = new StackThomas();
	PokemonCardThomas newCard = new PokemonCardThomas(name, multiplier, power);
	PokemonCardThomas player1Card = null;
	PokemonCardThomas player2Card = null;
	try
	{
		Scanner input = new Scanner(inputFile);
		numberOfCards = input.nextInt();
		
		int i = 0;
		for (i = 0; i < numberOfCards; i++)
		{
			name = input.next();
			multiplier = input.nextInt();
			power = input.nextDouble();
			newCard = new PokemonCardThomas(name, multiplier, power);
			if (i % 2 == 0)
			{
				player1PlayStack.push(newCard);
			}//if
			else
			{
				player2PlayStack.push(newCard);
			}//else
		}//for
		input.close();
		System.out.println("Your Master Deck was dealt successfully! Let's have a fair fight!");
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
	
	while (playCount < 1000 && (!player1PlayStack.isEmpty() || !player1DiscardStack.isEmpty()) && (!player2PlayStack.isEmpty() || !player2DiscardStack.isEmpty()))
		{
			play();
		}//while
		printResults();
}//main
/**
 * This method simulates a play in a game.
 * Each player presents a card and it is compared.
 */
private static void play()
{
	if (player1PlayStack.isEmpty() && !player1DiscardStack.isEmpty())
	{
		moveCards(player1DiscardStack, player1PlayStack);
	}//if
	if(player2PlayStack.isEmpty() && !player2DiscardStack.isEmpty())
	{
		moveCards(player2DiscardStack, player2PlayStack);
	}//if
	if(!player1PlayStack.isEmpty() && !player2PlayStack.isEmpty())
	{
		PokemonCardThomas player1Card = null;
		PokemonCardThomas player2Card = null;
		player1Card = player1PlayStack.pop();
		player2Card = player2PlayStack.pop();
		compare(player1Card, player2Card);
		playCount++;
	}//if
}//play method
/**
 * This method compares the power of the two Pokemon cards and determines the winner.
 * If there is a tie amongst the power it then compares multiplier if this does not
 * determine a winner it is a tie and each players card is moved to their discard pile.
 */
private static void compare(PokemonCardThomas card1, PokemonCardThomas card2)
{
	if (card1.getPower() > card2.getPower())
	{
		winPlay(player1DiscardStack, card1, card2);
	}//if
	else if (card1.getPower() < card2.getPower())
	{
		winPlay(player2DiscardStack, card2, card1);
	}//else-if
	else
	{
		if (card1.getMultiplier() > card2.getMultiplier())
		{
			winPlay(player1DiscardStack, card1, card2);
		}//if
		else if (card1.getMultiplier() < card2.getMultiplier())
		{
			winPlay(player2DiscardStack, card2, card1);
		}//else-if
		else
		{
			player1DiscardStack.push(card1);
			player2DiscardStack.push(card2);
		}//else
	}//else
}//compare method
/**
 * This method handles when a player wins a battle between 2 cards and collects both cards
 * @param player1DiscardStack2 - the discard pile for the winning player.
 * @param winningCard - the winning Pokemon Card.
 * @param losingCard - the losting Poklemon Card.
 */
private static void winPlay(StackThomas player1DiscardStack2, PokemonCardThomas winningCard, PokemonCardThomas losingCard)
{
	player1DiscardStack2.push(winningCard);
	player1DiscardStack2.push(losingCard);
}//winPlay method
/**
 * This method moves cards from discard to play. Helps preserve order.
 *@param player1DiscardStack2 - the discard pile that card are moved from.
 *@param player1PlayStack2 - the play pile where cards are moved.
 */
 private static void moveCards(StackThomas discard, StackThomas play)
 {
	 StackThomas tempStack = new StackThomas();
	 PokemonCardThomas card = null;
	 
	 while (!discard.isEmpty())
	 {
		 card = discard.pop();
		 tempStack.push(card);
	 }//while
	 while (!tempStack.isEmpty())
	 {
		 card = tempStack.pop();
		 play.push(card);
	 }//while
 }//moveCards
 /**
  * This method prints out the Battle Summary.
  */
 public static void printResults()
 {
	 int totalNumOfCards = 0;
	 int player1TotalCards = 0;
	 int player2TotalCards = 0;
	 
	 totalNumOfCards = player1PlayStack.getSize() + player1DiscardStack.getSize() + player2PlayStack.getSize() + player2DiscardStack.getSize();
	 System.out.println("Battle Card Game Summary");
	 System.out.println();
	 System.out.println("The game started with " + totalNumOfCards + " cards.");
	 System.out.println("There were " + playCount + " plays in the game.");
	 
	 if(player1PlayStack.isEmpty() && player1DiscardStack.isEmpty() && !player2PlayStack.isEmpty() && !player2DiscardStack.isEmpty())
	 {
		 System.out.println("The game ended with a clear winner.");
		 System.out.println("Player 1 ended with 0 cards");
		 System.out.println("Player 2 ended up with " + (player2PlayStack.getSize() + player2DiscardStack.getSize()) + " cards.");
		 System.out.println("The winner is Player 2");
	 }//if
	 else if (player2PlayStack.isEmpty() && player2DiscardStack.isEmpty() && !player1PlayStack.isEmpty() && !player1DiscardStack.isEmpty())
	 {
		 System.out.println("The game ended with a clear winner");
		 System.out.println("Player 1 ended with " + (player1PlayStack.getSize() + player1DiscardStack.getSize()) + " cards.");
		 System.out.println("Player 2 ended up with 0 cards");
		 System.out.println("The winner was Player 1.");
	 }//else-if
	 else
	 {
		 player1TotalCards = player1PlayStack.getSize() + player1DiscardStack.getSize();
		 player2TotalCards = player2PlayStack.getSize() + player2DiscardStack.getSize();
		 
		 if(player1TotalCards > player2TotalCards)
		 {
			 System.out.println("Player 1 is the winner!");
		 }//if
		 else if (player1TotalCards < player2TotalCards)
		 {
			 System.out.println("Player 2 is the winner!");
		 }//else-if
		 else
		 {
			 System.out.println("It's a tie!");
			 System.out.println("The tie ended with Player 1 having " + player1TotalCards + " and Player 2 "
			 		+ "ended with " + player2TotalCards + " .");
		 }//else
	  }//else
	 }//printResults method 
}//BattleDemoThomas
