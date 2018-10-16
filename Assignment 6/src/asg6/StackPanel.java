package asg6;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Scanner;
import javax.swing.JPanel;

public class StackPanel extends JPanel
{
	/**
	 This class is used as part of the "view" and it displays
	 * (paints) a given stackEngine 
	 *  the stackEngine is sent to the constructor - it always
	 *  paints that stackEngine instance.
	 *  assumes a getSize() and getMaxSize() are available
	 *  from the stackEngine instance
	 */

	
	private static final long serialVersionUID = 1L;
	final int MYWIDTH=StackQueueFrame.FRAME_WIDTH/3;
	final int MYHEIGHT=StackQueueFrame.FRAME_HEIGHT-300;
	StackEngine engine;
	public StackPanel(StackEngine sEngine)
	{ 
		super();
		this.setBackground(Color.GREEN);
		this.setPreferredSize(new Dimension(MYWIDTH, MYHEIGHT));
		engine = sEngine;
		this.repaint();
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		String theStack = engine.toString();
		Scanner input = new Scanner(theStack);
		g.setFont(new Font("Times New Roman", Font.BOLD, 16));
		int size = engine.getSize();
		if(size == 0)
		{
			g.drawString("STACK is EMPTY", 20,  20);
			return;
		}
		
		int ht = MYHEIGHT/engine.getMaxSize();
		int height= 20;
		int width = 10;
		// draw the stack element container as rectangles
		for(int i=0; i<engine.getMaxSize(); i++)
		{   
			g.drawRect(20, height-10,MYWIDTH-50,ht );
			
			height += ht;
		}
		// now draw the values in the stack in the contains from top to bottom
		height= (engine.getMaxSize()-size)*ht+25;
		for(int i=0; i<size; i++)
		{  
			String out = input.nextLine();
			g.drawString("[" + (i +1) + "  " + out, width+15,  height);
			height += ht;
		}
		input.close();
	}


}
