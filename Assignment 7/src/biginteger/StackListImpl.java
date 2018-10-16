package biginteger;
import java.util.*;

public class StackListImpl<T> implements StackList<T> 
{
	private int maxSize;
	private ArrayList<T> stack;

	public StackListImpl()
	{
		this.maxSize = StackList.DEFAULT_MAX_SIZE;
		stack = new ArrayList<T>(maxSize);
		
	}//end of the default constructor
	
	public StackListImpl(int theMaxSize)
	{
		if(theMaxSize <= 0)
			this.maxSize = StackList.DEFAULT_MAX_SIZE;
		else
			this.maxSize = theMaxSize;
		
		stack = new ArrayList<T>(maxSize);
		
	}//end of the default constructor
	
	public String toString()
	{
		String temp = "";
		
		for(int index = this.getSize() - 1; index >= 0; index-- )
			temp += this.stack.get(index) + "\n";
		
		return temp;
			
	}//end of the toString method
	
	/** pre: none, tests to see if the Stack has 0 elements
	 *  post: return true if this StackList is empty (has 0 elements) false otherwise;
	 */
	public boolean isEmpty() 
	{
		if(this.stack.size() == 0)
			return true;
			
		return false;
		
	}//end of the isEmpty method

	/**pre: none
	   post: returns true if current number of elements on this StackList has reached getMaxSize().
	 */
	public boolean isFull() 
	{
		if(this.stack.size() == this.maxSize)
			return true;
		
		return false;
		
	}//end of the is full method

	/** pre: none
	 * post: returns  number of elements on this StackList (always <= to getMaxSize())
	 */
	public int getSize() 
	{
		return this.stack.size();
		
	}//end of the getSize method

	// pre: none
	 //post: returns max number of elements allowed on this StackList
	public int getMaxSize() 
	{
		
		return this.maxSize;
		
	}//end of the getMaxSize method

	/** places item on the top of this StackList
	 *pre: none
	 *post: received element is on top of this StackList instance if it is not full
	        if this StackList instance  is full, throws RuntimeException.
	 */
	public void push(T element) 
	{
		if(this.isFull())
			throw new RuntimeException("This is a full list.");
		
		this.stack.add(element);
		
		
	}//end of the push method

	/** pre: none
	   post: removes and returns the top item from this StackList if  it is NOT empty. 
	 * @throws - RuntimeException if attempt to pop an empty StackList
	 * @return - the object that was popped from the top of this StackList
	 */
	public T pop() 
	{
		if(this.isEmpty())
			throw new RuntimeException("This is an empty list.");
		
		T temp = this.stack.get(this.stack.size() - 1);
		
		this.stack.remove(this.stack.size() - 1);
		
		return temp;
		
	}//end of the pop method

	/** pre: none
	  *returns the top item from this StackList  if it is
	 * not empty.  DOES NOT POP IT.
	 * @throws - RuntimeException if attempt to peek at an empty StackList instance
	 * @return - object that is currently on the top of this StackList
	 */
	public T peek() 
	{
		if(this.isEmpty())
			throw new RuntimeException("This is an empty list.");
		
		T temp = this.stack.get(this.stack.size() - 1);
		
		return temp;
		
	}//end of the peak method

	/** pre: none
    post: removes all items from this StackList, making it empty.
	 */
	public void clear() 
	{
		this.stack.clear();
		
	}//end of the clear method

	
	

}//end of the StackListImpl Class
