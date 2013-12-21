
public class MazeGen {

	public static final int size = 20;
	
	public static void main(String[] args)
	{
		Cell [][]maze = mazeGen(size,size);
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
	
	private static Cell[][] mazeGen(int row, int col)
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
			for (int j=0; j<maze[0].length; j++)
			{
				connectWalls(maze, i, j);
			}
		}
	}
	
	private static void connectWalls(Cell[][] maze, int x, int y)
	{
		for (int i=0; i<2; i++)
		{
			if (y > 0 && y < size-1)
			{
				Wall a = new Wall(maze[x][y-1+i], maze[x][y+i]);
				
				maze[x][y-1+i].addWall(a);
				maze[x][y+i].addWall(a);
			}
		}
		
		for (int i=0; i<2; i++)
		{
			if (x > 0 && x < size-1)
			{
				Wall a = new Wall(maze[x-1+i][y], maze[x+i][y]);
				
				maze[x-1+i][y].addWall(a);
				maze[x+i][y].addWall(a);
			}
		}
	}
}
