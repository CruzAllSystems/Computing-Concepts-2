package asg6;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public interface QueueEngine 
{
	//max size used by default if none given.
    public static final int DEFAULT_MAX_SIZE = 4;
    //pre: none
	// post: attempt to add to current queue, records result of attempt
	//       if current queue is full records that information
	public void add(String element);
	//pre: none
	// post:  attempt to remove from current queue is made, records result of attempt.
	//        if queue is empty, records that outcome.
	 public void remove();
	// pre: none
	// post:  records result of item at front of this queue, if there is such an item
	public void showFront();
	//pre: none
	//post: returns current queue's size
	public int getSize();
	//pre: none
	// post: records size of current queue
	public void showSize();
    //pre: none
	// post: returns max size of current queue
	public int getMaxSize();
	//pre: none
	//post: records max size of current queue
	public void showMaxSize();
	// pre: none
	// post:  rear (or last) item in Queue recorded, if queue is empty records that
	public void showRear();
	//pre:  none
	//post: records outcome of test for empty on current queue 
	public void testEmpty();
	//pre:  none
	//post: records outcome of test for full on current queue
	public void testFull();
	// pre: none
	// post: clears current queue and records that outcome
	public void clear();
	
	//retrieves current recorded text for use in gui display, last method called is currently recorded
	// and returned by this method
	public String getActionText();
	
	// EVENT CHANGES
	// boiler plate standard methods for use with a model - adds change listener instance to this model's listener list
	public void addChangeListener(ChangeListener stackEngineListener);
	// removes change listener from this model's listener list.
	public void removeChangeListener(ChangeListener stackEngineListener);
	// raises or fires off a change event so that any listeners can hear it and thus update their situation (ie the view)
	public void fireChangeEvent(ChangeEvent event);

}
