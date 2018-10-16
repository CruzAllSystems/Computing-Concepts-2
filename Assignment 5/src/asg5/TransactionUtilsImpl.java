package asg5;
import java.io.*;

import java.text.*;
import java.util.*;
import asg5.Transaction;
import asg5.AccountCharge;
import asg5.AccountCredit;
import asg5.CreditCode;

public class TransactionUtilsImpl 
{
	//pre: out is open and ready to write to
	//post: out contains current transaction  in program readable format (Check or Debit)
		public static void writeToFile(PrintWriter out, Transaction transaction)
		{
			if(transaction instanceof AccountCredit)
			{
				AccountCredit act = (AccountCredit) transaction;
				out.println("CREDIT " + act.getDateString() + " " + act.getTransactionId() + " " + act.getAmount() + " " + act.getCreditCode() + " " + act.getCreditor());
				
			}
			if(transaction instanceof AccountCharge)
			{
				AccountCharge act = (AccountCharge) transaction;
				out.println("CHARGE " + act.getDateString() + " " + act.getTransactionId() + " " + act.getAmount() + " " + act.getPayee());
				
			}
			
		}//end of the writeToFile method
		
		//pre: in is open and ready to read data from in program readable format as expected for Transaction data
		//post: a transaction(either an AccountCharge or an AccountCredit instance)
	    //is populated with data from file and returned if populated properly, if not returns null.
		public static Transaction readFromScanner(Scanner in)
		{
		    String acctype = "";
		    String dte = "";
		    String transId = "";
		    double amnt = 0.0;
		    String pay = "";
		    String code = "";
		    String credita = "";
		    
		    if(in.hasNext())
		    {
		    	acctype = in.next();
		    	
		    	if(!(acctype.equals("CREDIT") || acctype.equals("CHARGE")))
		    		return null;
		    	
		    	if(in.hasNext())
		    		dte = in.next();
		    	
		    	if(in.hasNext())
		    		transId = in.next();
		    	
		    	if(in.hasNextDouble())
		    		amnt = in.nextDouble();
		    
		    	
		    	if(acctype.equals("CREDIT"))
		    	{
		    		code = in.next();
		    		credita = in.nextLine();
		    		
		    		CreditCode coded = toCreditCode(code);
		    		
		    		AccountCredit value = new AccountCredit(dte,amnt,transId,credita,coded);
		    		
		    		return value;
		    		
		    	}//end of the CREDIT if
		    	if(acctype.equals("CHARGE"))
		    	{
		    		pay = in.nextLine();
		    		
		    		AccountCharge value = new AccountCharge(dte,amnt,transId,pay);
		    		
		    		return value;
		    		
		    	}//end of the CHARGE if
		    	
		    	
		    }//end of the algorithim if
		    
		    return null;
		    	   
		    	   
		}//end of the readFromScanner method
		
		//pre: none
		//post: Converts the given string value into the correct corresponding CreditCode value and returns it.
		private static CreditCode toCreditCode(String code)
		{
			CreditCode temp = CreditCode.OTHER;
			
			if(code.equals("RET"))
				temp = CreditCode.RET;
			if(code.equals("ERR"))
				temp = CreditCode.ERR;
			
			return temp;
			
		}//end of the toCreditCode method


}
