package escape;

import java.awt.EventQueue;
import javax.swing.*;

public class maingame {

	public static final int WIDTH = 800;
	public static final int HEIGHT = 1000;

	public static void main( String[] args)
	{
		EventQueue.invokeLater(new Runnable(){
			public void run() 
			{
				GameFrame f;
				f = new GameFrame();
				f.setVisible(true);
			}
		});
	}
}
