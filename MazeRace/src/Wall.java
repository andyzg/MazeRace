import java.util.ArrayList;


public class Wall {
	private static int idGenerator = 0;
	private int id;
	private ArrayList<Cell> cell = new ArrayList<Cell>();
	
	
	public Wall(Cell cell1, Cell cell2)
	{
		this.cell.add(cell1);
		this.cell.add(cell2);
		
		this.id = idGenerator;
		idGenerator++;
	}
	
	public int getID()
	{
		return this.id;
	}
	
	public void setID(int id)
	{
		this.id = id;
	}
	
	public Cell getConnectedCell(Cell a)
	{
		if (this.cell.size() == 2)
		{
			for (Cell i:this.cell)
				if (i.compareTo(a) != 0)
					return i;
		}
		System.out.println("Error: Wall could not be found");
		return new Cell(-1, -1);
	}
}
