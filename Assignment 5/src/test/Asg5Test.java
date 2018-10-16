package test;

import static org.junit.Assert.*;
import asg5.Transaction; 
import asg5.AccountCharge; 
import asg5.AccountCredit;
import asg5.TransactionListImpl; 
import asg5.TransactionList; 
import asg5.TransactionListUtilsImpl; 
import asg5.TransactionUtilsImpl;
import asg5.CreditCode;
import utils.MyUtils;
import java.io.File; 
import java.io.FileNotFoundException; 
import java.io.IOException; 
import java.io.PrintWriter; 
import java.text.SimpleDateFormat; 
import java.util.GregorianCalendar; 
import java.util.Scanner;
import org.junit.AfterClass; 
import org.junit.BeforeClass;
import org.junit.Test;

public class Asg5Test 
{

	@Test
	public void test() 
	{
		MyUtils.printTimeStamp("begins");
		testAccountCharge();
		testAccountCredit();
		testEquals();
	    testTransactionUtilsImpl();
	    testTransactionListUtilsImpl();
		testUnsortedTransListAddContainsRemoveGet();
		testUnsortedTransList();
		System.out.println("SUCCESS all JUnit tests pass.");
		MyUtils.printTimeStamp("ends");
	}
	
	public void testAccountCharge()
	{
		String result;
		double amt=0.0;
		int total=0;
		AccountCharge ch1 = new AccountCharge();
		assertTrue(ch1.getTransactionId().equals(Transaction.DEFAULT_TRANSACTION_ID));
		assertFalse(ch1.getAmount()>0.0);
		assertFalse(ch1.getAmount()<0.0);
		assertTrue(ch1.getPayee().equals("$$$$"));
		assertTrue(ch1.getDateCalendar().equals(new GregorianCalendar(2000, 0, 1)));
		ch1.setPayee("");
		assertTrue(ch1.getPayee().equals("$$$$"));
		amt = -200.00;
		ch1.setAmount(amt);
		assertFalse(ch1.getAmount()<amt);
		assertFalse(ch1.getAmount()>amt);
		ch1.setPayee(" HEB at South Congress OLTORf ");
		result="Heb At South Congress Oltorf";
		assertTrue(ch1.getPayee().equals(result));
		result = "43abcd";
		ch1.setTransactionId("43abcdefg");
		assertTrue(ch1.getTransactionId().equals(result));
		ch1.setDate("9/12/2016");
		GregorianCalendar cal = new  GregorianCalendar(2016, 8, 12);
		assertTrue(ch1.getDateCalendar().equals(cal));
		assertTrue(ch1.getDateString().equals("9/12/2016"));
		amt = 100.0;
		ch1.setAmount(amt);
		assertTrue(ch1.getTransactionId().equals(result));
		assertFalse(ch1.getAmount()>amt);
		assertFalse(ch1.getAmount()<amt);
		ch1.setTransactionId("      ...!!!;;;;");
		assertTrue(ch1.getTransactionId().equals(Transaction.DEFAULT_TRANSACTION_ID));
		AccountCharge ch2 = new AccountCharge("8/29/2016", -50.00, "99ff33", "VALERO StatiON");  
		assertTrue(ch2.getDateString().equals("8/29/2016"));
		assertTrue(!(ch2.getAmount()<-50.00));
		assertTrue(!(ch2.getAmount()>-50.00));
		assertTrue(ch2.getTransactionId().equals("99ff33"));
		assertTrue(ch2.getPayee().equals("Valero Station"));
		result = ch2.toString();
		total = MyUtils.numberLines(result);
		System.out.println("AccountCharge instance ch2: " + ch2);
		assertTrue(total == 0);  // there should not be any newlines in the toString
	}
	public void testAccountCredit()
	{
		String result;
		double amt=0.0;
		int total=0;
		AccountCredit ch1 = new AccountCredit();
		assertTrue(ch1.getTransactionId().equals(Transaction.DEFAULT_TRANSACTION_ID));
		assertFalse(ch1.getAmount()>0.0);
		assertFalse(ch1.getAmount()<0.0);
		assertTrue(ch1.getCreditor().equals("$$$$"));
		assertTrue(ch1.getDateCalendar().equals(new GregorianCalendar(2000, 0, 1)));
		amt = -200.00;
		ch1.setAmount(amt);
		assertFalse(ch1.getAmount()<amt);
		assertFalse(ch1.getAmount()>amt);
		ch1.setCreditor("");
		assertTrue(ch1.getCreditor().equals("$$$$"));
		ch1.setCreditor(" HEB at South Congress OLTORf ");
		result="Heb At South Congress Oltorf";
		assertTrue(ch1.getCreditor().equals(result));
		result = "43abcd";
		ch1.setTransactionId("43abcdefg");
		assertTrue(ch1.getTransactionId().equals(result));
		ch1.setDate("9/12/2016");
		GregorianCalendar cal = new  GregorianCalendar(2016, 8, 12);
		assertTrue(ch1.getDateCalendar().equals(cal));
		assertTrue(ch1.getDateString().equals("9/12/2016"));
		amt = 100.0;
		ch1.setAmount(amt);
		assertTrue(ch1.getTransactionId().equals(result));
		assertFalse(ch1.getAmount()>amt);
		assertFalse(ch1.getAmount()<amt);
		ch1.setTransactionId("      ...!!!;;;;");
		assertTrue(ch1.getTransactionId().equals(Transaction.DEFAULT_TRANSACTION_ID));
		assertTrue(ch1.getCreditCode().equals(CreditCode.OTHER));
		AccountCredit ch2 = new AccountCredit("8/29/2016", -50.00, "99ff33", "VALERO StatiON",CreditCode.RET);
		assertTrue(ch2.getDateString().equals("8/29/2016"));
		assertTrue(!(ch2.getAmount()<-50.00));
		assertTrue(!(ch2.getAmount()>-50.00));
		assertTrue(ch2.getTransactionId().equals("99ff33"));
		assertTrue(ch2.getCreditor().equals("Valero Station"));
		assertTrue(ch2.getCreditCode().equals(CreditCode.RET));
		result = ch2.toString();
		total = MyUtils.numberLines(result);
		System.out.println("AccountCredit instance ch2: " + ch2);
		assertTrue(total == 0);  // there should not be any newlines in the toString
	}

