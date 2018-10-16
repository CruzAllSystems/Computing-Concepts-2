package asg4;

public class CreditCardAccount 
{
	//attributes/fields
			private int accountNumber;
			private String firstName;
			private String lastName;
			private double balance;
			
			//default constructor
			//sets string attribute to $$$$ by default and sets balance and account number to a value of 0.
			public CreditCardAccount()
			{
				this.setAccountNumber(0);
				this.setFirstName("$$$$");
				this.setLastName("$$$$");
				this.setBalance(0.0);
				
			}//end of the default constructor
			
			//parameter constructor
			//assigns each attribute given values by the test program
			public CreditCardAccount(int a, String l, String f, double b)
			{
				this.setAccountNumber(a);
				this.setFirstName(f);
				this.setLastName(l);
				this.setBalance(b);
				
			}//end of the parameter constructor
			
			//accessor methods
			//returns the attribute of the current CreditCardAccount instance
			public int getAccountNumber(){return this.accountNumber;}
			public String getFirstName(){return this.firstName;}
			public String getLastName(){return this.lastName;}
			public double getBalance(){return this.balance;}
			
			//modifier methods
			//assigns given values to the current instance attributes, provided they fit the given parameters 
			public void setAccountNumber(int thisAccount)
			{
				if(thisAccount < 0)
					this.accountNumber = 0;
				else
					this.accountNumber = thisAccount;
				
			}//end of the account number modifier
			
			public void setFirstName(String thisName)
			{
				thisName = thisName.trim();
				if(thisName.equals(""))
					this.firstName = "$$$$";
				else
				{
					this.firstName = MyUtils.properCase(thisName);
					
				}
				
			}// end of the first name modifier

			public void setLastName(String thisName)
			{
				thisName = thisName.trim();
				if(thisName.equals(""))
					this.lastName = "$$$$";
				else
				{
					this.lastName = MyUtils.properCase(thisName);
					
				}
				
			}//end of the last name modifier
			
			public void setBalance(double thisBalance)
			{
				this.balance = thisBalance;
				
			}//end of the balance modifier
			
			//toString method
			//returns a concise output of the properties of the current CreditCardAccount instance
			
			public String toString()
			{
				String temp = "";
				
				temp += "Account Number: " + this.getAccountNumber() + " "
						+ this.getLastName() + ", " + this.getFirstName()
						+ " Balance: " + this.getBalance();
				
				return temp;
				
				
			}//end of the toString method
		

}//end of the CreditCardAccount class
