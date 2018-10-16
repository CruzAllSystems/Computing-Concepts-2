package asg4;
import java.io.*;
import java.util.*;

public class CreditCardAccountListUtilsImpl 
{
	//pre: out is open and ready to write to
	//post: out contains current credit card account list’s data (if any) in program readable format
	public static void writeToFile(PrintWriter outfile, CreditCardAccountList creditcardaccountlist)
	{
		for(int index = 0; index < creditcardaccountlist.getSize(); index++)
			CreditCardAccountUtilsImpl.writeToFile(outfile, creditcardaccountlist.get(index));
		
		
	}//end of the write to file method
	
	//pre: in is open and ready to read data from in program readable format as expected for CreditCardAccount data
	//post: creditcardaccountlist is populated with data from file, adds to the current data already in the creditcardaccountlist if any
	public static void readFromScanner(Scanner infile, CreditCardAccountList creditcardaccountList)
	{
		boolean result = true;
		CreditCardAccount act1 = new CreditCardAccount();
		
		result = CreditCardAccountUtilsImpl.readFromScanner(infile, act1);
		
		while(result == true)
		{
			creditcardaccountList.add(act1);
			act1 = new CreditCardAccount();
			
			result = CreditCardAccountUtilsImpl.readFromScanner(infile, act1);
			
		}//end of while
		
	}//end of the readFromScanner method
	

}//end of the CreditCardAccountListUtilsImpl
