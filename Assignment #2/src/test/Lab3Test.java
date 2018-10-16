package test;
import asg2.*;
public class Lab3Test 
{
	public static void main(String [] args)
	{
	int totalSuccess = 0;
	int totalTest = 0;
	int totalFailure = 0;
	double bal = 0.0;
	String lname = "";
	int actnum = 0;
	System.out.println("Testing default constructor, CreditCardAccount()");
	CreditCardAccount c1 = new CreditCardAccount();
	totalTest++;
	if(c1.getAccountNumber()==0)
	{
	System.out.println("SUCCESS account number should be :" + actnum +" in default constructor ");
	totalSuccess++;
	}
	else
	{
	System.out.println("FAILURE account number should be : " + actnum + " in default constructor");
	totalFailure++;
	}
	totalTest++;
	if(c1.getLastName().equals("$$$$"))
	{
	System.out.println("SUCCESS last name should be $$$$.");
	totalSuccess++;
	}
	else
	{
	System.out.println("FAILURE last name should be $$$$ in default constructor");
	totalFailure++;
	}
	totalTest++;
	if(c1.getFirstName().equals("$$$$"))
	{
	System.out.println("SUCCESS first name should be $$$$.");
	totalSuccess++;
	}
	else
	{
	System.out.println("FAILURE first name should be $$$$ in default constructor");
	totalFailure++;
	}
	totalTest++;
	bal = 0.0;
	if(c1.getBalance()==0.0)
	{
	System.out.println("SUCCESS balance should be :" + bal );
	totalSuccess++;
	}
	else
	{
	System.out.println("FAILURE balance should be : " + bal + " in default constructor");
	totalFailure++;
	}
	System.out.println("Now testing setAccountNumber method");
	actnum = -3;
	int cActnum = 0;
	c1.setAccountNumber(actnum);
	totalTest++;
	if(c1.getAccountNumber()==cActnum)
	{
	System.out.println("SUCCESS account number should be :" + cActnum );
	totalSuccess++;
	}
	else
	{
	System.out.println("FAILURE account number should be : " + cActnum );
	totalFailure++;
	}
	actnum = 9899;
	cActnum = 9899;
	c1.setAccountNumber(actnum);
	totalTest++;
	if(c1.getAccountNumber()==cActnum)
	{
	System.out.println("SUCCESS account number should be : " + cActnum );
	totalSuccess++;
	}
	else
	{
	System.out.println("FAILURE account number should be : " + cActnum );
	totalFailure++;
	}
	actnum = 0;
	cActnum = 0;
	c1.setAccountNumber(actnum);
	totalTest++;
	if(c1.getAccountNumber()==cActnum)
	{
	System.out.println("SUCCESS account number should be :" + cActnum );
	totalSuccess++;
	}
	else
	{
	System.out.println("FAILURE account number should be : " + cActnum );
	totalFailure++;
	}

	System.out.println("Now testing setLastName method");
	String cLName="$$$$";
	lname = "";
	c1.setLastName(lname);
	totalTest++;
	if(c1.getLastName().equals(cLName))
	{
	System.out.println("SUCCESS last name should be : " + cLName );
	totalSuccess++;
	}
	else
	{
	System.out.println("FAILURE last name should be : " + cLName );
	totalFailure++;
	}
	cLName="L. Baker";
	lname = " l. bAkeR ";
	c1.setLastName(lname);
	totalTest++;
	if(c1.getLastName().equals(cLName))
	{
	System.out.println("SUCCESS last name should be : " + cLName );
	totalSuccess++;
	}
	else
	{
	System.out.println("FAILURE last name should be : " + cLName );
	totalFailure++;
	}
	cLName="$$$$";
	lname = " ";
	c1.setLastName(lname);
	totalTest++;
	if(c1.getLastName().equals(cLName))
	{
	System.out.println("SUCCESS last name should be : " + cLName );
	totalSuccess++;
	}
	else
	{
	System.out.println("FAILURE last name should be : " + cLName );
	totalFailure++;
	}
	lname=" delGado Villareal ";
	cLName= "Delgado Villareal";
	c1.setLastName(lname);
	totalTest++;
	if(c1.getLastName().equals(cLName))
	{
	System.out.println("SUCCESS last name should be : " + cLName );
	totalSuccess++;
	}
	else
	{
	System.out.println("FAILURE last name should be : " + cLName );
	totalFailure++;
	}
	System.out.println("Now testing setFirstName method");
	cLName="Cook Bobby";
	lname = " cOOk boBbY ";
	c1.setFirstName(lname);
	totalTest++;
	if(c1.getFirstName().equals(cLName))
	{
	System.out.println("SUCCESS first name should be : " + cLName );
	totalSuccess++;
	}
	else
	{
	System.out.println("FAILURE first name should be : " + cLName );
	totalFailure++;
	}
	lname=" r k rodriguez";
	cLName = "R K Rodriguez";
	c1.setFirstName(lname);
	totalTest++;
	if(c1.getFirstName().equals(cLName))
	{
	System.out.println("SUCCESS first name should be : " + cLName );
	totalSuccess++;
	}
	else
	{
	System.out.println("FAILURE first name should be : " + cLName );
	totalFailure++;
	}
	System.out.println("Now testing setBalance method");
	double cBal= -100.00;
	bal = -100.00;
	totalTest++;
	c1.setBalance(bal);
	if(c1.getBalance() < cBal || c1.getBalance() > cBal )
	{
	System.out.println("FAILURE balance should be : " + cBal + " not " + c1.getBalance());
	totalFailure++;
	}
	else
	{
	System.out.println("SUCCESS balance should be : " + cBal );
	totalSuccess++;
	}
	cBal= -200.04;
	bal = -200.04;
	totalTest++;
	c1.setBalance(bal);
	if(c1.getBalance() < cBal || c1.getBalance() > cBal )
	{
	System.out.println("FAILURE balance should be : " + cBal + " not " + c1.getBalance());
	totalFailure++;
	}
	else
	{
	System.out.println("SUCCESS balance should be : " + cBal );
	totalSuccess++;
	}
	cBal= 1356.88;
	bal = 1356.88;
	totalTest++;
	c1.setBalance(bal);
	if(c1.getBalance() < cBal || c1.getBalance() > cBal )
	{
	System.out.println("FAILURE balance should be : " + cBal + " not " + c1.getBalance());
	totalFailure++;
	}
	else
	{
	System.out.println("SUCCESS balance should be : " + cBal );
	totalSuccess++;
	}
	cBal= 0.0;
	bal = 0.0;
	totalTest++;
	c1.setBalance(bal);
	if(c1.getBalance() < cBal || c1.getBalance() > cBal )
	{
	System.out.println("FAILURE balance should be : " + cBal + " not " + c1.getBalance());
	totalFailure++;
	}
	else
	{
	System.out.println("SUCCESS balance should be : " + cBal );
	totalSuccess++;
	}
	System.out.println("Now testing toString method (should not have any newlines in it)");
	String out = c1.toString();
	int cCount=0;
	int count = MyUtils.numberLines(out);
	totalTest++;
	if(count == cCount)
	{
	System.out.println("SUCCESS number of lines in String should be : " + cCount );
	totalSuccess++;
	}
	else
	{
	System.out.println("FAILURE number of lines in String should be : " + cCount + " not " + count);
	totalFailure++;
	}
	System.out.println("Here is the toString of CreditCardAccount c1: \n" + c1);
	System.out.println("Now testing second constructor with all data received");
	c1 = new CreditCardAccount(-1," Smart ", "pamela k j ", -200.0);
	totalTest++;
	cBal=-200.0;
	bal = c1.getBalance();
	if((bal < cBal) || (bal > cBal))
	{
	totalFailure++;
	System.out.println("FAILURE, constructor did not properly set balance should be " + cBal);
	}
	else
	{
	totalSuccess++;
	System.out.println("SUCCESS, constructor properly set balance");
	}
	totalTest++;
	actnum = c1.getAccountNumber();
	cActnum= 0;

	if(actnum == cActnum)
	{
	totalSuccess++;
	System.out.println("SUCCESS, constructor properly set account number");
	}
	else
	{
	totalFailure++;
	System.out.println("FAILURE, constructor did not properly set account number should be " + cActnum);
	}

	totalTest++;
	lname= c1.getLastName();
	cLName="Smart";

	if(cLName.equals(lname))
	{
	totalSuccess++;
	System.out.println("SUCCESS, constructor properly set last name");
	}
	else
	{
	totalFailure++;
	System.out.println("FAILURE, constructor did not properly set last name it should be: " + cLName + " rather than " + lname);
	}
	totalTest++;
	lname= c1.getFirstName();
	cLName="Pamela K J";

	if(cLName.equals(lname))
	{
	totalSuccess++;
	System.out.println("SUCCESS, constructor properly set first name");
	}
	else
	{
	totalFailure++;
	System.out.println("FAILURE, constructor did not properly set first name it should be: " + cLName + " rather than " + lname);
	}
	System.out.println("Now testing Accessors");
	totalTest++;
	actnum = c1.getAccountNumber();
	cActnum = 0;
	if(actnum == cActnum)
	{
	totalSuccess++;
	System.out.println("SUCCESS, accessor getAccountNumber() working");
	}
	else
	{
	totalFailure++;
	System.out.println("FAILURE, accessor getAccountNumber() not working " + actnum + " rather than " + cActnum);
	}
	totalTest++;
	bal = c1.getBalance();
	cBal= -200.00;
	if((bal < cBal) || (bal > cBal))
	{
	totalFailure++;
	System.out.println("FAILURE, accessor did not properly get balance should be " + cBal);
	}
	else
	{
	totalSuccess++;
	System.out.println("SUCCESS, accessor properly got balance");
	}
	//--------------------------------
	System.out.println("FINAL OUTCOME:");
	if(totalSuccess == totalTest)
	{
	System.out.println("ALL SUCCESS, ALL " + totalTest + " TESTS PASS");
	}
	else
	{
	System.out.println("FAILURE, " + totalFailure + " tests fail out of " + totalTest + " tests.");
	}

	}//end of main method

}//end of the lab 3 test class
