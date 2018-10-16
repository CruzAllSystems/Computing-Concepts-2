package asg5;
import java.util.*;
import java.text.*;
import utils.MyUtils;

public class AccountCharge extends Transaction
{
private String payee;
	
	//default constructor
	public AccountCharge()
	{
		super();
		this.setPayee("$$$$");
		
	}//end of the default constructor
	
	//parameter constructor
	public AccountCharge(String theDate, double theAmount, String theTransactionId, String tePayee)
	{
		super(theDate,theAmount,theTransactionId);
		this.setPayee(tePayee);
		
	}//end of the parameter constructor
	
	public void setPayee(String tePayee)
	{
		if(tePayee.equals(""))
			this.payee = "$$$$";
		else
			this.payee = MyUtils.properCase(tePayee);
		
	}//assigns payee the value indicated by tePayee
	public String getPayee(){return this.payee;}//returns the current value of payee
	
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
	        AccountCharge other = (AccountCharge) obj;
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
		if (!this.getPayee().equals(other.getPayee()))
			return false;

	        return true;
	        
	}//end of the equals method
	
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
				+ ((getPayee() == null) ? 0 : getPayee().hashCode());
		return result;
		
	}//end of hashcode 
	
	//pre: none
	//post: Returns a formated string indicating all values of the current AccountCharge instance in one line
	public String toString()
	{
		
		String temp = super.toString();
		temp += " " + this.getPayee();
		return temp;
		
	}//end of the toString method

	

}//end of the AccountCharge class
