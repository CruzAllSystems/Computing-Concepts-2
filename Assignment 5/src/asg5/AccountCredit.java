package asg5;
import java.util.*;
import java.text.*;
import utils.MyUtils;

public class AccountCredit extends Transaction
{
	private String creditor;
	private CreditCode code;
	
	//default constructor
	public AccountCredit()
	{
		super();
		this.setCreditor("$$$$");
		this.setCreditCode(CreditCode.OTHER);
		
	}//end of the default constructor
	
	//parameter constructor
	public AccountCredit(String theDate, double theAmount, String theTransactionId, String theCreditor, CreditCode theCode)
	{
		super(theDate,theAmount,theTransactionId);
		this.setCreditor(theCreditor);
		this.setCreditCode(theCode);
		
		
	}//end of the parameter constructor
	
	//modifier methods
	//Assigns the attributes the value indicated
	public void setCreditor(String theCreditor)
	{
		if(theCreditor.equals(""))
			this.creditor = "$$$$";
		else
			this.creditor = MyUtils.properCase(theCreditor);
		
	}
	public void setCreditCode(CreditCode theCode){this.code = theCode;}
	
	//Accessor methods
	//Returns the current value of each attribute 
	public String getCreditor(){return creditor;}
	public CreditCode getCreditCode(){return code;}
	
	// override of equals, all inheriting classes inherit this unless overridden 
	// by inheriting class
	public boolean equals(Object obj) 
	{
		if (this == obj)
	            return true;
		if (obj == null)
		   return false;
		if (getClass() != obj.getClass())
		   return false;
	        AccountCredit other = (AccountCredit) obj;
		if (this.getDateCalendar() == null) 
	        {
			if (other.getDateCalendar() != null)
				return false;
		} 
	        else if (!this.getDateCalendar().equals(other.getDateCalendar()))
			return false;
		if (this.getTransactionId() == null) 
	        {
		        if (other.getTransactionId() != null)
				return false;
		} 
	        else if (!this.getTransactionId().equals(other.getTransactionId()))
			return false;
		if(this.getAmount()>other.getAmount() || this.getAmount() < other.getAmount())
	        {
		   return false;
	        }	
		
		if (this.getCreditCode() == null) 
        {
		if (other.getCreditCode() != null)
			return false;
	} 
        else if (!this.getCreditCode().equals(other.getCreditCode()))
		return false;
		
		if (!this.getCreditor().equals(other.getCreditor()))
			return false;
		

	        return true;
	        
	}//end of equals method
	
	// expected override since equals is overridden
	// override of hashCode, all inheriting classes inherit this unless overridden 
	// by inheriting class
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getDateCalendar() == null) ? 0 : this.getDateCalendar().hashCode());
		result = prime * result
				+ ((getTransactionId() == null) ? 0 : getTransactionId().hashCode());
		result = prime * result
				+ ((int)getAmount() );
		result = prime * result
				+ ((getCreditor() == null) ? 0 : getCreditor().hashCode());
		result = prime * result
				+ ((getCreditCode() == null) ? 0 : getCreditCode().hashCode());
		
		return result;
		
	}//end of hashcode 
	
	//pre: none
	//post: Returns a formated string indicating all values of the current AccountCredit instance in one line
	public String toString()
	{
		String temp = super.toString();
		
		temp += " " + this.getCreditor() + " " + this.getCreditCode();
		
		return temp;
		
	}//end of the toString method
	

}//end of the AccountCredit class

