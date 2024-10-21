// Owen Thomas
// Prog 5
// Due Date and Time: 02/22/24 before 9:00 a.m.
//
// Purpose: This program will allow user to to enter 10 grades and receive the highest, lowest and average 
//          of that set up grades using the 'Handle Grades' option.
//          It will allow the user to grade a 12 question assignment by entering the students answers, 
//          followed by entering the answer key. This is achieved using the 'Grade Quiz' option
//          It allows user to enter up to 10 grades to acquire the lowest grade and how many times that 
//          lowest grade appeared. This is achieved using the 'How Many Mins?' option.
// Input:   Handle Grades: Enter 10 grades
//          Grade Quiz: Enter the student's answers followed by the answer key.
//          How Many Mins?: Enter up to 10 grades(non-negative integers)
// Output: Handle Grades: Highest grade, Lowest Grade, Average Grade
//         Grade Quiz: Student's grade as a percentage and letter grade, accompanied by simple feedback.
//         How Many Mins?: Grades that were entered into system, the minimum grade and how many times that minimum grade appeared.
// Certification of Authenticity:
// I certify that this lab is my own work, but I discussed it with: Dr.Schwartz.

import java.util.*;

public class ArraysThomas
{
	static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		int choice = 0;
		double[] studentGradesArray = new double[10];
		char[] studentAnswersArray = new char[12];
		char[] answerKeyArray = new char[12];
		int [] nonNegIntegerArray = new int[10];
		int count = 0;
		int min = 0;
		int minCount = 0;
		int num = 0;
		int correctAnswers = 0;
		double percentage = 0.00;
		double maxGrade = 0.00;
		double minGrade = 0.00;
		double averageGrade = 0.00;
		double average = 0.00;
		double sum = 0.00;
		
