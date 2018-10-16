package asg5;
import java.text.DecimalFormat;
import java.util.GregorianCalendar;
import utils.MyUtils;

public abstract class Transaction implements Comparable <Transaction>
{
	public static final String DEFAULT_TRANSACTION_ID = "******";
	private GregorianCalendar date;
	private double amount;
	private String transactionId;

	//default constructor assigns defaults
	public Transaction()
	{
		this.setDate("1/1/2000");
		this.setAmount(0.0);
		this.setTransactionId(DEFAULT_TRANSACTION_ID);

	}
	//constructor that receives all attributes to place into instance
	public Transaction( String theDate, double theAmount, String theTransactionId)
	{
		this.setDate(theDate);
		this.setAmount(theAmount);
		this.setTransactionId(theTransactionId);
	}

	//pre: none
	//post: returns a textual string representing this Transaction
	public String toString()
	{
		String temp = "";
		DecimalFormat df = new DecimalFormat("0.00");
		temp +=  this.getDateString() + " " +
				this.getTransactionId() + " " +
				df.format(this.getAmount()) ; 

		return temp;

	}
	//pre:  none                                                                                       
	//post: returns the id of the transaction
	public String getTransactionId()
	{
		return this.transactionId;
	}
	//pre: none                                                                                        
	//post: returns the date                                                
	public GregorianCalendar getDateCalendar()
	{
		return this.date;
	}

	//pre: none                                                                                        
	//post: returns the date in format mm/dd/yyyy as a String                                                     
	public String getDateString()
	{
		return MyUtils.dateToString(date);
	}
	//pre: none                                                                                        
	//post: returns the amount                                                      
	public double getAmount()
	{
		return this.amount;
	}

	//pre:none                          
	//post: theDate is stored as given date 
	// if theDate has any invalid parts, uses default date (1/1/2000)
	public void setDate(String theDate)
	{
		this.date = MyUtils.stringToDate(theDate);
	}
	//pre: none                                                                                        
	//post: theAmount stored into this transaction                                                     
	public void setAmount(double theAmount)
	{
		this.amount = theAmount;
	}
	//pre: none
	//post: sets given theTransactionId after formatting
	//    if empty or invalid id string received, uses DEFAULT
	public void setTransactionId(String theTransactionId)
	{
		String result = MyUtils.stripNonAlpha(theTransactionId, 6);
		if(result.equals(""))
			result = DEFAULT_TRANSACTION_ID;// our Default transaction
		this.transactionId = result;
	}

	// compares dates, then transactionIds, then amounts 
	//returning expected less than 0, 0 or greater than 0 acc'd to attributes
	public int compareTo(Transaction transaction)
	{
		int result = this.getDateCalendar().compareTo(transaction.getDateCalendar());
		if(result == 0)
			result = this.getTransactionId().compareTo(transaction.getTransactionId());
		if(result == 0)// both date and transactionId still match
		{
			if(this.getAmount() < transaction.getAmount())
				result = -1;
			else if (this.getAmount() > transaction.getAmount())
				result = 1;
		}
		return result;
	}
	// override of equals, all inheriting classes inherit this unless overridden 
	// by inheriting class
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
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

		return true;
	}
	// expected override since equals is overridden
	// override of hashCode, all inheriting classes inherit this unless overridden 
	// by inheriting class
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getDateCalendar() == null) ? 0 : this.getDateCalendar().hashCode());
		result = prime * result
				+ ((getTransactionId() == null) ? 0 : getTransactionId().hashCode());
		result = prime * result
				+ ((int)getAmount() );
		return result;
	} 


}
