import java.util.Random;

public class MazeGen {

	public static final int size = 6;
	private static Random rand = new Random();
	
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
		mazeGenerator(maze, 0, 0);
		
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
	
	private static void mazeGenerator(Cell[][] maze, int i, int j)
	{
		maze[i][j].setVisited(true);
		int wallAmount = maze[i][j].getWalls().size();
		
		while (hasVisited(maze,i,j,wallAmount))
		{
			int index = rand.nextInt(wallAmount);
			// System.out.println(index + " is the random number and " + wallAmount + " is the size");
		
			Wall adjacentWall= maze[i][j].getWalls()
					.get(index);
			
			System.out.println("i: " + adjacentWall.getConnectedCell(maze[i][j]).getX());
			System.out.println("j: " + adjacentWall.getConnectedCell(maze[i][j]).getY());
			System.out.println();
			
			if (!adjacentWall.getConnectedCell(maze[i][j]).getVisited())
			{
				removeWall(adjacentWall, maze[i][j]);
				wallAmount--;
				mazeGenerator(maze, 
						adjacentWall.getConnectedCell(maze[i][j]).getX(),
						adjacentWall.getConnectedCell(maze[i][j]).getY());
				
				System.out.println("Wall Amount" + wallAmount);
			}
			return;
		}
	}
	
	private static boolean hasVisited(Cell maze[][], int i, int j, int size) {
		int visited = 0;
		
		for (Wall wall:maze[i][j].getWalls())
		{
			if (wall.getConnectedCell(maze[i][j]).getVisited())
				visited++;
		}
		if (size <= visited)
			return false;
		return true;
	}
}
