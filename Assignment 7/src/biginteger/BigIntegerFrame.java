package biginteger;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;


public class BigIntegerFrame 
{
	// main program that runs the BigInteger Gui testing
	// uses the Model-View-Controller paradigm
	// the controller is BigIntegerViewImpl 
	// the model is a BigInteger instance
	// the view is part of the controller in the BigIntegerViewImpl class
	
	public static final int FRAME_WIDTH = 800;
	public static final int FRAME_HEIGHT = 750;
	
	public static void main(String args[])
	{
		BigIntegerEngine bigInteger = new BigIntegerEngineImpl();
		BigIntegerViewImpl controller = new BigIntegerViewImpl(bigInteger);
		JFrame frame = new JFrame("Cruz's Big Integer Addition Tool");
		frame.setLayout(new FlowLayout());
		frame.addWindowListener( new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent)
			{
				System.exit(0);
			}
		});
		frame.getContentPane().add(controller);
		frame.setSize(BigIntegerFrame.FRAME_WIDTH,BigIntegerFrame.FRAME_HEIGHT);
		frame.setVisible(true);
		
		
	}//end of the main method
	

}//end of the BigIntegerFrame Class
