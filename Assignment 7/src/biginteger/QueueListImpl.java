package biginteger;
import java.util.*;

public class QueueListImpl<T> implements QueueList<T>
{
	private int maxSize;
	private ArrayList<T> queue;
	
	public QueueListImpl()
	{
		this.maxSize = QueueList.DEFAULT_MAX_SIZE;
		queue = new ArrayList<T>(maxSize);
		
	}//end of the default constructor
	
	public QueueListImpl(int theMaxSize)
	{
		if(theMaxSize <= 0)
			this.maxSize = QueueList.DEFAULT_MAX_SIZE;
		else
			this.maxSize = theMaxSize;
		
		queue = new ArrayList<T>(maxSize);
		
	}//end of the parameter constructor
	
	public String toString()
	{
		String temp = "";
		
		for(int index = 0; index < this.queue.size(); index++)
			temp += this.queue.get(index) + "\n";
		
		return temp;
		
	}//end of the toString method

	/** pre: none, tests to see if this QueueList has 0 elements
	 *  post: return true if this QueueList is empty (has 0 elements) false otherwise;
	 */
	public boolean isEmpty() 
	{
		if(this.queue.size() == 0)
			return true;
		
		return false;
		
	}//end of the isEmpty method

	/**pre: none, tests to see if this QueueList is full, 
    full is true if current number of elements in the queue has reached its max allowable size. 
	post: returns true if getSize() has reached getMaxSize(), false if not
	 */  
	public boolean isFull() 
	{
		if(this.queue.size() == this.maxSize)
			return true;
		
		return false;
		
	}//end of the isFull method

	/** pre: none
	 * post: returns  number of elements in this QueueList
	 */
	public int getSize() 
	{
		return this.queue.size();
		
	}//end of the getSize method

	/** pre: none
	 * post: returns max number of elements allowed in this QueueList
	 */
	public int getMaxSize() 
	{
		return this.maxSize;
		
	}//end of the getMaxSize method

	/**
	 *pre: none
	 *post: element is placed at the REAR or END of this QueueList if it is NOT full
	        if this QueueList is full, throws RuntimeException.
	 */
	public void add(T element) 
	{
		if(this.isFull())
			throw new RuntimeException("Attempting to add to a full queue.");
		
		this.queue.add(element);
		
	}//end of the add method

	/** pre: none
	   post: removes and returns the FRONT item from this QueueList if it is NOT empty
	 * @throws - RuntimeException if attempt to remove from an empty QueueList
	 * @return - the object that was removed from the front of this QueueList
	 */
	public T remove() 
	{
		if(this.isEmpty())
			throw new RuntimeException("Attmepting to remove from an empty queue.");
		
		T temp = this.queue.remove(0);
		
		return temp;
		
	}//end of the remove method

	/** pre: none
	  *post: returns the FRONT item from this QueueList if it is
	 * not empty.  DOES NOT REMOVE IT.
	 * @throws - RuntimeException if this QueueList is empty.
	 * @return - object that is currently at the FRONT of this QueueList
	 */
	public T getFront() 
	{
		if(this.isEmpty())
			throw new RuntimeException("Attmepting to access an empty queue.");
		
		return this.queue.get(0);
		
	}//end of the getFront method

	/** pre: none
	  *post: returns the REAR (or last)  item from this QueueList if it is
	 * not empty.  DOES NOT REMOVE IT.
	 * @throws - RuntimeException if this QueueList is empty.
	 * @return - object that is currently at the REAR (or end) of this QueueList
	 */
	public T getRear() 
	{
		if(this.isEmpty())
			throw new RuntimeException("Attmepting to access an empty queue.");
		
		return this.queue.get(this.queue.size() - 1);
		
	}//end of the getRear method

	/** pre: none
    post: removes all items from this QueueList making it empty.
	 */
	public void clear() 
	{
		this.queue.clear();
		
	}//end of the clear method
	
	

}//end of the QueueListImpl class
