package asg6;

public interface QueueList<T>
{
	//max size used by default if none given
	 public static final int DEFAULT_MAX_SIZE = 4;

	/** pre: none, tests to see if this QueueList has 0 elements
	 *  post: return true if this QueueList is empty (has 0 elements) false otherwise;
	 */
	  public boolean isEmpty();

	/**pre: none, tests to see if this QueueList is full, 
	        full is true if current number of elements in the queue has reached its max allowable size. 
	   post: returns true if getSize() has reached getMaxSize(), false if not
	*/  
	  public boolean isFull();


	/** pre: none
	 * post: returns  number of elements in this QueueList
	 */
	  public int getSize();

	/** pre: none
	 * post: returns max number of elements allowed in this QueueList
	 */
	  public int getMaxSize();


	/** places item at the REAR of this QueueList
	 *pre: none
	 *post: element is placed at the REAR or END of this QueueList if it is NOT full
	        if this QueueList is full, throws RuntimeException.
	 */
	  public void add(T element);

	/** pre: none
	   post: removes and returns the FRONT item from this QueueList if it is NOT empty
	 * @throws - RuntimeException if attempt to remove from an empty QueueList
	 * @return - the object that was removed from the front of this QueueList
	 */
	  public T remove();

	/** pre: none
	  *returns the FRONT item from this QueueList if it is
	 * not empty.  DOES NOT REMOVE IT.
	 * @throws - RuntimeException if this QueueList is empty.
	 * @return - object that is currently at the FRONT of this QueueList
	 */
	  public T getFront();

	/** pre: none
	  *returns the REAR (or last)  item from this QueueList if it is
	 * not empty.  DOES NOT REMOVE IT.
	 * @throws - RuntimeException if this QueueList is empty.
	 * @return - object that is currently at the REAR (or end) of this QueueList
	 */
	  public T getRear();

	/** pre: none
	    post: removes all items from this QueueList making it empty.
	 */
	  public void clear();
	

}
