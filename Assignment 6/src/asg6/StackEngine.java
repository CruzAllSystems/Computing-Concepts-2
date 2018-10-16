package asg6;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public interface StackEngine 
{
	//max size used by default if none given.
    public static final int DEFAULT_MAX_SIZE = 4;
	//pre: none
	// post: if stack is not full pushes element, records result.  If full records that.
	public void push(String element);
	//pre: none
	//pop:  pops stack and records result returned from pop
	public void pop();
	//pre: none
	// post: records size of current stack 
	public int getSize();
	//pre: none
	// post: records max size for current stack 
	public int getMaxSize();
	// pre: none
	// post:  currentStack is peeked at and value recorded, if stack is empty no peek occurs and records that
	//        otherwise records result of peek and current stack contents
	public void peek();
	//pre:  none
	//post: records outcome of testing current stack for empty 
	public  void testEmpty();
	//pre:  none
	//post: records outcomem of testing current stack for full
	public void testFull();
	// pre: none
	// post: empties current stack, records result
	public void clear();
	
	//retrieves recorded message text according to last attempted operation for use in gui display
	public String getActionText();
	// EVENT CHANGES
	// boiler plate standard methods for use with a model - adds change listener instance to this model's listener list
	public void addChangeListener(ChangeListener stackEngineListener);
	// removes change listener from this model's listener list.
	public void removeChangeListener(ChangeListener stackEngineListener);
	// raises or fires off a change event so that any listeners can hear it and thus update their situation (ie the view)
	public void fireChangeEvent(ChangeEvent event);

}
