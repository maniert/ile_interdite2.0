
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class JButtonTest extends JFrame {

    public JButtonTest() {

        JButton b = new JButton("Ouvrir", new ImageIcon("pika.png"));

        JFrame frame = new JFrame("JFrame test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        b.setPreferredSize(new Dimension(900, 900));
        frame.getContentPane().add(b);
        frame.pack();
    }

    public static void main(String[] args) {
        new JButtonTest();
    }
}
