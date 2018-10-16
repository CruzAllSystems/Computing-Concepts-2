package asg6;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.EventListenerList;

public class StackEngineImpl implements StackEngine 
{
	private StackList<String> stack; // one of 2 stacks used in this engine
	private String actionText;
	private EventListenerList eventListenerList;  // stores one or more event listener
	private final ChangeEvent CHANGE_EVENT = new ChangeEvent(this);
	
	// default constructor, builds the stack with default max size of 4
	public StackEngineImpl()
	{
		stack = new StackListImpl<String>(StackEngine.DEFAULT_MAX_SIZE);
		this.eventListenerList = new EventListenerList();
		actionText = "Just constructed a Stack default size (4)";
	}
	public StackEngineImpl(int aMax)
	{
		stack = new StackListImpl<String>(aMax);
		this.eventListenerList = new EventListenerList();
		actionText = "Just constructed a Stack with max size of " + aMax;
	}
	//the expected method for any class, returns a string of
	// the current stack contents 
	public String toString()
	{
		String temp = "";
			temp = stack.toString();
			this.actionText = "Current Stack: \n" + temp + "\n";
		return temp;
	}
	
	public String getActionText()
	{
		return this.actionText;
	}
	
	//pre: stack being pushed is not full
	// post: stack has contents of element on the top
	//       actionText contains information about results.
	public void push(String element) {
	if(stack.isFull())
		this.actionText = "Cannot push, stack is full.";
	else
		{
		  stack.push(element);
		  this.actionText = "PUSH " + element + "\n" + 
				  			"Contents of Stack: \n" + stack.toString();
		}
		this.fireChangeEvent(CHANGE_EVENT);
	}
	//pre: stack is not empty
	// post: returns top element on current stack
	//       actionText contains information about results.
	public  void peek() 
	{
		String temp = stack.peek();
		this.actionText = temp + " is on top of the stack.";
		
	}
	//pre: stack is not empty
	// post: returns AND REMOVES top element on current stack
	//       actionText contains information about results.
	public void pop() {
		String retValue = "";
		if(stack.isEmpty())
		{
			this.actionText = "attempt to pop an empty stack..NOT allowed";

		}
		else
		{	
		retValue = stack.pop();
		this.actionText = "Just popped: " + retValue;
		}
		this.fireChangeEvent(CHANGE_EVENT);
	}
	//pre: none
	// post: number of elements on stack is returned
	public int getSize() {
		int retValue=stack.getSize();
		actionText = "Current size of stack: " + retValue;
		return retValue;
	}
	//pre: none
		// post: returns max size for current stack 
		public int getMaxSize()
		{
			int retValue=stack.getMaxSize();
			actionText = "Current size of stack: " + retValue;
			return retValue;
		}
	//pre: none
	// post: returns true iff the current stack has a size of 0.
	public void testEmpty() {
		
		String msg = "";
		if(stack.isEmpty()) 
			msg="empty";
		else
			msg = "NOT empty";
		actionText = "Current stack is " + msg + "\n" ;
	}
	//pre: none
	// post: returns true if the stack currently has MAX_ELEMENTS on it.
	public void testFull() 
	{
		String msg = "";
		if(stack.isFull()) 
			msg="full";
		else
			msg = "NOT full";
		actionText = "Current stack is " + msg + "\n" ;

	}
	// pre: none
	// post: current stack is empty, size is 0.
	public void clear()
	{
		stack.clear();
		this.actionText = "Stack has been cleared.";
		this.fireChangeEvent(CHANGE_EVENT);
				
	}
	//standard boilerplate method for change events
	public void addChangeListener(ChangeListener changeListener)
	{
		eventListenerList.add(ChangeListener.class, changeListener);
	}
	//standard boilerplate method for change events
	public void removeChangeListener(ChangeListener changeListener)
	{
		eventListenerList.remove(ChangeListener.class, changeListener);
	}
	//standard boilerplate method for change events
	// used when we need to notify the view that a change to the model has taken place
	// so that the view can update itself.
	public void fireChangeEvent(ChangeEvent changeEvent) {
		// Guaranteed to return a non-null array
		Object[] listeners = eventListenerList.getListenerList();
		// Process the listeners last to first, notifying
		// those that are interested in this event
		for (int i = listeners.length-2; i>=0; i-=2) {
			if (listeners[i]==ChangeListener.class) {
				((ChangeListener)listeners[i+1]).stateChanged(changeEvent);
			}
		}
	}


}
