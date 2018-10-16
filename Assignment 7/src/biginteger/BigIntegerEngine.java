package biginteger;
import javax.swing.event.*;
import java.util.*;

public interface BigIntegerEngine 
{
	// Note: this engine keeps the sum updated at all times as operands are modified
	  public static final int MAX_OPERANDS = 4;  // maximum number of values being added

	  //pre: none
	  // post: all operands, from 1 to MAX_OPERANDS are set to "0"
	  public void clearOperands();

	  //pre: 1 <= operandNumber <= MAX_OPERANDS
	  //post: returns a text string of given operandNumber,
	  //returns empty string if operandNumber is invalid
	  public String getOperand(int operandNumber);

	  //pre: operandNumber>=1 and operandNumber <= MAX_OPERANDS
	  //post: operandNumber given is set to operandValue if both operandValue is a valid integer string and 
	  //      operandNumber is in range 1 to MAX_OPERANDS inclusive.
	  //      returns false if either argument is invalid and does not set anything.
	  public boolean setOperand(int operandNumber, String operandValue );

	  //pre: none
	  //post: returns the current sum of all operands
	   public String getSum();
	  
	 
	  // EVENT CHANGES
	  // boiler plate standard methods for use with a model - adds change listener instance to this model's listener list
	  public void addChangeListener(ChangeListener stackEngineListener);

	  // removes change listener from this model's listener list.
	  public void removeChangeListener(ChangeListener stackEngineListener);

	  // raises or fires off a change event so that any listeners can hear it and thus update their situation (ie the view)
	  public void fireChangeEvent(ChangeEvent event);

}
