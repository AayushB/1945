package CollisionEngine;
import java.util.Iterator;
import java.util.LinkedList;
import properties.CollidableObject;

public class CollisionEngine implements Runnable
{
	
	LinkedList<CollidableObject> collidableList;
	
	public CollisionEngine()
	{
		collidableList = new LinkedList<CollidableObject>();
		
		Thread thread = new Thread(this);
		thread.start();		
	}
	
	public void add(CollidableObject collidableObject)
	{
		collidableList.add(collidableObject);		
	}
	
	public void remove(CollidableObject collidableObject)
	{
		Iterator<CollidableObject> i= collidableList.iterator();
		int index=0;
		while (i.hasNext())
		{
			if (i.equals(collidableObject))
			{
				collidableList.remove(index);
				break;
			}
			
			index++;
		}

	}

	@Override
	public void run()
	{
		while(true)
		{
			for(int i = 0; i < collidableList.size(); i++)
			{
				for(int j = i+1; j < collidableList.size(); j++)
				{
					if(collidableList.get(i).collidesWith(collidableList.get(j)))
					{
						System.out.println("collision");
					}
				}				
			}			
		}
	}
	
	
}
