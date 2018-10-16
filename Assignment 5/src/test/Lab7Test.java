package test;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.GregorianCalendar;
import asg5.AccountCharge;
import asg5.AccountCredit;
import asg5.CreditCode;
import asg5.Transaction;
import utils.MyUtils;

public class Lab7Test {

	@Test
	public void test() {
	MyUtils.printTimeStamp("begins");
	testAccountCharge();
	testAccountCredit();
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
	GregorianCalendar cal = new GregorianCalendar(2016, 8, 12);
	assertTrue(ch1.getDateCalendar().equals(cal));
	assertTrue(ch1.getDateString().equals("9/12/2016"));
	amt = 100.0;
	ch1.setAmount(amt);
	assertTrue(ch1.getTransactionId().equals(result));
	assertFalse(ch1.getAmount()>amt);
	assertFalse(ch1.getAmount()<amt);
	ch1.setTransactionId(" ...!!!;;;;");
	assertTrue(ch1.getTransactionId().equals(Transaction.DEFAULT_TRANSACTION_ID));
	AccountCharge ch2 = new AccountCharge("8/29/2016", -50.00, "99ff33",
	"VALERO StatiON");
	assertTrue(ch2.getDateString().equals("8/29/2016"));
	assertTrue(!(ch2.getAmount()<-50.00));
	assertTrue(!(ch2.getAmount()>-50.00));
	assertTrue(ch2.getTransactionId().equals("99ff33"));
	assertTrue(ch2.getPayee().equals("Valero Station"));
	result = ch2.toString();
	total = MyUtils.numberLines(result);
	System.out.println("AccountCharge instance ch2: " + ch2);
	assertTrue(total == 0); // there should not be any newlines in the toString
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
	ch1.setCreditor(" HEB at South Congress OLTORf ");
	result="Heb At South Congress Oltorf";
	assertTrue(ch1.getCreditor().equals(result));
	result = "43abcd";
	ch1.setTransactionId("43abcdefg");
	assertTrue(ch1.getTransactionId().equals(result));
	ch1.setDate("9/12/2016");
	GregorianCalendar cal = new GregorianCalendar(2016, 8, 12);
	assertTrue(ch1.getDateCalendar().equals(cal));
	assertTrue(ch1.getDateString().equals("9/12/2016"));
	amt = 100.0;
	ch1.setAmount(amt);
	assertTrue(ch1.getTransactionId().equals(result));
	assertFalse(ch1.getAmount()>amt);
	assertFalse(ch1.getAmount()<amt);
	ch1.setTransactionId(" ...!!!;;;;");
	assertTrue(ch1.getTransactionId().equals(Transaction.DEFAULT_TRANSACTION_ID));
	assertTrue(ch1.getCreditCode().equals(CreditCode.OTHER));
	AccountCredit ch2 = new AccountCredit("8/29/2016", -50.00, "99ff33",
	"VALERO StatiON",CreditCode.RET);
	assertTrue(ch2.getDateString().equals("8/29/2016"));
	assertTrue(!(ch2.getAmount()<-50.00));
	assertTrue(!(ch2.getAmount()>-50.00));
	assertTrue(ch2.getTransactionId().equals("99ff33"));
	assertTrue(ch2.getCreditor().equals("Valero Station"));
	assertTrue(ch2.getCreditCode().equals(CreditCode.RET));
	result = ch2.toString();
	total = MyUtils.numberLines(result);
	System.out.println("AccountCredit instance ch2: " + ch2);
	assertTrue(total == 0); // there should not be any newlines in the toString
	}
}
