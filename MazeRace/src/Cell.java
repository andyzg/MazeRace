import java.util.ArrayList;


public class Cell implements Comparable<Cell> {

	private boolean visited;
	private ArrayList<Wall> walls = new ArrayList<Wall>();
	private int x;
	private int y;
	
	public Cell ()
	{
		visited = false;
	}
	
	public Cell(int x, int y)
	{
		this.x = x;
		this.y = y;
		visited = false;
	}
	
	public void setVisited(boolean visited)
	{
		this.visited = visited;
	}
	
	public boolean getVisited()
	{
		return this.visited;
	}
	
	public void setXandY(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
	
	public void addWall(Wall wall)
	{
		walls.add(wall);
	}
	
	public ArrayList<Wall> getWalls()
	{
		return walls;
	}

	public void removeWall(int id)
	{
		for (Wall i:walls)
		{
			if (i.getID() == id)
			{
				this.walls.remove(i);
				break;
			}
		}
	}
	
	@Override
	public int compareTo(Cell cell) {
		if (this.getX() == cell.getX() && this.getY() == cell.getY())
			return 0;
		return 1;
	}
}