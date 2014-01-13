import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;


public class Board extends JPanel {

	Cell[][] maze;
	
	public Board(int size) {
		maze = new MazeGen(size).getMaze();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		Graphics2D g2 = (Graphics2D) g;
		Dimension size = getSize();
		double width = size.getWidth();
		double height = size.getHeight();
		
		double blockWidth = height/maze.length;
		double blockHeight = width/maze.length;
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
												RenderingHints.VALUE_ANTIALIAS_ON);
		rh.put(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);
		g2.setRenderingHints(rh);
		g2.setColor(new Color(0, 0, 0));
		g2.setBackground(new Color(255, 255, 255));
		
		for (int i=0; i<maze.length; i++) {
			for (int j=0; j<maze.length; j++) {
				if ((i+j)%2==0)
				{
					Cell cell = maze[i][j];
					for (Wall w:cell.getWalls()) {
						Cell temp = w.getConnectedCell(cell);
						int x = temp.getX();
						int y = temp.getY();
						
						int xPos;
						int yPos;
						if (y == j) {
							xPos = x > i ?  x : i;
							yPos = j;
							g2.drawLine((int)((j)*blockHeight),
									(int)((xPos)*blockWidth),
									(int)((j+1)*blockHeight),
									(int)((xPos)*blockWidth));
						}
						else {
							xPos = i;
							yPos = y > j ? y : j;
							g2.drawLine((int)((yPos)*blockHeight),
									(int)((i)*blockWidth),
									(int)((yPos)*blockHeight),
									(int)((i+1)*blockWidth));					
						}
					}
				}
			}
		}
	}
}
