
public class MazeGen {

	public static void main(String[] args)
	{
		Cell [][]maze = mazeGen(20,20);
		generateWalls(maze);
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
				
			}
		}
	}
}