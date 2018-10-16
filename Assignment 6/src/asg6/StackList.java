package asg6;

public interface StackList<T>
{
	//max size used by default if none given
	  public final int DEFAULT_MAX_SIZE = 4;

	/** pre: none, tests to see if the Stack has 0 elements
	 *  post: return true if this StackList is empty (has 0 elements) false otherwise;
	 */
	  public boolean isEmpty();

	/**pre: none
	        
	 /*  post: returns true if current number of elements on this StackList has reached getMaxSize().
	  * 
	  * @return
	  */
	  public boolean isFull();
	

	/** pre: none
	 * post: returns  number of elements on this StackList (always <= to getMaxSize())
	 */
	  public int getSize();

	/** pre: none
	 * post: returns max number of elements allowed on this StackList
	 * 
	  
	  
	   places item on the top of this StackList
	 *pre: none
	 *post: received element is on top of this StackList instance if it is not full
	        if this StackList instance  is full, throws RuntimeException.
	 */
	  public int getMaxSize();
	  
	  public void push(T element);

	/** pre: none
	   post: removes and returns the top item from this StackList if  it is NOT empty. 
	 * @throws - RuntimeException if attempt to pop an empty StackList
	 * @return - the object that was popped from the top of this StackList
	 */
	  public T pop();

	/** pre: none
	  *returns the top item from this StackList  if it is
	 * not empty.  DOES NOT POP IT.
	 * @throws - RuntimeException if attempt to peek at an empty StackList instance
	 * @return - object that is currently on the top of this StackList
	 */
	  public T peek();

	/** pre: none
	    post: removes all items from this StackList, making it empty.
	 */
	  public void clear();

}//end of the StackList interface