	public void testEquals ()
	{
		AccountCredit ch2 = new AccountCredit("8/29/2016", -50.00, "99ff33", "VALERO StatiON",CreditCode.RET);
		AccountCredit ch1 = new AccountCredit("8/29/2016", -50.00, "99ff33", "VALERO StatiON",CreditCode.RET);
		assertTrue(ch2.equals (ch1));
		ch1.setDate("8/28/2016");
		assertFalse(ch2.equals(ch1));
		AccountCharge ch3 = new AccountCharge();
		AccountCharge ch4 = new AccountCharge();
		assertTrue(ch3.equals(ch4));
		ch3.setPayee("   ");
		ch4.setPayee("   ");
		assertTrue(ch4.equals(ch3));
		ch3.setPayee("  HeB");
		ch4.setPayee(" HEb  ");
		assertTrue(ch4.equals(ch3));
		ch3.setDate("8/12/2016");
		assertFalse(ch4.equals(ch3));
		ch4.setDate("8/12/2016");
		assertTrue(ch4.equals(ch3));   
	}
	public void testTransactionUtilsImpl()
	{
		AccountCharge ch1, ch2, ch3;
		System.out.println("Now testing readFromScanner for AccountCharge");
		AccountCredit cr1, cr2, cr3;
		Scanner infile = null;
		String filename="";
		filename="charges.txt";
		try {
			infile = new Scanner(new File(filename));
		}catch(FileNotFoundException e)
		{
			System.out.println("FAILURE, cannot open file: " + filename + " for input, exiting on FAILURE");
			assertTrue(infile != null);
			return;
		}
		ch1 = (AccountCharge)TransactionUtilsImpl.readFromScanner(infile);
		assertTrue(ch1 != null);
		System.out.println("just read ch1: " + ch1);
		assertTrue(ch1.getDateString().equals("10/1/2016"));
		assertTrue(!(ch1.getAmount()<150.00));
		assertTrue(!(ch1.getAmount()>150.00));
		assertTrue(ch1.getTransactionId().equals("99ff99"));
		assertTrue(ch1.getPayee().equals("La Cantera Golf Tournament San Antonio"));
		ch2 = (AccountCharge)TransactionUtilsImpl.readFromScanner(infile);
		assertTrue(ch2 != null);
		System.out.println("just read ch2: " + ch2);
		assertTrue(ch2.getDateString().equals("9/12/2016"));
		assertTrue(!(ch2.getAmount()<25.00));
		assertTrue(!(ch2.getAmount()>25.00));
		assertTrue(ch2.getTransactionId().equals("4455jk"));
		assertTrue(ch2.getPayee().equals("Heb New Braunfels, Tx"));
		ch3  = (AccountCharge)TransactionUtilsImpl.readFromScanner(infile);
		assertTrue(ch3 != null);
		System.out.println("just read ch3: " + ch3);
		assertTrue(ch3.getDateString().equals("10/3/2016"));
		assertTrue(!(ch3.getAmount()<85.17));
		assertTrue(!(ch3.getAmount()>85.17));
		assertTrue(ch3.getTransactionId().equals("0088f4"));
		assertTrue(ch3.getPayee().equals("Green Valley Utility"));
		infile.close();
		filename = "credits.txt";
		try {
			infile = new Scanner(new File(filename));
		}catch(FileNotFoundException e)
		{
			System.out.println("FAILURE, cannot open file: " + filename + " for input, exiting on FAILURE");
			assertTrue(infile != null);
			return;
		}
		
		cr1 = (AccountCredit)TransactionUtilsImpl.readFromScanner(infile);
		cr2 = (AccountCredit)TransactionUtilsImpl.readFromScanner(infile);
		cr3 = (AccountCredit)TransactionUtilsImpl.readFromScanner(infile);
		assertTrue(cr1.getDateString().equals("9/9/2016") && 
				   cr1.getTransactionId().equals("99uu66") &&
				   cr1.getCreditCode()==CreditCode.RET &&
				   cr1.getCreditor().equals("Macy's"));
		assertTrue(!(cr1.getAmount()<-25.00));
		assertTrue(!(cr1.getAmount()>-25.00));
		assertTrue(cr2.getDateString().equals("8/17/2016") && 
				   cr2.getTransactionId().equals("3rt533") &&
				   cr2.getCreditCode()==CreditCode.OTHER &&
				   cr2.getCreditor().equals("Valero"));
		assertTrue(!(cr2.getAmount()<-100.00));
		assertTrue(!(cr2.getAmount()>-100.00));
		assertTrue(cr3.getDateString().equals("10/3/2016") && 
				   cr3.getTransactionId().equals("93jh3l") &&
				   cr3.getCreditCode()==CreditCode.ERR &&
				   cr3.getCreditor().equals("Universal Toyota"));
		assertTrue(!(cr3.getAmount()<-84.00));
		assertTrue(!(cr3.getAmount()>-84.00));
		infile.close();
		filename="accountchargeOut.txt";
		PrintWriter outfile = null;
			try {
				outfile = new PrintWriter(new File(filename));
			}catch(IOException e) {
				System.out.println("FAILURE, cannot open file: " + filename + " for output, exiting on FAILURE");
				assertTrue(outfile!=null);
				return;
			}
		TransactionUtilsImpl.writeToFile(outfile, cr1);
		TransactionUtilsImpl.writeToFile(outfile, ch1);
		TransactionUtilsImpl.writeToFile(outfile, cr2);
		TransactionUtilsImpl.writeToFile(outfile, ch2);
		TransactionUtilsImpl.writeToFile(outfile, cr3);
		TransactionUtilsImpl.writeToFile(outfile, ch3);
		outfile.close();
		
		filename="accountchargeOut.txt";
		try {
			infile = new Scanner(new File(filename));
		}catch(FileNotFoundException e)
		{
			System.out.println("FAILURE, cannot open file: " + filename + " for input, exiting on FAILURE");
			return;
		}
		
		cr1 = (AccountCredit)TransactionUtilsImpl.readFromScanner(infile);
		assertTrue(cr1 != null);
		ch1 =(AccountCharge)TransactionUtilsImpl.readFromScanner(infile);
		assertTrue(ch1 != null);
		cr2 = (AccountCredit)TransactionUtilsImpl.readFromScanner(infile);
		assertTrue(cr2 != null);
		ch2 =(AccountCharge)TransactionUtilsImpl.readFromScanner(infile);
		assertTrue(ch2 != null);
		cr3 = (AccountCredit)TransactionUtilsImpl.readFromScanner(infile);
		assertTrue(cr3 != null);
		ch3 =(AccountCharge)TransactionUtilsImpl.readFromScanner(infile);
		assertTrue(ch1 != null);
		
		System.out.println("just read ch1: " + ch1);
		assertTrue(ch1.getDateString().equals("10/1/2016"));
		assertTrue(!(ch1.getAmount()<150.00));
		assertTrue(!(ch1.getAmount()>150.00));
		assertTrue(ch1.getTransactionId().equals("99ff99"));
		assertTrue(ch1.getPayee().equals("La Cantera Golf Tournament San Antonio"));
		
		System.out.println("just read ch2: " + ch2);
		assertTrue(ch2.getDateString().equals("9/12/2016"));
		assertTrue(!(ch2.getAmount()<25.00));
		assertTrue(!(ch2.getAmount()>25.00));
		assertTrue(ch2.getTransactionId().equals("4455jk"));
		assertTrue(ch2.getPayee().equals("Heb New Braunfels, Tx"));
		
		System.out.println("just read ch3: " + ch3);
		assertTrue(ch3.getDateString().equals("10/3/2016"));
		assertTrue(!(ch3.getAmount()<85.17));
		assertTrue(!(ch3.getAmount()>85.17));
		assertTrue(ch3.getTransactionId().equals("0088f4"));
		assertTrue(ch3.getPayee().equals("Green Valley Utility"));
		
		System.out.println("just read cr1: " + cr1);
		assertTrue(cr1.getDateString().equals("9/9/2016") && 
				   cr1.getTransactionId().equals("99uu66") &&
				   cr1.getCreditCode()==CreditCode.RET &&
				   cr1.getCreditor().equals("Macy's"));
		assertTrue(!(cr1.getAmount()<-25.00));
		assertTrue(!(cr1.getAmount()>-25.00));
		System.out.println("just read cr2: " + cr2);
		assertTrue(cr2.getDateString().equals("8/17/2016") && 
				   cr2.getTransactionId().equals("3rt533") &&
				   cr2.getCreditCode()==CreditCode.OTHER &&
				   cr2.getCreditor().equals("Valero"));
		assertTrue(!(cr2.getAmount()<-100.00));
		assertTrue(!(cr2.getAmount()>-100.00));
		System.out.println("just read cr3: " + cr3);
		assertTrue(cr3.getDateString().equals("10/3/2016") && 
				   cr3.getTransactionId().equals("93jh3l") &&
				   cr3.getCreditCode()==CreditCode.ERR &&
				   cr3.getCreditor().equals("Universal Toyota"));
		assertTrue(!(cr3.getAmount()<-84.00));
		assertTrue(!(cr3.getAmount()>-84.00));
		
	}
	
