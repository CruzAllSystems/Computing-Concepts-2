package asg5;
import java.util.*;
import utils.MyUtils;

public class TransactionListImpl implements TransactionList 
{
	private int count;
	private Node<Transaction> first;
	
	public TransactionListImpl()//default constructor
	{
		this.count = 0;
		this.first = null;
		
	}//end of the default constructor
	
	//pre: none
	//post: Returns the current TransactionList instance in a readable format with one Transaction instance 
	//per line
	public String toString()
	{
		String temp = "";
		
		if(this.getSize() == 0)
			return "This list is empty.";
		
		for(Node<Transaction> node = this.first; node != null; node = node.link)
			temp += node.data + "\n";
			
		return temp;
		
	}//end of the toString method
	
	//pre: none
	//post: returns the current size of the list
	public int getSize() {return this.count;}

	//pre: none
	// post: adds transaction if its not already in the transaction list (equals is overloaded) returns
	//    true if added, false if already in list
	public boolean add(Transaction transaction) 
	{
		if(this.contains(transaction))
			return false;
		
		Node<Transaction> node = new Node<Transaction>(transaction);
		
		node.link = this.first;
		this.first = node;
		this.count++;
		return true;
		
	}//end of the add method

	//pre: none
	//post: returns actual transaction from list if it equals given transaction, removes it from the list
	//returns null otherwise
	public Transaction remove(Transaction transaction) 
	{
		Node<Transaction> current = this.first;
		Node<Transaction> previous = null;
		
		while(current != null)
		{
			if(current.data.equals(transaction))
				break;
			
			previous = current;
			current = current.link;
				
		}//end of the index while
		
		if(current == null)
			return null;
		
		if(previous == null)
			this.first = current.link;
		else
			previous.link = current.link;
		
		this.count--;
		return current.data;
		
	}//end of the remove method

	//pre: none
	//post: returns true if the given transaction is in the list, false if not (equals is overloaded)
	public boolean contains(Transaction transaction) 
	{
		Node<Transaction> current = this.first;
		
		while(current != null)
		{
			if(current.data.equals(transaction))
				return true;
			
			current = current.link;
			
		}//end of the index while
		
		return false;
		
	}//end of the contains method

	//pre: none
	//post: returns transaction at given position in list,
	//returns null if position < 0 or position >= size of the list.
	public Transaction get(int position) 
	{
		if(position < 0 || position >= this.getSize())
			return null;
		
		int thePos = 0;
		Node<Transaction> current = this.first;
		
		while(current != null)
		{
			if(thePos == position)
				return current.data;
			
			current = current.link;
			thePos++;
			
		}//end of index while
		
		return null;
		
	}//end of the get method

	//pre: none
	//post: returns position of given transaction in list if there,
	//returns -1 if given transaction is not in the list, uses equals
	public int find(Transaction transaction) 
	{
		if(this.contains(transaction))
		{
			for(int index = 0; index < this.getSize(); index++)
				if(this.get(index).equals(transaction))
					return index;
			
		}
		
		return -1;
		
	}//end of the find method

	//pre: none
	//post: returns a string of all transactions in list that have given date
	//a newline separates each transaction
	//returns an empty string if no transactions occurred on given date
	public String getAllTransactionsByDate(String date) 
	{
		GregorianCalendar aDate = MyUtils.stringToDate(date);
		String temp = "";
		Node<Transaction> current = this.first;
		
		while(current != null)
		{
			if(current.data.getDateCalendar().equals(aDate))
				temp += current.data + "\n";
			
			current = current.link;
			
		}//end of the index while
		
		
		return temp;
		
	}//end of the getAllTransactionsByDate method

	//pre: none
	//post: returns a string of all transactions in list that have given payee
	//a newline separates each transaction
	//returns an empty string if no transactions found for given payee
	public String getAllTransactionsByPayee(String payee) 
	{
		String temp = "";
		Node<Transaction> current = this.first;
		
		while(current != null)
		{
			if(current.data instanceof AccountCharge)
			{
				AccountCharge charge1 = (AccountCharge) current.data;
				
				if(charge1.getPayee().equals(MyUtils.properCase(payee)))
					temp += charge1 + "\n";
				
			}
				
			
			current = current.link;
			
		}//end of the index while
		
		return temp;
		
	}//end of the getAllTransactionsByPayee method
	

}//end of the TransactionListImpl Class
