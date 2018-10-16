package asg6;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class StackQueueViewImpl extends JPanel implements ActionListener 
{
	private static final long serialVersionUID = 1L;
	JButton stackSizeButton;//
	JButton pushButton;//
	JButton peekButton;
	JButton showStackButton;//
	JButton clearStackButton;
	JButton popButton;//
	JButton queueSizeButton;
	JButton addButton;//
	JButton removeButton;//
	JButton clearQueueButton;
	JButton frontButton;//
	JButton rearButton;
	JButton emptyButton;//
	JButton fullButton;//
	JButton showQueueButton;//
	JTextArea stackArea;
	JPanel stackButtonPanel ;
	JPanel queueButtonPanel;
	StackPanel stackPanel;
	QueuePanel queuePanel;
	StackEngine stackEngine;
	QueueEngine queueEngine;
	
	ChangeListener stackEngineListener;
	ChangeListener queueEngineListener;
	String areaText;
	// default constructor, receives the stack engine model it is displaying and controlling
	public StackQueueViewImpl(StackEngine aStackEngine, QueueEngine aQueueEngine)
	{
		super();
		this.setPreferredSize(new Dimension(StackQueueFrame.FRAME_WIDTH-20, StackQueueFrame.FRAME_HEIGHT - 100));
		this.setLayout(new BorderLayout());
		this.stackEngine = aStackEngine;
		this.queueEngine = aQueueEngine;
	    areaText = "Current Stack:\n" + this.stackEngine.toString();
		stackEngineListener = new ChangeListener()
		{ 
			public void stateChanged(ChangeEvent e){
				update();
			}

		};
		this.stackEngine.addChangeListener(stackEngineListener);
		queueEngineListener = new ChangeListener()
		{ 
			public void stateChanged(ChangeEvent e){
				update();
			}

		};
		this.queueEngine.addChangeListener(queueEngineListener);
		init();
	}
	// initializes the view - all the widgets and listeners, sets up the view
	private void init() 
	{
		this.pushButton = new JButton("Push");
		this.popButton = new JButton("Pop");
		this.showStackButton = new JButton("Show Stack Contents");
		this.addButton = new JButton("Add to Queue");
		this.removeButton = new JButton("Remove from Queue");
		this.showQueueButton = new JButton("Show Queue Contents");
		this.stackArea = new JTextArea("Stack is Empty\n\n\nQueue is Empty", 20, 40);
		stackArea.setBackground(Color.RED);
		//this.showQueueButton = new JButton("Show Queue Contents");
		this.emptyButton = new JButton("Check Empty(both)");
		this.fullButton = new JButton("Check Full(both)");
		this.stackSizeButton = new JButton("Stack Size");
		this.frontButton = new JButton("Front of Queue");
		this.clearStackButton = new JButton("Clear Stack");
		this.queueSizeButton = new JButton("Queue Size");
		this.clearQueueButton = new JButton("Clear Queue");
		this.rearButton = new JButton("Rear of Queue");
		this.peekButton = new JButton("Peek");
		
		
		this.stackPanel = new StackPanel(stackEngine);  // create a Stack Panel (view) and send it the engine it is "modeling"
		this.queuePanel = new QueuePanel(queueEngine);  // create a Queue Panel (view) and send it the engine it is "modeling"
		
		stackButtonPanel = new JPanel();		  // used to hold all stack operation buttons
		stackButtonPanel.setLayout(new GridLayout(1,6));  // 1 row of 6 (change as more or less buttons are used)
		stackButtonPanel.add(pushButton);			// now add buttons to the panel
		stackButtonPanel.add(popButton);
		stackButtonPanel.add(showStackButton);
		stackButtonPanel.add(emptyButton);//
		stackButtonPanel.add(fullButton);//
		stackButtonPanel.add(stackSizeButton);//
		stackButtonPanel.add(clearStackButton);
		stackButtonPanel.add(peekButton);
		
		queueButtonPanel = new JPanel();			// used to hold all queue operation buttons - currently 3 but more should be added
		queueButtonPanel.setLayout(new GridLayout(1,8));
		queueButtonPanel.add(addButton);
		queueButtonPanel.add(removeButton);
		queueButtonPanel.add(showQueueButton);
		queueButtonPanel.add(frontButton);//
		queueButtonPanel.add(queueSizeButton);
		queueButtonPanel.add(clearQueueButton);
		queueButtonPanel.add(rearButton);
		
	
		this.add(stackButtonPanel, BorderLayout.NORTH);  // this is the controller panel, add the stack button panel to the top across
		this.add(queuePanel,  BorderLayout.EAST);		  // add remaining components to this controller panel
		this.add(stackPanel, BorderLayout.WEST);
		this.add(stackArea, BorderLayout.CENTER);
		this.add(queueButtonPanel,  BorderLayout.SOUTH);  // add queue button panel to the bottom

		pushButton.addActionListener(this); 
		popButton.addActionListener(this);
		showStackButton.addActionListener(this);
		showQueueButton.addActionListener(this);
		addButton.addActionListener(this);
		removeButton.addActionListener(this);
		emptyButton.addActionListener(this);//
		fullButton.addActionListener(this);//
		stackSizeButton.addActionListener(this);//
		frontButton.addActionListener(this);//
		clearStackButton.addActionListener(this);
		queueSizeButton.addActionListener(this);
		clearQueueButton.addActionListener(this);
		rearButton.addActionListener(this);
		peekButton.addActionListener(this);
		
		}
	//method called when an ChangeEvent is fired in the model
	// updates data on the view which will reflect any changes made to the model
	private void update() 
	{
		//this.area.setText("Stack Update:\n" + this.engine.getActionText());
		repaint();
		stackArea.setText(stackEngine.getActionText() + "\n\n\n" + queueEngine.getActionText());
	}

	// HANDLES all button actions, listeners for each button
	public void actionPerformed(ActionEvent e) {
		String actionText="";
		if(e.getSource().equals(pushButton))
		{  System.out.println("push button clicked...");
			if(!(stackEngine.getSize() == stackEngine.getMaxSize()))
			{
				String item = JOptionPane.showInputDialog(this, "Enter value to push", "");
				if(item==null)
					actionText="Push cancelled...no push";
				else
				{
				  stackEngine.push(item);
				  actionText = "Just pushed " + item + " onto stack \n" + stackEngine.toString();
				}
			}
			else
			{

				actionText = "Cannot push, the stack is full with these elements:\n"+ stackEngine.toString();
			}
		}
		else if (e.getSource().equals(popButton))
		{
			if(stackEngine.getSize() == 0)
			{
				actionText = "Cannot pop an empty stack";
			}
			else
			{
				stackEngine.pop();  // note we popped the engine and it recovers the value popped
				actionText = stackEngine.getActionText() + "\nContents of Stack: \n" + stackEngine.toString();
			}
		}
		else if (e.getSource().equals(showStackButton))
		{
			actionText = (stackEngine.toString());
			
		}
		else if (e.getSource().equals(addButton))
		{
			String item = JOptionPane.showInputDialog(this, "Enter value to add to queue:", "");
			if(item==null)
				actionText="Add  cancelled...no add occurs";
			else
			{
			  queueEngine.add(item);
			  actionText = queueEngine.getActionText() + " \n" + "Contents of queue: \n"  + queueEngine.toString();
			}
		}
		else if (e.getSource().equals(removeButton))
		{
			
				queueEngine.remove();  // note we remove
				actionText = queueEngine.getActionText() + " \n" +  "Contents of queue: \n" + queueEngine.toString();
		}
		else if (e.getSource().equals(showQueueButton))
		{
			actionText = "\n" + queueEngine.toString();
		}
		
		else if (e.getSource().equals(emptyButton))
		{
			stackEngine.testEmpty();
			queueEngine.testEmpty();
			
			actionText = stackEngine.getActionText() + queueEngine.getActionText();
		}
		
		else if (e.getSource().equals(fullButton))
		{
			stackEngine.testFull();
			queueEngine.testFull();
			
			actionText = stackEngine.getActionText() + queueEngine.getActionText();
		}
		else if (e.getSource().equals(frontButton))
		{
			if(queueEngine.getSize() == 0)
				actionText = "Queue is empty and has no front.";
			else
			{
				queueEngine.showFront();
				actionText = queueEngine.getActionText();
				
			}
			
		}
		
		else if (e.getSource().equals(stackSizeButton))
		{
			stackEngine.getSize();
			actionText = stackEngine.getActionText();
		}
		
		else if (e.getSource().equals(clearStackButton))
		{
			stackEngine.clear();
			actionText = stackEngine.getActionText();
		}
		
		else if (e.getSource().equals(peekButton))
		{
			stackEngine.peek();
			actionText = stackEngine.getActionText();
		}
		
		else if (e.getSource().equals(rearButton))
		{
			queueEngine.showRear();
			actionText = queueEngine.getActionText();
		}
		
		else if (e.getSource().equals(queueSizeButton))
		{
			queueEngine.showSize();
			actionText = queueEngine.getActionText();
		}
		
		else if (e.getSource().equals(clearQueueButton))
		{
			queueEngine.clear();
			actionText = queueEngine.getActionText();
		}
		
		
		
		stackArea.setText(actionText);
	}


}//ebd of the StackQueueViewImpl class
