package asg6;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.EventListenerList;

public class QueueEngineImpl implements QueueEngine
{
	private QueueList <String> queue;
	private String actionText;
	private EventListenerList eventListenerList;
	private final ChangeEvent CHANGE_EVENT = new ChangeEvent(this);

	//default constructor that sets the maxSize of the model queue to DEFAULT_MAX_SIZE from interface
	public QueueEngineImpl()
	{
		this.queue = new QueueListImpl<String>(QueueEngine.DEFAULT_MAX_SIZE);
		this.actionText = "New Queue created - currently empty, max size = 4";
		this.eventListenerList = new EventListenerList();  // create the listener list so we can add listeners to the model
	}
	// constructor that receives a maxSize for the queue model
	public QueueEngineImpl(int maxSize)
	{
		this.queue = new QueueListImpl<String>(maxSize);
		this.actionText = "New Queue created - currently empty, max size = " + maxSize;
		this.eventListenerList = new EventListenerList();  // create the listener list so we can add listeners to the model
	}
	
	//as expected, override of toString() so that we can see the current engine's status
	public String toString()
	{
		String temp = this.queue.toString();
		actionText = "Current contents of queue\n" + temp + "\n";
		return temp;
	}

	//pre: none
	// post: current queue has 1 or more element on it if it is not full
	//       if current stack is full, no changes made, sets actionText appropriately
	public void add(String element)
	{
		if(queue.isFull())
			this.actionText = "Cannot add -- queue is full.";
		else
		{
			queue.add(element);
			this.actionText = "ADD " + element + "to Queue\n";
		}
		this.fireChangeEvent(CHANGE_EVENT);

	}
	@Override
	public void remove() 
	{
		if(queue.isEmpty())
			this.actionText = "Cannot remove -- queue is empty.";
		else
		{
			String res = queue.remove();
			this.actionText = "REMOVED: " + res + " from queue\n";
		}
		this.fireChangeEvent(CHANGE_EVENT);
	}

	// pre: none
	// post:  current Queue is popped and value returned, if stack is empty no pop occurs and actionText states that
	//        otherwise actionText contains result of pop and current stack contents
	public void showFront()
	{
		String temp = queue.getFront();
		
		this.actionText = temp + " is at the front of the queue.\n";

	}
	//pre: none
	// post: returns size of current stack 
	public void showSize()
	{
		String temp = "" + this.getSize();
		actionText = temp;


	}
	//pre: none
	// post: returns max size for current stack 
	public int getSize()
	{
		return queue.getSize();
	}
	//pre: none
	// post: returns max size for current stack 
	public int getMaxSize()
	{
		return queue.getMaxSize();
	}
	//pre: none
	// post: returns max size for current stack 
	public void showMaxSize()
	{
		int retValue=queue.getMaxSize();
		actionText = "Current size of Queue: " + retValue;

	}
	// pre: none
	// post:  front (or first) item in Queue returned, if queue is empty actionText states that
	//        otherwise actionText contains result of peek and current stack contents
	public void showRear() 
	{
		String temp = queue.getRear();
		actionText = temp + " is at the rear of the queue.";
	}
	//pre:  none
	//post: returns true if the current stack is empty false if its not.
	public void  testEmpty()
	{
		String msg = "";
		if(queue.isEmpty()) 
			msg="empty";
		else
			msg = "NOT empty";
		actionText = "Current queue is " + msg + "\n" ;

	}
	//pre:  none
	//post: returns true if the current stack is full false if its not.
	public void testFull()
	{
		String msg = "";
		if(queue.isFull()) 
			msg="full";
		else
			msg = "NOT full";
		actionText = "Current queue is " + msg + "\n" ;

	}
	// pre: none
	// post: current stack is empty
	public void clear()
	{
		queue.clear();
		this.actionText = "Queue has been cleared.";
		this.fireChangeEvent(CHANGE_EVENT);
		
	}

	public String getActionText()
	{
		return this.actionText;
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
		for (int i = listeners.length-2; i>=0; i-=2) 
		{
			if (listeners[i]==ChangeListener.class) 
			{
				((ChangeListener)listeners[i+1]).stateChanged(changeEvent);
			}
		}

	}


}