	public void testTransactionListUtilsImpl() {  
		Scanner infile = null;
		String filename="";
		AccountCharge ch2 = new AccountCharge("8/29/2016", -50.00, "99ff33", "VALERO StatiON");
		filename="accountEmpty.txt";
		PrintWriter outfile = null;
		try {
			outfile = new PrintWriter(new File(filename));
		}catch(IOException e) {
			System.out.println("FAILURE, cannot open file: " + filename + " for output, exiting on FAILURE");
			return;
		}
		outfile.close();

		filename="accountEmpty.txt";
		try {
			infile = new Scanner(new File(filename));
		}catch(FileNotFoundException e)
		{
			System.out.println("FAILURE, cannot open file: " + filename + " for input, exiting on FAILURE");
			assertTrue(infile != null);
			return;
		}
		TransactionList transList = new TransactionListImpl();
		TransactionListUtilsImpl.readFromScanner(infile, transList);
		assertTrue(transList.getSize()==0);
		infile.close();
		filename="accountOne.txt";
		outfile = null;
		try {
			outfile = new PrintWriter(new File(filename));
		}catch(IOException e) {
			System.out.println("FAILURE, cannot open file: " + filename + " for output, exiting on FAILURE");
			return;
		}
		assertTrue(transList.add(ch2));
		assertTrue(transList.getSize()==1);
		TransactionListUtilsImpl.writeToFile(outfile, transList);
		outfile.close();
		filename="accountOne.txt";
		try {
			infile = new Scanner(new File(filename));
		}catch(FileNotFoundException e)
		{
			System.out.println("FAILURE, cannot open file: " + filename + " for input, exiting on FAILURE");
			assertTrue(infile != null);
			return;
		}
        transList = new TransactionListImpl();
        TransactionListUtilsImpl.readFromScanner(infile, transList);
		assertTrue(transList.getSize()==1);
		//now remove the only transaction in list1
		assertTrue(transList.remove(ch2) != null);
		assertTrue(transList.getSize() == 0);
		infile.close();
		filename="accountchargeOut.txt";
		try {
			infile = new Scanner(new File(filename));
		}catch(FileNotFoundException e)
		{
			System.out.println("FAILURE, cannot open file: " + filename + " for input, exiting on FAILURE");
			assertTrue(infile != null);
			return;
		}
		TransactionListUtilsImpl.readFromScanner(infile, transList);
		assertTrue(transList.getSize()==6);
		System.out.println("final list:accountchargeOut.txt\n" + transList);
		infile.close();
	}
    public void testUnsortedTransListAddContainsRemoveGet()
    {
    	TransactionList myList = new TransactionListImpl();
		assertTrue(myList.getSize() == 0);
		assertTrue(myList.get(0) == null);
		assertTrue(myList.get(100) == null);
		AccountCharge ch1 = new AccountCharge("8/29/2016", -50.00, "99ff33", "VALERO StatiON"); 
		AccountCredit ch2 = new AccountCredit("8/29/2016", -50.00, "99ff33", "VALERO StatiON",CreditCode.RET);
		assertFalse(myList.contains(ch1));
		assertFalse(myList.contains(ch2));
		assertTrue(myList.add(ch1));
		assertTrue(myList.contains(ch1));
		assertTrue(myList.get(0).equals(ch1));
		assertFalse(myList.add(ch1));
		assertTrue(myList.getSize() == 1);
		assertTrue(myList.add(ch2));
		System.out.println("Current List, should have 2 Transactions: \n" + myList);
		assertTrue(myList.contains(ch2));
		AccountCredit ch3 = (AccountCredit)myList.get(0);	
		assertTrue(myList.get(0).equals(ch3));
		assertTrue(myList.getSize() == 2);
		assertFalse(myList.add(ch3));
		String data = myList.getAllTransactionsByDate("8/29/2016");
		int count = utils.MyUtils.numberLines(data);
		int correct = 2;
		assertTrue(count == correct);
		data = myList.getAllTransactionsByDate("8/31/2016");
		count = utils.MyUtils.numberLines(data);
		correct = 0;
		assertTrue(count == correct);
		assertTrue(data.equals(""));
		AccountCharge ch4 = new AccountCharge("9/2/2016", 128.33, "iit334", "HEB at OLTORF"); 
		AccountCredit ch5 = new AccountCredit("10/11/2016", -20.00, "pwr432", "Thundercloud Subs on Riverside",CreditCode.ERR);
		AccountCharge ch6 = new AccountCharge("9/12/2016", 176.33, "ihhg34", "HEB at OLTORF"); 
		assertTrue(myList.add(ch4));
		assertTrue(myList.add(ch5));
		assertTrue(myList.add(ch6));
		assertTrue(myList.contains(ch4));
		assertTrue(myList.contains(ch5));
		assertTrue(myList.contains(ch6));
		assertTrue(myList.getSize() == 5);
		data = myList.getAllTransactionsByDate("9/2/2016");
		count = utils.MyUtils.numberLines(data);
		correct = 1;
		assertTrue(count == correct);
		data = myList.getAllTransactionsByDate("10/11/2016");
		count = utils.MyUtils.numberLines(data);
		correct = 1;
		assertTrue(count == correct);	
		data = myList.getAllTransactionsByDate("5/11/2016");
		count = utils.MyUtils.numberLines(data);
		correct = 0;
		assertTrue(count == correct);
		data = myList.toString();
		count = utils.MyUtils.numberLines(data);
		assertTrue(count==5);
		System.out.println("Current List, should have 5 Transactions: \n" + myList);
		data = myList.getAllTransactionsByPayee("heb at oltorf ");
		count = utils.MyUtils.numberLines(data);
		correct = 2;
		assertTrue(count == correct);
		data = myList.getAllTransactionsByPayee("VALERO statioN");
		count = utils.MyUtils.numberLines(data);
		correct = 1;
		assertTrue(count == correct);
		data = myList.getAllTransactionsByPayee("Walmart at i35");
		count = utils.MyUtils.numberLines(data);
		correct = 0;
		assertTrue(count == correct);
		correct = 0;
		assertTrue(myList.get(correct).equals(ch6));
		correct = 1;
		assertTrue(myList.get(correct).equals(ch5));
		correct = 4;
		assertTrue(myList.get(correct).equals(ch1));
		correct = 3;
		assertTrue(myList.get(correct).equals(ch2));
		AccountCredit remCredit = (AccountCredit)myList.remove(ch2);
		assertTrue(remCredit.equals(ch2));
		assertTrue(myList.get(4) == null);
		assertTrue(myList.getSize() == 4);
		AccountCharge remCharge = (AccountCharge)myList.remove(ch1);
		assertTrue(remCharge.equals(ch1));
		assertTrue(myList.get(3) == null);
		assertTrue(myList.getSize() == 3);
		remCredit = (AccountCredit)myList.remove(ch5);
		assertTrue(remCredit.equals(ch5));
		assertTrue(myList.get(2) == null);
		assertTrue(myList.getSize() == 2);
		remCharge = (AccountCharge)myList.remove(ch4);
		assertTrue(remCharge.equals(ch4));
		assertTrue(myList.get(1) == null);
		assertTrue(myList.find(remCharge) == -1);
		assertTrue(myList.getSize() == 1);
		remCharge = (AccountCharge) myList.remove(ch6);
		assertTrue(remCharge.equals(ch6));
		assertTrue(myList.getSize() == 0);
		assertTrue(myList.add(remCredit));
		assertTrue(myList.getSize() == 1);
		assertTrue(myList.add(remCharge));
		assertTrue(myList.getSize()==2);
		data = myList.toString();
		assertTrue(utils.MyUtils.numberLines(data) ==2);
		System.out.println("Current List of 2 Transactions:\n" + data);
    	
    }
	public void testUnsortedTransList()
	{
		TransactionList myList = new TransactionListImpl();
		assertTrue(myList.getSize() == 0);
		assertTrue(myList.get(0) == null);
		assertTrue(myList.get(100) == null);
		AccountCharge ch1 = new AccountCharge("8/29/2016", -50.00, "99ff33", "VALERO StatiON"); 
		AccountCredit ch2 = new AccountCredit("8/29/2016", -50.00, "99ff33", "VALERO StatiON",CreditCode.RET);
		assertFalse(myList.contains(ch1));
		assertFalse(myList.contains(ch2));
		assertTrue(myList.find(ch1) == -1);
		assertTrue(myList.find(ch2) == -1);
		assertTrue(myList.add(ch1));
		assertTrue(myList.contains(ch1));
		assertTrue(myList.get(0).equals(ch1));
		assertFalse(myList.add(ch1));
		assertTrue(myList.getSize() == 1);
		assertTrue(myList.add(ch2));
		System.out.println("Current List, should have 2 Transactions: \n" + myList);
		assertTrue(myList.contains(ch2));
		AccountCredit ch3 = (AccountCredit)myList.get(0);	
		assertTrue(myList.get(0).equals(ch3));
		assertTrue(myList.getSize() == 2);
		assertFalse(myList.add(ch3));
		String data = myList.getAllTransactionsByDate("8/29/2016");
		int count = utils.MyUtils.numberLines(data);
		int correct = 2;
		assertTrue(count == correct);
		data = myList.getAllTransactionsByDate("8/31/2016");
		count = utils.MyUtils.numberLines(data);
		correct = 0;
		assertTrue(count == correct);
		assertTrue(data.equals(""));
		AccountCharge ch4 = new AccountCharge("9/2/2016", 128.33, "iit334", "HEB at OLTORF"); 
		AccountCredit ch5 = new AccountCredit("10/11/2016", -20.00, "pwr432", "Thundercloud Subs on Riverside",CreditCode.ERR);
		AccountCharge ch6 = new AccountCharge("9/12/2016", 176.33, "ihhg34", "HEB at OLTORF"); 
		assertTrue(myList.add(ch4));
		assertTrue(myList.add(ch5));
		assertTrue(myList.add(ch6));
		assertTrue(myList.contains(ch4));
		assertTrue(myList.contains(ch5));
		assertTrue(myList.contains(ch6));
		assertTrue(myList.getSize() == 5);
		data = myList.getAllTransactionsByDate("9/2/2016");
		count = utils.MyUtils.numberLines(data);
		correct = 1;
		assertTrue(count == correct);
		data = myList.getAllTransactionsByDate("10/11/2016");
		count = utils.MyUtils.numberLines(data);
		correct = 1;
		assertTrue(count == correct);	
		data = myList.getAllTransactionsByDate("5/11/2016");
		count = utils.MyUtils.numberLines(data);
		correct = 0;
		assertTrue(count == correct);
		data = myList.toString();
		count = utils.MyUtils.numberLines(data);
		assertTrue(count==5);
		System.out.println("Current List, should have 5 Transactions: \n" + myList);
		data = myList.getAllTransactionsByPayee("heb at oltorf ");
		count = utils.MyUtils.numberLines(data);
		correct = 2;
		assertTrue(count == correct);
		data = myList.getAllTransactionsByPayee("VALERO statioN");
		count = utils.MyUtils.numberLines(data);
		correct = 1;
		assertTrue(count == correct);
		data = myList.getAllTransactionsByPayee("Walmart at i35");
		count = utils.MyUtils.numberLines(data);
		correct = 0;
		assertTrue(count == correct);
		int pos = myList.find(ch6);
		correct = 0;
		assertTrue(pos == correct);
		assertTrue(myList.get(correct).equals(ch6));
		pos = myList.find(ch5);
		correct = 1;
		assertTrue(pos == correct);
		assertTrue(myList.get(correct).equals(ch5));
		pos = myList.find(ch1);
		correct = 4;
		assertTrue(pos == correct);
		assertTrue(myList.get(correct).equals(ch1));
		pos = myList.find(ch2);
		correct = 3;
		assertTrue(pos == correct);
		assertTrue(myList.get(correct).equals(ch2));
		AccountCredit remCredit = (AccountCredit)myList.remove(ch2);
		assertTrue(remCredit.equals(ch2));
		assertTrue(myList.get(4) == null);
		assertTrue(myList.find(remCredit) == -1);
		assertTrue(myList.getSize() == 4);
		AccountCharge remCharge = (AccountCharge)myList.remove(ch1);
		assertTrue(remCharge.equals(ch1));
		assertTrue(myList.get(3) == null);
		assertTrue(myList.find(remCharge) == -1);
		assertTrue(myList.getSize() == 3);
		remCredit = (AccountCredit)myList.remove(ch5);
		assertTrue(remCredit.equals(ch5));
		assertTrue(myList.get(2) == null);
		assertTrue(myList.find(remCredit) == -1);
		assertTrue(myList.getSize() == 2);
		remCharge = (AccountCharge)myList.remove(ch4);
		assertTrue(remCharge.equals(ch4));
		assertTrue(myList.get(1) == null);
		assertTrue(myList.find(remCharge) == -1);
		assertTrue(myList.getSize() == 1);
		remCharge = (AccountCharge) myList.remove(ch6);
		assertTrue(remCharge.equals(ch6));
		assertTrue(myList.getSize() == 0);
		assertTrue(myList.add(remCredit));
		assertTrue(myList.getSize() == 1);
		assertTrue(myList.add(remCharge));
		assertTrue(myList.getSize()==2);
		data = myList.toString();
		assertTrue(utils.MyUtils.numberLines(data) ==2);
		System.out.println("Current List of 2 Transactions:\n" + data);
	}

}
