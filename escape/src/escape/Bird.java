package escape;

import java.awt.*;

public class Bird extends Rectangle{
	
	public static final int WIDTH = 800;
	public static final int HEIGHT = 1000;

	private double height, x ,y;
	
	public Bird()
	{
		height = 20;
		x = WIDTH/2 - 10;
		y = HEIGHT/2 -10;
	}	
	
	public double getX()
	{
		return x;
	}
	
	public double getY()
	{
		return y;
	}
	
	public void setY(double k)
	{
		y = k;
	}
	
	public double getH()
	{
		return height;
	}
	
	public void drawItself(Graphics g)
	{
		g.fillRect((int)getX(),(int)getY(), (int)height,(int)height);
		g.setColor(Color.red.darker().darker().darker());
		g.fillRect((int)getX(),(int)getY(), (int)20,(int)7);
		g.setColor(Color.WHITE);
		g.fillRect((int)getX() + 12,(int)getY() + 10, (int)6,(int)6);
		g.setColor(Color.BLACK);
		g.fillRect((int)getX() + 15,(int)getY() + 13, (int)4,(int)4);
	}
}
