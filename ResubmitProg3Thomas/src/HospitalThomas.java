/**
* @author Owen Thomas <br>
* 
* Prog 3 Resubmission <br>
* Due Date  and Time: 4/29/24 before 9:00 AM <br>
* 
* Purpose: This program calculates a patient's hospital bill based on Patient's
* income, insurance company and length of stay.<br>
* 
* Input: The Patient is asked to enter their Patient ID Number, Household income,
* Insurance company (or none), anf their length of stay in the hospital. <br>
* 
* Output: Patient ID Number, Household Income, Insurance Plan, time spent in hospital,
* Admittance Fee, Per Diem Rate, Service Fee, Total Discount, Bill Total and a thank you message.<br>
* Certification of Authenticity: <br> 
* I certify that this lab is entirely my own work. <br>
* 
* SUMMARY OF CHANGES: 
* I insured that all variables were declared and initialized at the top of main method. 
* I utilized while loops so that I would not have to patch my code.
* I reduced unnecessary code and conditional statements.
* I ensured all of my closed braces were documented.
* I believe the organization of the code improved.

* This class calculates your hospital bill
*/

import java.util.*;

public class HospitalThomas 
{
	static Scanner keyboard = new Scanner(System.in);
	/**
	 * Main method used to calculate hospital bill.
	 * @param args standard
	 */
	public static void main (String[] args)
	{
		int totalNumPatientsProcessed = 0;
		double highestBillPaid = 0.00;
		int patientIDWithHighestBill = 0;
		double totalBillsSum = 0.00;
		double householdIncome = 0.00;
		char insurancePlan = '?';
		double perDiemRate = 0.00;
		boolean validInsurance = false;
		int numberOfDays = 0;
		double discount = 0.00;
		double totalBill = 0.00;
		double averageBill = 0.00;
		int patientID = 0;
		
		System.out.println("Welcome to the Hospital Insurance Processing Payment System.");
		System.out.println("Enter your Patient ID here (or 0 to quit): ");
		
		patientID = keyboard.nextInt();
		
		while (patientID != 0)
		{
			totalNumPatientsProcessed++; //counter for number of Patients
			
			validInsurance = false;//set to false to start until valid insurance input is given.
			householdIncome = -1;//set to an invalid number begin
			
			while (householdIncome < 0)
			{
				System.out.println("Enter your Holdhold Income here: ");
				householdIncome = keyboard.nextDouble();
				if (householdIncome < 0)
				{
					System.out.println("Alert: You cannot enter a negative value for Household Income. Please try again!");
				}//if
			}//while
/**
 * validation loop to check insurance option
 */	
			while (!validInsurance)
			{
				System.out.println("(Note: 'R' = Red Cross, 'M' = Med-Hudson, 'A' = ACA, 'N' = No Insurance)");
				System.out.println("Enter your Insurance Plan here: ");
				insurancePlan = keyboard.next().charAt(0);
/**
 * Switch statement to calculate per diem rate based off of Household income.	
 */
				switch(insurancePlan)
				{
				case 'R':
				case 'r':
					if (householdIncome < 15000)
					{
						perDiemRate = 50.00;
					}//if
					else if (householdIncome <= 37500)
					{
						perDiemRate = 70.00;
					}//else-if
					else
					{
						perDiemRate = 150.00;
					}//else
					validInsurance = true;
					break;
				case 'M':
				case 'm':
					if (householdIncome < 20000)
					{
						perDiemRate = 40.00;
					}//if
					else if (householdIncome <= 45000)
					{
						perDiemRate = 75.00;
					}//else-if
					else
					{
						perDiemRate = 110.00;
					}//else
					validInsurance = true;
					break;
				case 'A':
				case 'a':
					if (householdIncome < 12500)
					{
						perDiemRate = 60.00;
					}//if
					else if (householdIncome <= 53000)
					{
						perDiemRate = 75.00;
					}//else-if
					else
					{
						perDiemRate = 140.00;
					}//else
					validInsurance = true;
					break;
				case 'N':
				case 'n':
					perDiemRate = 350.00;
					validInsurance = true;
					break;
				default:
					System.out.println("ALERT: The Insurance you entered is invalid. Please try again!");
					break;
				}//switch
			}//while
			
			numberOfDays = 0;
	/**
	 * validation loop for number of days spent in hospital.	
	 */
			while (numberOfDays <= 0 || numberOfDays > 365)
			{
				System.out.println("Enter the length of stay here (1-365 days): ");
				numberOfDays = keyboard.nextInt();
				if (numberOfDays <= 0 || numberOfDays > 365)
				{
					System.out.println("Length of stay must be between 1 and 365 days. Please try again!");
				}//if
			}//while
			
			if (numberOfDays > 23)
			{
				discount = ((numberOfDays / 7) * 250.00);
			}//if
			
			totalBill = (300.00 + (perDiemRate * numberOfDays) - discount);
			if (totalBill > highestBillPaid)
			{
				highestBillPaid = totalBill;
				patientIDWithHighestBill = patientID;
			}//if
			
			totalBillsSum += totalBill;
			
			System.out.println("Patient's ID Number: " + patientID);
			System.out.printf("Patient's Household Income $%.2f\n", householdIncome);
			System.out.println("Patient's Insurance Plan " + insurancePlan);
			System.out.println("Number of Days Patient Spent in Hospital: " + numberOfDays);
			System.out.printf("Admittance Fee: $300.00\n");
			System.out.printf("Per Diem Rate: $%.2f\n", perDiemRate);
			System.out.printf("Service Fee: $%.2f\n", perDiemRate * numberOfDays);
			System.out.printf("Total Discount: $%.2f\n", discount);
			System.out.printf("Bill Total: $%.2f\n", totalBill);
			System.out.println("Thank you for using our Health Insurance Bill Calculating Program...Good-Bye!");
			
			System.out.println("Enter your Patient ID here (or a 0 to quit): ");
			patientID = keyboard.nextInt();
		}//while
/**
 * used for summary of the Patients that were processed.		
 */
		if (totalNumPatientsProcessed > 0)
		{
			averageBill = (totalBillsSum / totalNumPatientsProcessed);
			System.out.println("Total number of patients processed: " + totalNumPatientsProcessed);
			System.out.printf("Highest bill paid: $%.2f\n", highestBillPaid);
			System.out.println("Patient ID with the highest bill: " + patientIDWithHighestBill);
			System.out.printf("Total amount of bills processed: $%.2f\n", totalBillsSum);
			System.out.printf("Average bill amount: $%.2f\n", averageBill);
		}//if
		else
		{
			System.out.println("No patients were processed");
		}//else
	}//main
}//HospitalThomas
