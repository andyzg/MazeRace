import javax.swing.JFrame;


public class Snake extends JFrame {

    public Snake() {

        add(new Board1());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 420);
        setLocationRelativeTo(null);
        setTitle("Maze Race");

        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Snake();
    }
}