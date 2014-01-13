import javax.swing.JFrame;

public class MazeRace extends JFrame {

	public MazeRace(int size) {
		add(new Board(size));
		setTitle("Maze Race");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700, 700);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
	}
	
	public static void main(String[] args) {
		new MazeRace(80);
	}
}