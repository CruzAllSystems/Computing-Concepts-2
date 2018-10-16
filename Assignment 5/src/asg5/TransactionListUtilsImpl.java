package asg5;
import java.util.*;
import java.io.*;
import java.text.*;

public class TransactionListUtilsImpl 
{
	//pre: infile is open and ready to read data from in program readable format as expected for Transaction data
	//post: list is populated with data from file, adds to the current data already 
	//in the transactionList if any
	public static void readFromScanner(Scanner infile, TransactionList list)
	{
		Transaction trans = TransactionUtilsImpl.readFromScanner(infile);
		
		while(trans != null)
		{
			list.add(trans);
			trans = TransactionUtilsImpl.readFromScanner(infile);
			
		}//end of the index while
		
	}//end of the read from scanner method
	
	//pre: outfile is open and ready to write to
	//post: outfile contains current transaction list in program readable format
	public static void writeToFile(PrintWriter outfile, TransactionList list)
	{
		for(int index = 0; index < list.getSize(); index++)
			TransactionUtilsImpl.writeToFile(outfile, list.get(index));
		
		
	}//end of the writeToFile method
	

}//end of the TransactionListUtilsImpl class


