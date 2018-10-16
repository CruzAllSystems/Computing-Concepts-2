package biginteger;
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


public class BigIntegerViewImpl extends JPanel implements ActionListener
{
	public static final long serialVersionUID = 1L;
	
	JButton inputButton;
	JButton clearButton;
	JTextArea bigIntegerArea;
	JPanel bigIntegerButtonPanel;
	BigIntegerPanel bigIntegerPanel;
	BigIntegerEngine bigIntegerEngine;
	
	ChangeListener bigIntegerEngineListener;
	String areaText;
	
	public BigIntegerViewImpl(BigIntegerEngine aBigIntegerEngine)
	{
		super();
		this.setPreferredSize(new Dimension(BigIntegerFrame.FRAME_WIDTH-20, BigIntegerFrame.FRAME_HEIGHT - 100));
		this.setLayout(new BorderLayout());
		this.bigIntegerEngine = aBigIntegerEngine;
		areaText = "Sum: " + bigIntegerEngine.getSum();
		
		bigIntegerEngineListener = new ChangeListener()
		{ 
			public void stateChanged(ChangeEvent e){
				update();
			}

		};
		this.bigIntegerEngine.addChangeListener(bigIntegerEngineListener);
		init();
		
		
	}//end of the default constructor
	
	// initializes the view - all the widgets and listeners, sets up the view
	private void init()
	{
		this.inputButton = new JButton("Set an Operand");
		this.clearButton = new JButton("Clear");
		
		this.bigIntegerArea = new JTextArea("Sum: " + bigIntegerEngine.getSum(), 20, 46);
		bigIntegerArea.setBackground(Color.ORANGE);
		this.bigIntegerPanel = new BigIntegerPanel(bigIntegerEngine);
		
		bigIntegerButtonPanel = new JPanel();
		bigIntegerButtonPanel.setLayout(new GridLayout(1,3));
		bigIntegerButtonPanel.add(inputButton);
		bigIntegerButtonPanel.add(clearButton);
		
		this.add(bigIntegerButtonPanel, BorderLayout.NORTH);
		this.add(bigIntegerPanel, BorderLayout.WEST);
		this.add(bigIntegerArea, BorderLayout.EAST);
		
		inputButton.addActionListener(this);
		clearButton.addActionListener(this);
		
		
		
		
	}//end of the init method
	
	//method called when an ChangeEvent is fired in the model
	// updates data on the view which will reflect any changes made to the model
	private void update() 
	{
		repaint();
		bigIntegerArea.setText("Sum: " + bigIntegerEngine.getSum());
		
	}//end of the update method
	
	// HANDLES all button actions, listeners for each button
	public void actionPerformed(ActionEvent e)
	{
		String actionText = "";
		
		if(e.getSource().equals(inputButton))
		{  System.out.println("Set button clicked...");
				String item = JOptionPane.showInputDialog(this, "Enter place to add the operand", "");
				if(item==null)
					actionText="Push cancelled...no push";
				else
				{
					String index = item;
					String item2 = JOptionPane.showInputDialog(this, "Enter operand", "");
					
					if(item2 == null)
						actionText = "Push cancelled...no push";
					else
					{
						bigIntegerEngine.setOperand(Integer.parseInt(item),item2);
						actionText = "Added " + item + " to operands \n" + bigIntegerEngine.toString();
						
					}//end of menu 2
				  
				  
				}//end of menu 1
				
		}//end of set aciton if
		
		if(e.getSource().equals(clearButton))
		{
			bigIntegerEngine.clearOperands();
			
		}//end of clear action if
		
	}//end of the actionPerformed method

}//end of the BigIntegerViewImpl class
