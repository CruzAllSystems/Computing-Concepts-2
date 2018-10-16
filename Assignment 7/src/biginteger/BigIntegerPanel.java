package biginteger;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Scanner;
import javax.swing.JPanel;

public class BigIntegerPanel extends JPanel
{
	/**
	 This class is used as part of the "view" and it displays
	 * (paints) a given bigIntegerEngine
	 *  the bigIntegerEngine is sent to the constructor - it always
	 *  paints that bigIntegerEngine instance
	 */
	
	private static final long serialVersionUID = 1L;
	final int MYWIDTH = BigIntegerFrame.FRAME_WIDTH/3 + 7;
	final int MYHEIGHT = BigIntegerFrame.FRAME_HEIGHT - 300;
	BigIntegerEngine engine;
	
	public BigIntegerPanel(BigIntegerEngine iEngine)
	{
		super();
		this.setBackground(Color.CYAN);
		this.setPreferredSize(new Dimension(MYWIDTH, MYHEIGHT));
		engine = iEngine;
		this.repaint();
		
	}//end of the default constructor
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		String theBigIntegers = engine.toString();
		Scanner input = new Scanner(theBigIntegers);
		g.setFont(new Font("Times New Roman", Font.BOLD, 16));
		int ht = MYHEIGHT / 4;
		int height= 20;
		int width = 10;
		int size = 4;
		
		// draw the stack element container as rectangles
		for(int i = 0; i < 4; i++)
		{   
			g.drawRect(20, height-10,MYWIDTH-50,ht );
			
			height += ht;
		}
		// now draw the values in the stack in the contains from top to bottom
		height= (4 - size)*ht+25;
		for(int i=0; i < 4; i++)
		{  
			String out = input.nextLine();
			//g.drawString(out, width,  height);
			g.drawString("[" + (i + 1) + ".]  " + out,width + 15, height);
			height += ht;
		}
		input.close();
	}
	

}//end of the BigIntegerPanel class