		do
		{
			System.out.println("Welcome to the 'Professor's Best Friend' Program. This program will make grading exams much more efficient!");
			System.out.println("Menu: ");
			System.out.println("1. Handle Grades");
			System.out.println("2. Grade Quiz");
			System.out.println("3. How Many Mins?");
			System.out.println("0. Quit");
			System.out.println("Enter your choice here");
			choice = keyboard.nextInt();
			
			switch (choice) 
			{
			case 1:
				handleGrades(studentGradesArray);
				break;
			case 2:
				gradeQuiz(studentAnswersArray, answerKeyArray);
				break;
			case 3:
				howManyMins(nonNegIntegerArray);
				break;
			case 0:
				System.out.println("Thanks for using our program, I hope you found it helpful");
				break;
			default:
				System.out.println("This choice does not exist. Please enter a valid key!");
			}//switch
		}while (choice != 0 || (choice < 1 || choice >3));//while continuous when choice is not 0 or 1,2,3
	}//main
	
	public static void handleGrades(double[] grades)
	{
		System.out.println("Enter 10 grades, one at a time please:");
		for (int i = 0; i < 10; i++)
		{
			double grade = keyboard.nextDouble();
			grades[i] = grade;
		}//for loop
		
		double maxGrade = findMaxGrade(grades);
		double minGrade = findMinGrade(grades);
		double averageGrade = findAverage(grades);
		
		System.out.printf("Highest Grade: %.2f%%\n", maxGrade);
		System.out.printf("Lowest Grade: %.2f%%\n", minGrade);
		System.out.printf("Average Grade: %.2f%%\n", averageGrade);
	}//handleGrades Method 
	 // handleGrades Method prompts user to enter up to 10 grades
	 // Those inputs are stored in an array called "grades"
	 // It then calls findMaxGrade, findMinGrade, findAverageGrade methods to make
	 // their appropriate calculations.
	
	public static double findMaxGrade(double[] studentGrades)
	{
		double max = studentGrades[0];
		for (int i = 1; i < studentGrades.length; i++)
		{
			if (studentGrades[i] > max)
			{
				max = studentGrades[i];
			}//if
		}//for loop
		return max;
	}//findMaxGrade Method
	 //Initializes double max to the first grade(index)
	 // Iterates through the "grades" array to compare each other grade to the first
	 // if current grade is greater than max, max is updated
	
	public static double findMinGrade(double[] studentGrades)
	{
		double min = studentGrades[0];
		for (int i = 1; i < studentGrades.length; i++)
		{
			if (studentGrades[i] < min)
			{
				min = studentGrades[i];
			}//if
		}//for
		return min;
	}//findMinGrade Method
	 //Initializes min to value of first grade
	 //Iterates through the remaining grades and if the current grade is less than min, min is updated
	
	public static double findAverage(double [] studentGrades)
	{
		double sum = 0.00;
		double average = 0.00;
		for (int i = 0; i < studentGrades.length; i++)
		{
			sum += studentGrades[i];
		}//for
		average = (sum / studentGrades.length);
		return average;
	}//findAverageMethod
	 //Initialized sum to zero, average to zero
	 //Iterates over grades array and adds each value to the sum
	 //Divides sum by how number of grades(grades.length)
	 // returns average
	
	public static void gradeQuiz(char[] studentAnswers, char[] answerKey)
	{
		int correctAnswers = 0;
		double percentage = 0.00;
		System.out.println("Enter student's answers (12 characters, one at a time please!):");
		for (int i = 0; i < 12; i++)
		{
			char answer = Character.toUpperCase(keyboard.next().charAt(0));
			studentAnswers[i] = answer;
		}//for
		System.out.println("Enter the answer key for the inputs you just gave (one at a time please):");
		for (int i = 0; i < 12; i++)
		{
			char answer = Character.toUpperCase(keyboard.next().charAt(0));
			answerKey[i] = answer;
		}//for
		
		correctAnswers = calculateCorrectAnswers(studentAnswers, answerKey);
		percentage = ((correctAnswers / 12.0) * 100);
		System.out.println("Student's Grade: " + percentage + "%");
		
		if (percentage >= 90)
		{
			System.out.println("Letter Grade: A...Great Job!");
		}//if
		else if (percentage >= 80)
		{
			System.out.println("Letter Grade: B...Good Job!");
		}//else if
		     else if (percentage >= 70)
		     {
		    	 System.out.println("Letter Grade: C...Okay");
		     }//else if
		          else if (percentage >= 60)
		          {
		        	  System.out.println("Letter Grade: D...Needs improvement");
		          }//else if
		               else
		               {
		            	   System.out.println("Letter Grade: F...Unsatisfactory");
		               }//else
	}//gradeQuiz Method
	 //Prompts user to enter the students answers, stores to studentArrays array
	 //Prompts user to enter the correct answers, stores to answerKey array
	 //It then compares by index each student answer to answer key
	 //(calls calulateCorrectAnswers Method) Calculates grade in percentage by dividing correct answers by total number of questions (12) and multiplys it by 100 to achieve a percentage
	 //it then uses conditionals to determine and print out their letter grade
	
	public static int calculateCorrectAnswers(char[] studentsAnswers, char[] answerKey)
	{
		int correctAnswers = 0;
		for (int i = 0; i < 12; i++)
		{
			if (studentsAnswers[i] == answerKey[i])
			{
				correctAnswers++;
			}//if
		}//for
		return correctAnswers;
	}//calculateCorrectAnswers Method //
	 //Method takes two parameters (studentAnswers, answerKey) iterates through each element and compares it
	 //When answer is correct it increments 'correctAnswers'
	 // returns total count of correct answers
	
	public static void howManyMins(int[] numbers)
	{
		System.out.println("Enter up to 10 non-negative integers, enter a negative number to stop(Enter one at a time please)");
		int count = 0;
		int num = keyboard.nextInt();
		
		if(num < 0)
		{
			System.out.println("No grades entered.");
			return;
		}//if checking to see that if first number entered is a negative
		while (num >= 0 && count < 10)
		{
			numbers[count] = num;
			count++;
			if (count < 10)
			{
				num = keyboard.nextInt();
			}//if
		}//while
		
		int min = findMinValue(numbers, count);
		int minCount = findMinCount(numbers, count, min);
		
		System.out.println("Here are the grades you entered: ");
		for (int i = 0; i < count; i++)
		{
			System.out.print(numbers[i] + ", ");
		}//for
		System.out.println();
		System.out.println("Minimum grade: " + min + "%");
		System.out.println("Number of times the minimum grade appeared: " + minCount);
	}//howManyMins Method
	 //Prompts user to enter non-negative integers quits after 10 or when a negative number number is inputed
	 //Stores the grades in the "numbers" array
	 //Calls findMinValue method Iterates through array and compares each element with current minimum value. Updates if a smaller value is encountered
	 //Calls findMinCount method Iterates through array and counts how many times the minimum value appears in the array
	
	public static int findMinValue(int[] numbers, int count)
	{
		int min = numbers[0];
		for (int i = 1; i < count; i++)
		{
			if (numbers[i] < min)
			{
				min = numbers[i];
			}//if
		}//for
		return min;
	}//findMinValue Method
	 //min in initialized to the value of the first element of the array.
	 //Iterates through the array comparing the elements to current min value.
	 //If it encounters a smaller number, min is updated.
	 // min now holds the smallest value and it is returned
	
	public static int findMinCount(int[] numbers, int count, int min)
	{
		int minCount = 0;
		for (int i = 0; i < count; i++)
		{
			if (numbers[i] == min)
			{
				minCount++;
			}//if
		}//for
		return minCount;
	}//findMinCountMethod
	 //minCount is initialized to zero.
	 //Iterates through the array and looks for "min" value
	 //every time min value is encountered it raises the count.
}//ArraysThomas
