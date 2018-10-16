package asg4;
import java.util.*;
import java.io.*;

public class CreditCardAccountUtilsImpl 
{
	//pre: in is open and ready to read data from
 	//account number {newline}, last name {newline}, first name {newline}, balance {newline}
 	
 	//post: theAccount is populated with data from in if all data is there, 
	//returns true if no data found for account number otherwise if 
 	//any mismatch of data or missing expected data, returns false
 	
	public static boolean readFromScanner(Scanner in, CreditCardAccount theAccount)
	{
		int actnum;
		String lName;
		String fName;
		double bal;
		
		if(in.hasNextInt())
		{
			actnum = in.nextInt();
			in.nextLine();
			
		}//end of the account reader if
		else
			return false;
		
		if(in.hasNext())
			lName = in.nextLine();
		else
			return false;
		
		if(in.hasNext())
			fName = in.nextLine();
		else
			return false;
		
		if(in.hasNextDouble())
		{
			bal = in.nextDouble();
			in.nextLine();
			
		}//end of the blance reader if
		else
			return false;
		
		theAccount.setAccountNumber(actnum);
		theAccount.setLastName(lName);
		theAccount.setFirstName(fName);
		theAccount.setBalance(bal);
		
		return true;
		
		
	}//end of the read from scanner method
	
	//pre: out is open and ready to receive output
 	//post: theAccount is output to out in program readable format (so that it could be read back in later)
	public static void writeToFile(PrintWriter out, CreditCardAccount theAccount)
	{
		out.println(theAccount.getAccountNumber());
		out.println(theAccount.getLastName());
		out.println(theAccount.getFirstName());
		out.println(theAccount.getBalance());
		
		
	}//end of the write to file method
	

}//end of the CreditCardAccountUtilsImpl class
