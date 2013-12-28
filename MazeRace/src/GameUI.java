import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class GameUI extends JFrame {

	public GameUI(Cell[][] maze) {
		initComponents(maze);
	}
	
	private void initComponents(Cell[][] maze) {
		
	}
	

    // Variables declaration - do not modify
    private JPanel jPanel2;
    // End of variables declaration

    // This class name is very confusing, since it is also used as the
    // name of an attribute!
    //class jPanel2 extends JPanel {
    class GamePanel extends JPanel {

        GamePanel() {
            // set a preferred size for the custom panel.
            setPreferredSize(new Dimension(800,800));
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.drawString("BLAH", 20, 20);
            g.drawRect(200, 200, 200, 200);
        }
    }
}
