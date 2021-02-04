package escape;

import java.awt.Color;
import java.awt.Graphics;

public class Obstacle {
	// properties
	private double x,y,z,speed;
	private int i;
	// constructors
	public Obstacle(int in)
	{
		x = 700;
		y = (int) (Math.random()*450 + 200);
		//		z = (int) (Math.random()*40+20);
		z = 40;
		speed = 0.3;
		i = in;
	}
	// methods
	public void draw(Graphics g)
	{
		if (i == 0)
			g.setColor(Color.MAGENTA);
		else
			g.setColor(Color.green.darker());

		g.fillRect((int)x , (int)(850-y) ,(int) this.z, (int)this.y);
		g.fillRect((int)x , 0 ,(int) this.z, (int)(650-y));
		
		if (i == 0)
			g.setColor(Color.MAGENTA.darker().darker());
		else
			g.setColor(Color.green.darker().darker().darker());
		
		g.fillRect((int)x , (int)(850-y) ,(int) this.z, 15);
		g.fillRect((int)x , (int)(635-y) ,(int) this.z, 15);
	}
	public void move() 
	{
		if (x == 0)
		{
			y = 0;
			z = 0;
		}
		else 
			x -= speed;
	}
	public void incSpeed ()
	{
		this.speed += 0.1;
	}
	
	public void setSpeed (double s)
	{
		speed = s;
	}
	
	public double getX()
	{
		return x;
	}
	
	public double getY()
	{
		return y;
	}
	
	public double getZ()
	{
		return z;
	}

}


