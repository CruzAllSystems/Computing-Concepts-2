package asg5;

public interface TransactionList 
{
	//pre: none
	  //post: returns the current size of the list
	  public int getSize();

	  //pre: none
	  // post: adds transaction if its not already in the transaction list (equals is overloaded) returns
	  //    true if added, false if already in list
	  public boolean add(Transaction transaction);

	  //pre: none
	  //post: returns actual transaction from list if it equals given transaction, removes it from the list
	  public Transaction remove(Transaction transaction);

	  //pre: none
	  //post: returns true if the given transaction is in the list, false if not (equals is overloaded)
	  public boolean contains(Transaction transaction);

	  //pre: none
	  //post: returns transaction at given position in list,
	  //    returns null if position < 0 or position >= size of the list.
	  public Transaction get(int position);

	  //pre: none
	  //post: returns position of given transaction in list if there,
	  //      returns -1 if given transaction is not in the list, uses equals 
	  public int find(Transaction transaction);

	  //pre: none
	  // post: returns a string of all transactions in list that have given date
	  //  a newline separates each transaction
	  //  returns an empty string if no transactions occurred on given date
	  public String getAllTransactionsByDate(String date);

	  //pre: none
	  // post: returns a string of all transactions in list that have given payee
	  //  a newline separates each transaction
	  //  returns an empty string if no transactions found for given payee
	  public String getAllTransactionsByPayee(String payee);

}//end of the TransactionList interface
