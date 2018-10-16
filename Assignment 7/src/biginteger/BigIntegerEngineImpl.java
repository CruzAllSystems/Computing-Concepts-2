package biginteger;
import javax.swing.event.*;
import java.util.*;

public class BigIntegerEngineImpl implements BigIntegerEngine
{
	private String sum;
	private ArrayList<String> operands;
	private EventListenerList eventListenerList;
	private final ChangeEvent CHANGE_EVENT = new ChangeEvent(this);
	
	public BigIntegerEngineImpl()
	{
		this.operands = new ArrayList<String>(BigIntegerEngine.MAX_OPERANDS);
		
		for(int index = 0; index < BigIntegerEngine.MAX_OPERANDS; index++)
			this.operands.add("0");
		
		this.add();
		
		this.eventListenerList = new EventListenerList();
		
	}//end of the default constructor
	
	public BigIntegerEngineImpl(int theOperands)
	{
		this.operands = new ArrayList<String>(theOperands);
		
		for(int index = 0; index < theOperands; index++)
			this.operands.add("0");
		
		this.add();
		
		this.eventListenerList = new EventListenerList();
		
	}//end of the default constructor
	
	public String toString()
	{
		String temp = "";
		for(int index = 0; index < this.operands.size(); index++)
			temp += this.operands.get(index) + "\n";
		return temp;
		
	}//end of the toString method
	
	//pre: none
	//post: Generates the sum of all operands in the operands list and assigns that value to the variable sum
	private void add()
	{
		String total = "0";
		
		for(int index = 0; index < operands.size(); index++)
			total = this.add2(total,operands.get(index));
		
		this.sum = total;
		
	}//end of the add method
	
	//pre: total and theOperand are both valid Strings consisting of all digits
	//post: Adds together total and theOperand to generate a new total to be used in later calculations 
	private String add2(String total, String theOperand)
	{
		StackList<Integer> totalStack = new StackListImpl<Integer>(1000000);
		StackList<Integer> operandStack = new StackListImpl<Integer>(1000000);
		StackList<Integer> answerStack = new StackListImpl<Integer>(1000000);
		String answer = "";
		int carry = 0;
		int x1 = 0;
		int x2 = 0;
		int sum = 0;
		int digit = 0;
		
		for(int index = 0; index < total.length(); index++)
			totalStack.push(Character.digit(total.charAt(index), 10));
		
		for(int index = 0; index < theOperand.length(); index++)
			operandStack.push(Character.digit(theOperand.charAt(index), 10));
		
		while(!totalStack.isEmpty() && !operandStack.isEmpty())
		{
			
			x1 = totalStack.pop();
			x2 = operandStack.pop();
			sum = x1 + x2 + carry;
			carry = sum / 10;
			digit = sum % 10;
			answerStack.push(digit);
			
		}//end pathway 1
		
		while(!totalStack.isEmpty() && operandStack.isEmpty())
		{
			
			x1 = totalStack.pop();
			sum = x1 + carry;
			carry = sum / 10;
			digit = sum % 10;
			answerStack.push(digit);
			
		}//end pathway 2
		
		while(totalStack.isEmpty() && !operandStack.isEmpty())
		{
			
			x2 = operandStack.pop();
			sum = x2 + carry;
			carry = sum / 10;
			digit = sum % 10;
			answerStack.push(digit);
			
		}//end pathway 3
		
		if(carry == 1)
			answerStack.push(carry);
		
		int size = answerStack.getSize();
		
		for(int index = 0; index < size; index++)
			answer += answerStack.pop();
		
		
		return answer;
		
	}//end of the add2 method

	//pre: none
	// post: all operands, from 1 to MAX_OPERANDS are set to "0"
	public void clearOperands() 
	{
		for(int index = 0; index < this.operands.size(); index++)
			this.operands.set(index,"0");
		
		this.add();
		
		this.fireChangeEvent(CHANGE_EVENT);
		
	}//end of the clearOperands method

	//pre: 1 <= operandNumber <= MAX_OPERANDS
	//post: returns a text string of given operandNumber,
	//returns empty string if operandNumber is invalid
	public String getOperand(int operandNumber) 
	{
		if(operandNumber < 1 || operandNumber > this.operands.size())
			return "";
		
		int index = operandNumber - 1;
		
		return this.operands.get(index);
		
	}//end of the getOperand method

	//pre: operandNumber>=1 and operandNumber <= MAX_OPERANDS
	//post: operandNumber given is set to operandValue if both operandValue is a valid integer string and 
	//      operandNumber is in range 1 to MAX_OPERANDS inclusive.
	//      returns false if either argument is invalid and does not set anything.
	public boolean setOperand(int operandNumber, String operandValue) 
	{
		if(operandNumber < 1 || operandNumber > this.operands.size() || operandValue.equals(""))
			return false;
		for(int index = 0; index < operandValue.length(); index++)
			if(!Character.isDigit(operandValue.charAt(index)))
				return false;
		
		int index = operandNumber -1;
		operands.set(index, operandValue);
		this.add();
		this.fireChangeEvent(CHANGE_EVENT);
		return true;
		
	}//end of the setOperand method

	//pre: none
	//post: returns the current sum of all operands
	public String getSum() 
	{
		return this.sum;
		
	}//end of the getSum method

	// EVENT CHANGES
	// boiler plate standard methods for use with a model - adds change listener instance to this model's listener list
	public void addChangeListener(ChangeListener changeListener) 
	{
		eventListenerList.add(ChangeListener.class, changeListener);
		
	}//end of the addChangeListener method

	// removes change listener from this model's listener list.
	public void removeChangeListener(ChangeListener changeListener) 
	{
		eventListenerList.remove(ChangeListener.class, changeListener);
		
	}//end of the removeChangeListener method

	// raises or fires off a change event so that any listeners can hear it and thus update their situation (ie the view)
	public void fireChangeEvent(ChangeEvent changeEvent) 
	{
		// Guaranteed to return a non-null array
				Object[] listeners = eventListenerList.getListenerList();
				// Process the listeners last to first, notifying
				// those that are interested in this event
				for (int i = listeners.length-2; i>=0; i-=2) 
				{
					if (listeners[i]==ChangeListener.class) 
					{
						((ChangeListener)listeners[i+1]).stateChanged(changeEvent);
					}
				}
		
	}//end of the fireChangeEvent method

	

}//end of the BigIntegerEngineImpl Class
