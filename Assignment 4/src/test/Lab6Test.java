package test;
import asg4.CreditCardAccountListImpl;
import asg4.CreditCardAccountList;
import asg4.CreditCardAccountListUtilsImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import asg4.CreditCardAccount;
import asg4.CreditCardAccountUtilsImpl;
import asg4.MyUtils;

public class Lab6Test 
{
	public static void main(String[] args) {
		CreditCardAccountList myList = new CreditCardAccountListImpl();
		CreditCardAccount act1 = new CreditCardAccount();
		int totalSuccess=0;
		int totalTest=0;
		int correct=0;
		Scanner in = null;
		PrintWriter out = null;
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
		String fileName="emptyfile.txt";
		try {
		out = new PrintWriter(new File(fileName));
		System.out.println("SUCCESS opened file " + fileName + " for output");
		totalSuccess++;
		}catch(FileNotFoundException e) {
		System.out.println("FAILURE cannot open file " + fileName + " for output "
		+ " EXIT ON FAILURE TO OPEN FILE");
		System.exit(0);
		}
		CreditCardAccountListUtilsImpl.writeToFile(out, myList);
		out.close();
		totalTest++;
		try {
		in = new Scanner(new File(fileName));
		System.out.println("SUCCESS opened file " + fileName + " for input");
		totalSuccess++;
		}catch(FileNotFoundException e) {
		System.out.println("FAILURE cannot open file " + fileName + " for input" +
		" EXIT ON FAILURE TO OPEN FILE");
		System.exit(0);
		}
		CreditCardAccountListUtilsImpl.readFromScanner(in, myList);
		in.close();
		size = myList.getSize();
		totalTest++;
		if(size == 0)
		{
		totalSuccess++;
		System.out.println("SUCCESS, list should have a size of " + size);
		}
		else
		System.out.println("FAILURE, list should have a size of " + 0);
		in = null;
		fileName="creditcardaccount.txt";
		totalTest++;
		try {
		in = new Scanner(new File(fileName));
		System.out.println("SUCCESS opened file " + fileName + " for input");
		totalSuccess++;
		}catch(FileNotFoundException e) {
		System.out.println("FAILURE cannot open file " + fileName + " for input" +
		" EXIT ON FAILURE TO OPEN FILE");
		System.exit(0);
		}
		CreditCardAccountListUtilsImpl.readFromScanner(in, myList);
		in.close();
		size = myList.getSize();
		correct = 5;
		totalTest++;
		if(size == correct)
		{
		totalSuccess++;
		System.out.println("SUCCESS, list should have a size of " + size);
		}
		else
		System.out.println("FAILURE, list should have a size of " + correct);
		totalTest++;
		fileName="out4.txt";
		try {
		out = new PrintWriter(new File(fileName));
		System.out.println("SUCCESS opened file " + fileName + " for output");
		totalSuccess++;
		}catch(FileNotFoundException e) {
		System.out.println("FAILURE cannot open file " + fileName + " for output " +
		" EXIT ON FAILURE TO OPEN FILE");
		System.exit(0);
		}
		CreditCardAccountListUtilsImpl.writeToFile(out, myList);
		out.close();
		totalTest++;
		try {
		in = new Scanner(new File(fileName));
		System.out.println("SUCCESS opened file " + fileName + " for input");
		totalSuccess++;
		}catch(FileNotFoundException e) {
		System.out.println("FAILURE cannot open file " + fileName + " for input" +
		" EXIT ON FAILURE TO OPEN FILE");
		System.exit(0);
		}
		CreditCardAccountListUtilsImpl.readFromScanner(in, myList);
		in.close();
		size = myList.getSize();
		totalTest++;
		correct=5;
		if(size == correct)
		{
		totalSuccess++;
		System.out.println("SUCCESS, list should have a size of " + size);
		}
		else
		System.out.println("FAILURE, list should have a size of " + correct);
		fileName="creditcardaccount2.txt";
		totalTest++;
		try {
		in = new Scanner(new File(fileName));
		System.out.println("SUCCESS opened file " + fileName + " for input");
		totalSuccess++;
		}catch(FileNotFoundException e) {
		System.out.println("FAILURE cannot open file " + fileName + " for input" +
		" EXIT ON FAILURE TO OPEN FILE");
		System.exit(0);
		}
		CreditCardAccountListUtilsImpl.readFromScanner(in, myList);
		in.close();
		size = myList.getSize();
		totalTest++;
		correct=15;
		if(size == correct)
		{
		totalSuccess++;
		System.out.println("SUCCESS, list should have a size of " + size);
		}
		else
		System.out.println("FAILURE, list should have a size of " + correct);
		totalTest++;
		fileName="out4a.txt";
		try {
		out = new PrintWriter(new File(fileName));
		System.out.println("SUCCESS opened file " + fileName + " for output");
		totalSuccess++;
		}catch(FileNotFoundException e) {
		System.out.println("FAILURE cannot open file " + fileName + " for output " +
		" EXIT ON FAILURE TO OPEN FILE");
		System.exit(0);
		}
		CreditCardAccountListUtilsImpl.writeToFile(out, myList);
		out.close();
		totalTest++;
		try {
		in = new Scanner(new File(fileName));
		System.out.println("SUCCESS opened file " + fileName + " for input");
		totalSuccess++;
		}catch(FileNotFoundException e) {
		System.out.println("FAILURE cannot open file " + fileName + " for input" +
		" EXIT ON FAILURE TO OPEN FILE");
		System.exit(0);
		}
		CreditCardAccountListUtilsImpl.readFromScanner(in, myList);
		in.close();
		size = myList.getSize();
		totalTest++;
		correct=15;
		if(size == correct)
		{
		totalSuccess++;
		System.out.println("SUCCESS, list should have a size of " + size);
		}
		else
		System.out.println("FAILURE, list should have a size of " + correct);
		System.out.println("List after final read \n" +myList);
		if(totalTest == totalSuccess)
		{
		System.out.println("SUCCESS All " + totalSuccess + " tests pass out of " + totalTest + " total tests.");
		}
		else
		{
		System.out.println("FAILURES " + totalSuccess + " pass out of " + totalTest + " tests.");
		}
		}//end of main
	

}
