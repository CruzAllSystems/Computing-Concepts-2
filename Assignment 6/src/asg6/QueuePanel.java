package asg6;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Scanner;
import javax.swing.JPanel;

public class QueuePanel extends JPanel 
{
	/**This class is used as part of the "view" and it displays
	 * (paints) a given queueEngine 
	 *  the queueEngine is sent to the constructor - it always
	 *  paints that queueEngine instance.
	 *  assumes a getSize() and getMaxSize() are available
	 *  from the queueEngine instance
	 */
	private static final long serialVersionUID = 1L;
	final int MYWIDTH=StackQueueFrame.FRAME_WIDTH/3;
	final int MYHEIGHT=StackQueueFrame.FRAME_HEIGHT-300;
	private QueueEngine engine;

	public QueuePanel(QueueEngine qEngine)
	{ 
		super();
		this.setBackground(Color.ORANGE);
		this.setPreferredSize(new Dimension(MYWIDTH, MYHEIGHT));
		this.engine = qEngine;
		this.repaint();
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		String theQueue = engine.toString();
		Scanner input = new Scanner(theQueue);
		g.setFont(new Font("Times New Roman", Font.BOLD, 16));
		int size = engine.getSize();
		if(size == 0)
		{
			g.drawString("QUEUE is EMPTY", 20,  20);
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
			g.drawString(out, width+15,  height);
			height += ht;
		}
		input.close();
	}


}
