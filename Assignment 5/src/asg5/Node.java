package asg5;

public class Node <T>
{
	public T data; 
    public Node<T> link;

    //default constructor 
    public Node()
	{
	    this.data = null;
	    this.link = null;
	}//end of constructor
    
    // constructs a node with given data and null for the link
    public Node(T theData)
	{
	    this.data = theData;
	    this.link = null;
	}
    
    // constriucts a node with given link and uses null for data
    public Node(Node<T> theLink)
	{
	    this.data = null;
	    this.link = theLink;
	}
    // constructs a node with given data and link values
    public Node(T theData, Node<T> theLink)
	{
	    this.data = theData;
	    this.link = theLink;
	}


}//end of the Node Class
