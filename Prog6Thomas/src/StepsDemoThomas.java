// Owen Thomas
// Prog 6
// Due Date and Time: 02/29/24 before 9:00 a.m.
//
// Purpose: This program will build the user a staircase out of a character of their choice. 
//          The user will be able to enter width of the stair, number of steps, and the character building block of choice.
//          The user will be able to get the area of their staircase (the number of characters used)
//          The user will be able to receive a text description telling them the step width, number of steps and the fill style they chose.
        
// Input:   W - Step width
//          N - Number of steps
//          F - Fill style
//          
// Output: A - Your area (number of characters used to build your stiarcase
//         T - (toString)- Your step width, number of steps in staircase, the fill style you chose and number of characters
//         it took in building your staircase.
// Certification of Authenticity:
// I certify that this lab is my own work, but I discussed it with: Dr.Schwartz.

import java.util.*;

public class StepsDemoThomas 
{
static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) 
	{
		char choice;
		int widthOfStairs = 0;
		int numOfStairs = 0;
		char fillChar = ' ';
		
		StepsThomas steps = new StepsThomas(2, 5, '*');
		
		
		System.out.println("Welcome to the StairzMaster program! We can build a staircase out of any character you'd like!");
		
		do
		{
			System.out.println("W: Assign the step width");
			System.out.println("N: Assign the number of steps");
			System.out.println("F: Assign the fill style");
			System.out.println("A: Calculate the area");
			System.out.println("T: Text Description of the Steps");
			System.out.println("D: Draw the Steps");
			System.out.println("Q: Quit");
			System.out.println("Enter your choice here: ");
			choice = keyboard.next().toUpperCase().charAt(0);
			
			switch (choice)
			{
			case 'W':
				int width;
				do
				{
					System.out.println("Enter the step width you desire for your staircase(greater than 0)");
					width = keyboard.nextInt();
					if (width <=0)
					{
						System.out.println("Width must be greater than 0!");
					}//if validates width of step to a positive integer
				}while (width <= 0); //Continuous until valid width is provided
				steps.setStepWidth(width);
				break;
			case 'N':
				int numberOfSteps;
				do
				{
					System.out.println("Enter the number of steps you'd like your staircase to have(greater than 0): ");
					numberOfSteps = keyboard.nextInt();
					if (numberOfSteps <= 0)
					{
						System.out.println("Number of steps must be greater than 0. Please try again");
					}//if validates number of steps to a positive integer		
				}while(numberOfSteps <= 0);//Continuous loops until a valid menu option is selected
				steps.setNumberOfSteps(numberOfSteps);
				break;
			case 'F':
				System.out.println("Enter the Fill Style(character you'd like us to build your staircase out of): ");
				String fillStyleString = keyboard.next();
				char fillStyle = fillStyleString.charAt(0);
				steps.setFillStyle(fillStyle);
				break;
			case 'A':
				int numberOfFillCharacters = steps.calcArea();
				System.out.println("Number of Fill Characters Used: " + numberOfFillCharacters);
				break;
			case 'T':
				System.out.println(steps.toString());
				break;
			case 'D':
				steps.drawSteps();
				break;
			case 'Q':
				System.out.println("Quiting Program. Please use our program again!");
				break;
			default:
				System.out.println("You've selected an invalid choice. Please try again");
			}//switch
		}while (choice != 'Q'); //do-while continues to allow you to update until quit
	}//main
}//StepsDemoThomas
