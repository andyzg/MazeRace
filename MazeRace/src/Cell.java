import java.util.ArrayList;


public class Cell implements Comparable<Cell> {

	private boolean visited;
	private ArrayList<Wall> walls;
	private int x;
	private int y;
	
	public Cell ()
	{
		visited = false;
	}
	
	public Cell (PointXY point)
	{
		this.x = point.getX();
		this.y = point.getY();
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
	
	@Override
	public int compareTo(Cell cell) {
		if (this.getX() == cell.getX() && this.getY() == cell.getY())
			return 1;
		return 0;
	}
}