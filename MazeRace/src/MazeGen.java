import java.util.Random;

public class MazeGen {

	private  Random rand = new Random();
	private  Cell[][] maze;

	public MazeGen(int size) {
		makeMaze(size);
		
		/*for (int i=0; i<maze.length; i++) {
			for (int j=0; j<maze.length; j++) {
				System.out.print(maze[i][j].getWalls().size());
			}
			System.out.println();
		}*/
	}
	public void makeMaze(int size)
	{
		Cell [][]maze = gridGen(size,size);
		generateWalls(maze);

		mazeGenerator(maze, 0, 0);
		setMaze(maze);
	}
	
	private Cell[][] gridGen(int row, int col)
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
	
	private  void generateWalls(Cell[][] maze)
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
	
	private  void removeWall(Wall wall, Cell a)
	{
		wall.getConnectedCell(a).removeWall(wall.getID());
		a.removeWall(wall.getID());
	}
	
	private  void mazeGenerator(Cell[][] maze, int i, int j)
	{
		maze[i][j].setVisited(true);
		int wallAmount = maze[i][j].getWalls().size();
		
		while (hasVisited(maze[i][j],wallAmount))
		{
			int index = rand.nextInt(wallAmount);
			// System.out.println(index + " is the random number and " + wallAmount + " is the size");
		
			Wall adjacentWall= maze[i][j].getWalls()
					.get(index);
			
			if (!adjacentWall.getConnectedCell(maze[i][j]).getVisited())
			{
				removeWall(adjacentWall, maze[i][j]);
				wallAmount--;
				mazeGenerator(maze, 
						adjacentWall.getConnectedCell(maze[i][j]).getX(),
						adjacentWall.getConnectedCell(maze[i][j]).getY());
			}
		}
		return;
	}
	
	private boolean hasVisited(Cell cell, int size) {
		int visited = 0;
		
		for (Wall wall:cell.getWalls())
		{
			if (wall.getConnectedCell(cell).getVisited())
				visited++;
		}
		if (size <= visited)
		{	
			return false;
		}
		return true;
	}
	
	public void setMaze(Cell[][] maze) {
		this.maze = maze;
	}
	
	public Cell[][] getMaze() {
		return this.maze;
	}
}