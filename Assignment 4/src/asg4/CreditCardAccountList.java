package asg4;

public interface CreditCardAccountList 
{
	public static final int MAX_SIZE = 15;

	//pre: none
	//post: returns number of CreditCardAccounts currently in the list
	public int getSize();

	 // pre: none
	 // post: returns true if creditcardaccount has an account number that matches another credit card account's number 
	 //        in this list, returns false if not
	 public boolean contains(CreditCardAccount creditcardaccount);
	//pre: none
	//post: creditcardaccount is added to this list if not already there (account numbers must be unique)
	//      returns true if creditcardaccount was added, false if no room or duplicate account number found in list
	public boolean add(CreditCardAccount creditcardaccount);

	//pre: 0 <= position < getSize()
	// post: returns the creditcardaccount in the list at given position, accounts are not necessarily sorted.
	//       uses zero-based positions, so 0 is the position of the first account in the list
	//       returns null if given position is out of range according to precondition
	public CreditCardAccount get(int position);
	
	//pre: none
	// post: returns the position of creditcardaccount in the list (uses account number when matching)
	//       returns -1 if creditcardaccount is not found in current list at any position
	//       -1 <= returnvalue < getSize()
	public int find(CreditCardAccount creditcardaccount);


	//pre: none
	//post: returns a String containing a list (1 credit card account per line) of credit card accounts
	//      that have a balance OVER the given balance.
	//      returns an EMPTY String if NO accounts are over the given balance
	public String getCreditCardAccountsWithBalanceOver(double theBalance);

	//pre:  none
	//post:  returns a String containing a list (1 credit card account per line) of credit card accounts
	//       that have a balance that is less than 0.0  (outstanding balance is a credit if LESS THAN 0.0)
	//       returns an EMPTY String if NO accounts in the list have a credit (balance below 0.0).
	public String getCreditCardAccountsWithCreditBalance();

	//pre: none
	//post: returns a String containing a list (1 credit card account per line) of credit card accounts
        //      with last name matching given name
	//      if no matches exist, returns empty string 
	public String getCreditCardAccountsWithMatchingLastName(String theName);

	//pre: none
	//post: returns a String containing  a list (1 credit card account per line) of credit card accounts
        //       with first name matching given name
	//      if no matches exist, returns empty string
	public String getCreditCardAccountsWithMatchingFirstName(String theName);

	//pre: none
	//post: this CreditCardAccountList is sorted by account number from lowest to highest
	public void sort();

	//pre: none
	//post: if a CreditCardAccount instance  in this list is found that MATCHES the 
        //      given creditcardaccount's account number, 
        //      the CreditCardAccount instance in the list is removed from this list AND RETURNED.  
        //       If no CreditCardAccount is found that has a matching 
        //	 account number, then null is RETURNED
	public CreditCardAccount remove(CreditCardAccount creditcardaccount);

}//end of the CreditCardAccountList Interface
