
public class MazeGen {

	public static final int size = 20;
	
	public static void main(String[] args)
	{
		Cell [][]maze = gridGen(size,size);
		generateWalls(maze);

		for (int i=0; i<size; i++)
		{
			for (int j=0; j<size; j++)
			{
				System.out.print(maze[i][j].getWalls().size());
			}
			System.out.println();
		}
		
		System.out.println("Done");
	}
	
	private static Cell[][] gridGen(int row, int col)
	{
		Cell [][]maze = new Cell[row][col];
		
		for (int i=0; i<row; i++)
		{
			for (int j=0; j<col; j++)
			{
				maze[i][j] = new Cell(i, j);
			}
		}
		
		return maze;
	}
	
	private static void generateWalls(Cell[][] maze)
	{
		for (int i=0; i<maze.length; i++)
		{
			for (int j=0; j<maze[0].length-1; j++)
			{
				Wall a = new Wall(maze[i][j], maze[i][j+1]);
				
				maze[i][j].addWall(a);
				maze[i][j+1].addWall(a);
				
				
				Wall b = new Wall(maze[j][i], maze[j+1][i]);
				maze[j][i].addWall(b);
				maze[j+1][i].addWall(b);
			}
		}
	}
	
	private static void removeWall(Wall wall, Cell a)
	{
		wall.getConnectedCell(a).removeWall(wall.getID());
		a.removeWall(wall.getID());
	}
	
	private static void mazeGenerator(Cell[][] maze)
	{
		
	}
}
