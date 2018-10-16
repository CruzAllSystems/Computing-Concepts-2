package asg4;

public class CreditCardAccountListImpl implements CreditCardAccountList
{
	private CreditCardAccount [] myList;
	private int count;
	
	//default constructor
	//assigns myList it's set maximum size as set by CreditCardList interface, and assigns count a value of 0.
	public CreditCardAccountListImpl()
	{
		this.myList = new CreditCardAccount[CreditCardAccountList.MAX_SIZE];
		this.count = 0;
		
	}//end of the default constructor

	//pre: none
	//post: Returns the number of Credit Card Accounts in the list
	public int getSize() 
	{
		return this.count;
		
	}//end of the get Size method

	//pre: none
	//post: returns true if a CreditCardAccount that shares the account number of the given CreditCardAccount is in this list.
	//returns false otherwise.
	public boolean contains(CreditCardAccount creditcardaccount) 
	{
		for(int index = 0; index < this.getSize(); index++)
			if(creditcardaccount.getAccountNumber() == this.myList[index].getAccountNumber())
				return true;
		
		return false;
		
	}//end of the contains method

	//pre: none
	//post: creditcardaccount is added to this list if not already there (account numbers must be unique)
	//returns true if creditcardaccount was added successfully, false if no room or duplicate account number found in list
	public boolean add(CreditCardAccount creditcardaccount) 
	{
		if(this.getSize() == CreditCardAccountList.MAX_SIZE)
			return false;
		if(this.contains(creditcardaccount))
			return false;
		
		this.myList[this.count] = creditcardaccount;
		this.count++;
		
		return true;
		
	}//end of the add method

	//pre: 0 <= position < getSize()
	//post: returns the creditcardaccount in the list at the given position, accounts are not necessarily sorted.
	//uses zero-based positions, so 0 is the position of the first account in the list
	//returns null if the given position is out of range according to precondition
	public CreditCardAccount get(int position) 
	{
		if(position < 0 || position >= CreditCardAccountList.MAX_SIZE)
			return null;
		
		return this.myList[position];
		
	}//end of the get method

	//pre: none
	//post: returns the position of creditcardaccount in the list (uses account number when matching)
	//returns -1 if creditcardaccount is not found in current list at any position
	//-1 <= returnvalue < getSize()
	public int find(CreditCardAccount creditcardaccount) 
	{
		for(int index = 0; index < this.getSize(); index++)
			if(creditcardaccount.getAccountNumber() == myList[index].getAccountNumber())
				return index;
		
		return -1;
		
	}//end of the find method

	//pre: none
	//post: returns a String containing a list (1 credit card account per line) of credit card accounts
	//that have a balance OVER the given balance.
	//returns an EMPTY String if NO accounts are over the given balance
	public String getCreditCardAccountsWithBalanceOver(double theBalance) 
	{
		String temp = "";
		
		for(int index = 0; index < this.getSize(); index++)
			if(this.myList[index].getBalance() > theBalance)
				temp += this.myList[index] + "\n";
		
		return temp;
	}//end of the get credit card accounts with an over balance method

	//pre:  none
	//post: returns a String containing a list (1 credit card account per line) of credit card accounts
	//that have a balance that is less than 0.0  (outstanding balance is a credit if LESS THAN 0.0)
	// returns an EMPTY String if NO accounts in the list have a credit (balance below 0.0).
	public String getCreditCardAccountsWithCreditBalance() 
	{
		String temp = "";
		
		for(int index = 0; index < this.myList.length; index++)
			if(this.myList[index].getBalance() < 0.0)
				temp += this.myList[index];
		
		
		return temp;
		
	}//end of the getCreditCardAccountsWithCreditBalance method

	
	public String getCreditCardAccountsWithMatchingLastName(String theName) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public String getCreditCardAccountsWithMatchingFirstName(String theName) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void sort() {
		// TODO Auto-generated method stub
		
	}

	
	public CreditCardAccount remove(CreditCardAccount creditcardaccount) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//toString method
	//Returns a formatted list of CreditCardAccount instances with one on each line.
	public String toString()
	{
		String temp = "";
		if(this.getSize() == 0)
			return "The list is empty.";
		
		for(int index = 0; index < this.getSize(); index++)
			temp+= myList[index] + "\n";
		
		return temp;
		
	}//end of the to String method
	

}//end of the CreditCardAccountListImpl class
