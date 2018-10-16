package test;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import asg3.CreditCardAccount;
import asg3.CreditCardAccountList;
import asg3.CreditCardAccountListImpl;
import asg3.CreditCardAccountUtilsImpl;
import asg3.MyUtils;

public class Lab4Test 
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CreditCardAccountList myList = new CreditCardAccountListImpl();
		CreditCardAccount act1 = new CreditCardAccount();
		int totalSuccess=0;
		int totalTest=0;
		int size = myList.getSize();
		totalTest++;
		if(size == 0)
		{
		totalSuccess++;
		System.out.println("SUCCESS, list should have a size of " + size);
		}
		else
		System.out.println("FAILURE, list should have a size of " + 0);
		totalTest++;
		if(!myList.contains(act1))
		{
		totalSuccess++;
		System.out.println("SUCCESS, list does not contain account: " + act1);
		}
		else
		System.out.println("FAILURE, list should not contain account: " + act1);
		Scanner in = null;
		String fileName="creditcardaccount.txt";
		try {
		in = new Scanner(new File(fileName));
		System.out.println("SUCCESS opened file " + fileName + " for input");
		}catch(FileNotFoundException e) {
		System.out.println("FAILURE cannot open file " + fileName + " for input" +
		" EXIT ON FAILURE TO OPEN FILE");
		System.exit(0);
		}
		int count = 0;
		boolean addResult=true;
		boolean result = CreditCardAccountUtilsImpl.readFromScanner(in, act1);
		while(result)
		{
		totalTest++;
		totalSuccess++;
		count ++;
		System.out.println("SUCCESS: Account " + count + " read from file: " + act1);
		totalTest++;
		addResult = myList.add(act1);
		if(!addResult)
		{
		System.out.println("FAILURE, could not add account: " + act1 + " to list, should be allowed.");
		System.out.println("Contents of current list:\n" + myList);
		}
		else
		{
		totalSuccess++;
		}
		act1 = new CreditCardAccount(); // get a new CreditCardAccount instance each time we loop
		result = CreditCardAccountUtilsImpl.readFromScanner(in, act1);
		}
		totalTest++;
		if(myList.getSize() == 5)
		{
		totalSuccess++;
		System.out.println("SUCCESS, current list has 5 credit card accounts as it should.");
		}
		else
		System.out.println("FAILURE, current list should have 5 credit card accounts.");
		CreditCardAccount act2 = new CreditCardAccount(207,"Johnson-Harding", "Mary lou", 500.00);
		totalTest++;
		if(myList.add(act2))
		{
		totalSuccess++;
		System.out.println("SUCCESS, added " + act2 + " to the list of credit card accounts.");
		}
		else
		{
		System.out.println("FAILURE, unable to add " + act2 + " to the list of credit card accounts.");
		}
		totalTest++;
		if(myList.getSize() == 6)
		{
		totalSuccess++;
		System.out.println("SUCCESS, current list has6 credit card accounts as it should.");
		}
		else
		System.out.println("FAILURE, current list should have 6 credit card accounts, instead it has " + myList.getSize() + " accounts");
		act2 = new CreditCardAccount(207,"Johnson-Harding", "Mary lou", 500.00);
		totalTest++;
		result = CreditCardAccountUtilsImpl.readFromScanner(in, act1);
		if(!result)
		{
		totalSuccess++;
		System.out.println("SUCCESS, could NOT add " + act2 + " to the list of credit card accounts.(DUPLICATE)");

		}
		else
		{
		System.out.println("FAILURE should NOT add " + act2 + " to the list of credit card accounts.(IT IS A DUPLICATE)");
		}
		fileName="creditcardaccount.txt";
		totalTest++;
		try {
		in = new Scanner(new File(fileName));
		totalSuccess++;
		System.out.println("SUCCESS opened file " + fileName + " for input");
		}catch(FileNotFoundException e) {
		System.out.println("FAILURE cannot open file " + fileName + " for input" +
		" EXIT ON FAILURE TO OPEN FILE");
		System.exit(0);
		}
		count = 0;
		addResult=true;
		result = CreditCardAccountUtilsImpl.readFromScanner(in, act1);
		while(result)
		{
		totalTest++;
		count ++;
		System.out.println("SUCCESS: Account " + count + " read from file: " + act1);
		totalSuccess++;
		addResult = myList.add(act1);
		totalTest++;
		if(!addResult)
		{
		totalSuccess++;
		System.out.println("SUCCESS, should not add account: " + act1 + " to list, should be DUPLICATE.");
		}
		else
		{
		System.out.println("FAILURE should not add account: " + act1 + " to list, should be DUPLICATE.");
		}

		act1 = new CreditCardAccount(); // get a new CreditCardAccount instance each time we loop
		result = CreditCardAccountUtilsImpl.readFromScanner(in, act1);
		}
		String listOut = myList.toString();
		int numLines = MyUtils.numberLines(listOut);
		totalTest++;
		if(myList.getSize() == numLines)
		{
		totalSuccess++;
		System.out.println("SUCCESS Number of lines is the same as number of CreditCardAccounts in the list: " + numLines);

		}
		else
		{
		System.out.println("FAILURE Number of lines should be the same as number of CreditCardAccounts in the list: " + myList.getSize());
		}
		System.out.println("Here is the final contents of the list of credit card accounts after testing:\nThere should be 6 credit card accounts\n" +
		"With these account numbers: 500, 200, 100, 400, 300, 207\n" + myList);
		System.out.println("Now testing get");
		int pos=0;
		int ans=500;
		totalTest++;
		CreditCardAccount a1 = myList.get(pos);
		if(a1.getAccountNumber()==ans)
		{
		totalSuccess++;
		System.out.println("SUCCESS, account number: " + ans + " is correct for position: " + pos);
		}
		else
		System.out.println("FAILURE, account number: " + ans + " is NOT correct for position: " + pos);
		pos=1;
		ans=200;
		totalTest++;
		a1 = myList.get(pos);
		if(a1.getAccountNumber()==ans)
		{
		totalSuccess++;
		System.out.println("SUCCESS, account number: " + ans + " is correct for position: " + pos);
		}
		else
		System.out.println("FAILURE, account number: " + ans + " is NOT correct for position: " + pos);
		pos=5;
		ans=207;
		totalTest++;
		a1 = myList.get(pos);
		if(a1.getAccountNumber()==ans)
		{
		totalSuccess++;
		System.out.println("SUCCESS, account number: " + ans + " is correct for position: " + pos);
		}
		else
		System.out.println("FAILURE, account number: " + ans + " is NOT correct for position: " + pos);
		pos=3;
		ans=400;
		totalTest++;
		a1 = myList.get(pos);
		if(a1.getAccountNumber()==ans)
		{
		totalSuccess++;
		System.out.println("SUCCESS, account number: " + ans + " is correct for position: " + pos);
		}
		else
		System.out.println("FAILURE, account number: " + ans + " is NOT correct for position: " + pos);
		pos=2;
		ans=100;
		a1 = myList.get(pos);
		totalTest++;
		if(a1.getAccountNumber()==ans)
		{
		totalSuccess++;
		System.out.println("SUCCESS, account number: " + ans + " is correct for position: " + pos);
		}
		else
		System.out.println("FAILURE, account number: " + ans + " is NOT correct for position: " + pos);
		pos=10;
		ans=0;
		totalTest++;
		a1 = myList.get(pos);
		if(a1 == null)
		{
		totalSuccess++;
		System.out.println("SUCCESS, cannot get a position: " + pos + " that is out of range...");
		}
		else
		System.out.println("FAILURE, position: " + pos + " should be out of range and a1 should be null...");
		pos=-3;
		ans=0;
		totalTest++;
		a1 = myList.get(pos);
		if(a1 == null)
		{
		totalSuccess++;
		System.out.println("SUCCESS, cannot get a position: " + pos + " that is out of range...");
		}
		else
		System.out.println("FAILURE, position: " + pos + " should be out of range and a1 should be null...");
		a1 = new CreditCardAccount(400, "","",0);
		totalTest++;
		if(myList.contains(a1))
		{
		totalSuccess++;
		System.out.println("SUCCESS, contains works properly finding an account with the number: " + a1.getAccountNumber());
		}
		else
		System.out.println("FAILURE, contains should find an account with the number: " + a1.getAccountNumber());
		a1 = new CreditCardAccount(500, "","",0);
		totalTest++;
		if(myList.contains(a1))
		{
		totalSuccess++;
		System.out.println("SUCCESS, contains works properly finding an account with the number: " + a1.getAccountNumber());
		}
		else
		System.out.println("FAILURE, contains should find an account with the number: " + a1.getAccountNumber());
		a1 = new CreditCardAccount(300, "","",0);
		totalTest++;
		if(myList.contains(a1))
		{
		totalSuccess++;
		System.out.println("SUCCESS, contains works properly finding an account with the number: " + a1.getAccountNumber());
		}
		else
		System.out.println("FAILURE, contains should find an account with the number: " + a1.getAccountNumber());
		a1 = new CreditCardAccount(207, "","",0);
		totalTest++;
		if(myList.contains(a1))
		{
		totalSuccess++;
		System.out.println("SUCCESS, contains works properly finding an account with the number: " + a1.getAccountNumber());
		}
		else
		System.out.println("FAILURE, contains should find an account with the number: " + a1.getAccountNumber());
		a1 = new CreditCardAccount(100, "","",0);
		totalTest++;
		if(myList.contains(a1))
		{
		totalSuccess++;
		System.out.println("SUCCESS, contains works properly finding an account with the number: " + a1.getAccountNumber());
		}
		else
		System.out.println("FAILURE, contains should find an account with the number: " + a1.getAccountNumber());
		System.out.println("\n\n****Now Beginning TEST PART 2 ****\n");
		System.out.println("Here is the current list: \n" + myList);
		String temp = myList.toString();
		count = myList.getSize();
		numLines = MyUtils.numberLines(temp);
		totalTest++;
		if(count == numLines)
		{
		totalSuccess++;
		System.out.println("SUCCESS Number of lines is the same as number of CreditCardAccounts in the list: " + numLines);
		}
		else
		{
		System.out.println("FAILURE Number of lines should be the same as number of CreditCardAccounts in the list: " + myList.getSize());
		}

		double theBalance=200;
		ans = 3;
		temp = myList.getCreditCardAccountsWithBalanceOver(theBalance);
		numLines=MyUtils.numberLines(temp);
		totalTest++;
		String msg="FAILURE";
		if(ans == numLines)
		{
		totalSuccess++;
		msg = "SUCCESS";
		}
		System.out.println(msg + " there should be " + ans + " accounts with balance over " + theBalance);
		theBalance=0.0;
		ans = 4;
		temp = myList.getCreditCardAccountsWithBalanceOver(theBalance);
		numLines=MyUtils.numberLines(temp);
		totalTest++;
		msg="FAILURE";
		if(ans == numLines)
		{
		totalSuccess++;
		msg = "SUCCESS";
		}
		System.out.println(msg + " there should be " + ans + " accounts with balance over " + theBalance);
		theBalance=1000.0;
		ans = 1;
		temp = myList.getCreditCardAccountsWithBalanceOver(theBalance);
		numLines=MyUtils.numberLines(temp);
		totalTest++;
		msg="FAILURE";
		if(ans == numLines)
		{
		totalSuccess++;
		msg = "SUCCESS";
		}
		System.out.println(msg + " there should be " + ans + " accounts with balance over " + theBalance);
		theBalance=400000.0;
		ans = 0;
		temp = myList.getCreditCardAccountsWithBalanceOver(theBalance);
		numLines=MyUtils.numberLines(temp);
		totalTest++;
		msg="FAILURE";
		if(ans == numLines)
		{
		totalSuccess++;
		msg = "SUCCESS";
		}
		System.out.println(msg + " there should be " + ans + " accounts with balance over " + theBalance);
		theBalance=-101.0;
		ans = 6;
		temp = myList.getCreditCardAccountsWithBalanceOver(theBalance);
		numLines=MyUtils.numberLines(temp);
		totalTest++;
		msg="FAILURE";
		if(ans == numLines)
		{
		totalSuccess++;
		msg = "SUCCESS";
		}
		System.out.println(msg + " there should be " + ans + " accounts with balance over " + theBalance);

		if(totalTest == totalSuccess)
		{
		System.out.println("SUCCESS All " + totalTest + " pass.");
		}
		else
		{
		System.out.println("FAILURES " + totalSuccess + " pass out of " + totalTest + " tests.");
		}
		}//end of main

}//end of the Lab4Test Class
