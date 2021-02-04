package escape;

import java.util.ArrayList;
import java.util.Iterator;

public class Obstacles implements Iterable{

	// properties
	private ArrayList <Obstacle> obstacles;
	// constructors
	public Obstacles()
	{
		obstacles = new ArrayList <Obstacle>();
	}
	// methods
	public void add (Obstacle obs) 
	{
		obstacles.add(obs);
	}
	public ArrayList<Obstacle> getA () 
	{
		return obstacles;
	}
	public int size() 
	{
		return obstacles.size();
	}
	public Obstacle get(int i) 
	{
		return obstacles.get(i);
	}
	public void delete() 
	{
		for (int i = 0; i < obstacles.size(); i++)
		{
			if (obstacles.get(i).getX() == 0)
			{
				obstacles.remove(i);
			}
		}
	}

	public void clearAll() 
	{
		obstacles.clear();
	}

	public void incSpeed2 ()
	{
		for (int i = 0; i < obstacles.size(); i++)
		{
			obstacles.get(i).incSpeed();
		}

	}
	@Override
	public Iterator iterator() {
		return obstacles.iterator();
	}
}
