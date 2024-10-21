public class StepsThomas
{
	private int myStepWidth;
	private int myNumberOfSteps;
	private char myFillStyle;
	
	public StepsThomas()
	{
		myStepWidth = 2;
		myNumberOfSteps = 5;
		myFillStyle = '*';
	}//steps
	
	public StepsThomas(int newStepWidth, int newNumberOfSteps, char newFillStyle)
	{
		myStepWidth = newStepWidth;
		myNumberOfSteps = newNumberOfSteps;
		myFillStyle = newFillStyle;
	}//steps
	
	public int getStepWidth()
	{	return myStepWidth;			}//get width
	
	public void setStepWidth(int stepWidth)
	{	myStepWidth = stepWidth;	}//set width
	
	public int getNumberOfSteps()
	{	return myNumberOfSteps;		}//get numberOfSteps
	
	public void setNumberOfSteps(int numberOfSteps)
	{	myNumberOfSteps = numberOfSteps;	}//set numberOfSteps
	public char getFillStyle()
	{	return myFillStyle;		}// get fillStyle
	
	public void setFillStyle(char fillStyle)
	{	myFillStyle = fillStyle;	}//set fillStyle
	
	public int calcArea()
	{
		int totalFillCharacters = 0;
		for (int i = 1; i <= myNumberOfSteps; i++)
		{
			totalFillCharacters += myStepWidth * i;
		}//for
		return totalFillCharacters;
	}//calcArea method
	 //initializes totalFillCharacters to 0
	 //Iterates through each step of the staircase and adds it to the count
	 //multiplies step width by  step # and adds it to totalFillCharacters sum
	public void drawSteps()
	{
		for (int step = 1; step <= myNumberOfSteps; step++)
			{
				for (int i = 0; i < myStepWidth * step; i++)
				{
					System.out.print(myFillStyle);
				}//for inner
				System.out.println();
			}//for outer
	}//drawSteps Method
	 //Each step is drawn by printing a row of characters using the width
	 //Step width is multiplied by step # (step number is incremented) to acquire number of fill characters
	 //It then uses the s.o.pl() to jump down to next step and continues

	public String toString()
	{
	String ans = "Your step width is: " + myStepWidth +  " characters long" + "\n";
	ans += "Number of Steps on your staircase: " + myNumberOfSteps + "\n";
	ans += "Fill Style you chose for your staircase: " + myFillStyle + "\n";
	ans += "Number of Fill Characters used to build your staircase: " + calcArea();
	return ans;
	}//toString method  prints out the user's step width, Number of steps, Fill Style, and number of characters used 
}//StepsThomas
