package escape;

import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;


public class GamePanel extends JPanel {

	public static final int WIDTH = 800;
	public static final int HEIGHT = 1000;
	public static final double EARTHGRAVITY = 0.4;
	public static final double MOONGRAVITY = 0.2;
	public static final double WATERGRAVITY = -0.2;
	//Properties
	Bird bird;
	int score,input,control;
	JLabel scores;
	MouseListener mouse;
	Obstacles obs;

	//Constructor
	public GamePanel(int in) 
	{
		// Basic defining 
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		setLayout(new BorderLayout());

		newGame(in);
	}

	public void newGame(int in)
	{
		input = in;
		obs = new Obstacles();
		obs.add(new Obstacle(input));

		score = 0;
		control = 0;

		scores = new JLabel("SCORE:"+ score );
		scores.setFont(new Font("Serif", Font.PLAIN, 20));
		add(scores,BorderLayout.NORTH);
		bird = new Bird();

		mouse = new Mouse();
		addMouseListener(mouse);

		if (input == 0)
			setBackground(Color.CYAN);
		else if (input == 1)
			setBackground(Color.BLACK);
		else if (input == 2)
			setBackground(Color.BLUE);
	}

	public void preGame()
	{
		remove(scores);
		obs.clearAll();
		control = 1;
		removeMouseListener(mouse);
	}

	public void  paintComponent(Graphics g)
	{
		super.paintComponent(g);
		repaint();
		if (control == 0)
		{
			if (input == 0)
				g.setColor(Color.RED);
			else if (input == 1)
				g.setColor(Color.WHITE);
			else if (input == 2)
				g.setColor(Color.YELLOW);

			bird.drawItself(g);

			// The ground
			if (input == 0)
				g.setColor(Color.ORANGE);
			else if (input == 1)
				g.setColor(Color.LIGHT_GRAY);
			else if (input == 2)
				g.setColor(Color.ORANGE.brighter());
			g.fillRect(0,HEIGHT-150,WIDTH,150);

			// The upper ground
			if (input == 0)
				g.setColor(Color.GREEN.darker());
			else if (input == 1)
				g.setColor(Color.GRAY.darker());
			else if (input == 2)
				g.setColor(Color.ORANGE.darker());
			g.fillRect(0,HEIGHT-150,WIDTH,20);

			Iterator<Obstacle> it = this.obs.iterator();
			while (it.hasNext()) 
			{
				(((Obstacle) it.next())).draw(g);
			}

			// The Gravity
			if (bird.getY() < HEIGHT-170 && input == 0)
				bird.setY(bird.getY() + EARTHGRAVITY) ;
			else if (bird.getY() < HEIGHT-170 && input == 1)
				bird.setY(bird.getY() + MOONGRAVITY);
			else if (bird.getY() < HEIGHT-170 && input == 2)
				bird.setY(bird.getY() + WATERGRAVITY);

			if (bird.getX() > obs.get(obs.size()-1).getX())
			{
				score++;
				obs.add(new Obstacle(input));
			}
			// For collision
			for (Obstacle k : obs.getA())
			{
				if (bird.getX() >= k.getX() && bird.getX() <= k.getX() + k.getZ() 
				|| bird.getX() + 20 >= k.getX() &&
				bird.getX()+20 <= k.getX() + k.getZ()) 
				{
					if( bird.getY() <= (650- k.getY())  || (bird.getY() + 20) >= (850 - k.getY()) )
					{
						System.out.println("COLLISION REPORT: ");

						System.out.println("Bird x: "+ bird.getX());
						System.out.println("Obs x: "+k.getX() + "--" + (k.getX() + k.getZ()));
						System.out.println("Bird y: "+bird.getY());
						System.out.println("Obs lower: "+ (650-k.getY()));
						System.out.println("Bird y + 20: "+(bird.getY() + 20));
						System.out.println("Obs y upper: "+ ( 850-k.getY()));

						System.out.println("Between x'S : " + (bird.getX() >= k.getX() 
								&& bird.getX() <= k.getX() + k.getZ() 
								|| bird.getX() + 20 >= k.getX() &&
								bird.getX()+20 <= k.getX() + k.getZ()));
						System.out.println("Under?: " + (bird.getY() <= 650- k.getY()));
						System.out.println("Over?: " + (bird.getY() + 20 >= 850- k.getY()));

						collision();
					}
				}
			}

			//		if ((score+1) % 10 == 0)
			//		{
			//			obs.incSpeed2();
			//		}
			Iterator<Obstacle> it2 = this.obs.iterator();
			if (input == 1 || input == 2 )
				while(it2.hasNext())
					((Obstacle)it2.next()).setSpeed(0.2);

			// This part goes through every element and make them move
			Iterator<Obstacle> it3 = this.obs.iterator();

			while(it3.hasNext())
			{
				((Obstacle)it3.next()).move();
				repaint();
			}
		}
	}

	public void collision()
	{
		preGame();

		int replay ;
		replay = JOptionPane.showConfirmDialog(GamePanel.this, "Do you want to play again?"+  "\r\n" + "SCORE: " + score, "GAME OVER", 0);
		if (replay == 0) 
		{
			Object[] options = {"Earth", "Moon", "Water"};
			int n = JOptionPane.showOptionDialog(GamePanel.this,"Which world do you want to play in? ",
					"To the World",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,
					null, options, options[2]);
			newGame(n);
		}
		else
			System.exit(0);
	}

	// This part is for MouseListener
	public class Mouse implements MouseListener
	{
		@Override
		public void mousePressed(MouseEvent e)
		{
			if (input == 0 || input == 1)
				bird.setY( bird.getY() - 120);
			else if (input == 2)
				bird.setY( bird.getY() + 120);
			repaint();
			// This part updates the score
			scores.setText("SCORE: " + score);
		}

		// Nonsence methods
		public void mouseExited(MouseEvent e){}
		public void mouseEntered(MouseEvent e){}
		public void mouseClicked(MouseEvent e){}
		public void mouseReleased(MouseEvent e){}
	}
}
