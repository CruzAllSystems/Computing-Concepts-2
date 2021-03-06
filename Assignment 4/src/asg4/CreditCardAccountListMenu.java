package asg4;
import java.util.*;
import java.io.*;

public class CreditCardAccountListMenu 
{
	public static void main(String[] args)//main method
	{
		CreditCardAccountList list1 = new CreditCardAccountListImpl();
		char choice = '$';
		
		do
		{
			showMenu();
			choice = getUserSelection();
			
			switch(choice)
			{
				case 1: showListAndSize(list1);
				break;
				
				case 2: addUserInputAccount(list1);
				break;
				
				case 3: removeAccount(list1);
				break;
				
				case 4: showLastNameAccounts(list1);
				break;
				
				case 5: displayAccountByNumber(list1);
				break;
				
				case 6: saveAccountList(list1);
				break;
				
				case 7: restoreAccountList(list1);
				break;
				
				case 8: System.out.println("Now exiting prgram...");
				break;
				
				default: System.out.println("Error, invalid decision.");
				break;
			
			
			
			}//end of the switch cases
			
			
		}while(choice != 8); //end of the progression do while
		
		
	}//end of the main method
	
	//pre: none
	//post: Outputs the implementation method to the user.
	public static void showMenu()
	{
		System.out.println("1. show size of current list and all credit card accounts in the current list.\n" +
							"2. add a user input credit card account to the list\n" +
							"3. remove a user specified credit card account (account number only input from user) from the list.\n" +
							"4. show all credit card accounts with a user input last name\n" +
							"5. find and display a credit card account with a given account number\n" +
							"6. save current credit card account list to a user specifed file path.\n" +
							"7. restore credit card account list from a user specified file path.\n" +
							"8. quit\n");
		
		
	}//end of the showMenu method
	
	//pre: none
	//post: Asks the user to input a char that is then returned and used to navigate the menu
	public static char getUserSelection()
	{
		System.out.println("Enter your menu selection:");
		Scanner input = new Scanner(System.in);
		char value = (char) input.nextInt();
		return value;
		
		
	}//end of the get user selection method
	
	//pre: none
	//post: Outputs the size of the given credit card account list and then outputs it using that instance's toString method. 
	public static void showListAndSize(CreditCardAccountList list)
	{
		System.out.println("Current size of this credit card account list: " + list.getSize());
		
		
		System.out.println("Current list:\n" + list + "\n");
		
		
		
	}//end of the showListAndSize method
	
	//remaining methods are stubs for the moment
	
	public static void addUserInputAccount(CreditCardAccountList list)
	{
		
		System.out.println("Option 2: Add a user input credit card account to the list.\n");
		
		
	}//end of the addUserInputAccount method
	
	public static void removeAccount(CreditCardAccountList list)
	{
		System.out.println("Option 3: Remove a credit card account from the list.\n");
		
		
		
	}//end of the removeAccount method
	
	public static void showLastNameAccounts(CreditCardAccountList list)
	{
		System.out.println("Option 4: Show credit card accounts with a specific last name on the list.\n");
		
		
		
	}//end of the showLastNameAccounts method
	
	public static void displayAccountByNumber(CreditCardAccountList list)
	{
		System.out.println("Option 5: Display credit card accounts with a specific account number from the list.\n");
		
		
		
	}//end of the displayAccountByNumber method
	
	public static void saveAccountList(CreditCardAccountList list)
	{
		
		System.out.println("Option 6: Save the credit card account list to a file.\n");
		
		
	}//end of the saveAccount method
	
	public static void restoreAccountList(CreditCardAccountList list)
	{
		System.out.println("Option 7: Restore a credit card account list from a file.\n");
		
		
		
	}//end of the restoreAccount method
	

}//end of the public CreditCardAccountListMenu class
