import java.util.ArrayList;


public class Wall {

	private ArrayList<Cell> cell;
	
	public Wall(Cell cell1, Cell cell2)
	{
		cell.add(new Cell(new PointXY(cell1.getX(), cell1.getY())));
		cell.add(new Cell(new PointXY(cell2.getX(), cell2.getY())));
		
		cell1.addWall(this);
		cell2.addWall(this);
	}
	
	public Cell getConnectedCell(Cell a)
	{
		if (cell.size() == 2)
		{
			for (Cell i:cell)
				if (i.compareTo(a) != 1)
					return i;
		}
		return new Cell(-1, -1);
	}
}
