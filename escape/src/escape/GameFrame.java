package escape;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;;

public class GameFrame extends JFrame implements ActionListener
{
	public static final int WIDTH = 800;
	public static final int HEIGHT = 1000;
	// variables
	GamePanel game ;
	JButton b1,b2,b3;
	JPanel p,centralPanel, southPanel;
	JLabel label,label2;
	int n;
	// program code
	public GameFrame()
	{
		setSize(WIDTH,HEIGHT);
		setTitle("Escape");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		p = new JPanel();
		p.setLayout(new BorderLayout());
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		add(p);

		label = new JLabel("THE ESCAPE");
		label.setFont(new Font("Serif", Font.PLAIN, 60));
		
		label2 = new JLabel("By EE");
		label2.setFont(new Font("Serif", Font.ITALIC, 30));

		b1 = new JButton("START GAME ON THE EARTH");
		b1.addActionListener(this);

		b2 = new JButton("START GAME ON THE MOON");
		b2.addActionListener(this);

		b3 = new JButton("START GAME UNDER WATER");
		b3.addActionListener(this);

		// setting the inherited property central panel's layout to border layout
		centralPanel = new JPanel();
		centralPanel.setLayout(new BorderLayout());
		centralPanel.setBackground(Color.CYAN);
		centralPanel.add(label, BorderLayout.CENTER);
		centralPanel.add(label2, BorderLayout.SOUTH);

		// setting the inherited property central panel's layout to flow layout
		southPanel = new JPanel();
		southPanel.setLayout(new FlowLayout());
		southPanel.setBackground(Color.ORANGE.darker());

		// adding the buttons to the south side panel
		southPanel.add( b1);
		southPanel.add( b2);
		southPanel.add( b3);

		// adding the inherited properties to proper places
		p.add(centralPanel, BorderLayout.CENTER);
		p.add(southPanel, BorderLayout.SOUTH);

		pack();
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1)
		{
			n = 0;
			openGame(n);
		}
		if (e.getSource() == b2)
		{
			n = 1;
			openGame(n);
		}
		if (e.getSource() == b3)
		{
			n = 2;
			openGame(n);
		}
	}
	public void openGame(int n)
	{
		b1.setVisible(false);
		b2.setVisible(false);
		b3.setVisible(false);
		p.remove(b1);
		p.remove(b2);
		p.remove(label);
		game = new GamePanel(n);
		p.add(game, BorderLayout.CENTER);
	}

}
