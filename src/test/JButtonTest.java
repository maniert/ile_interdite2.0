
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Parameter;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import util.Parameters;

public class JButtonTest extends JFrame{

        
    
 
    public JButtonTest() {
       String userDir = System.getProperty("user.dir");
    String folder = new File(userDir).getParent();
        System.out.println(folder);
        System.out.println(Parameters.ROOT);
        JButton b = new JButton("Ouvrir", new ImageIcon(Parameters.ROOT + "\\src\\images\\images\\cartes\\Calice.png"));
        JButton b2 = new JButton("ouvirir", new ImageIcon("C:\\Users\\Princesse Mathilde\\Documents\\NetBeansProjects\\ile_interdite2.0\\src\\images\\images\\cartes\\Calice.png"));
         System.out.println(b);
        
         
         JFrame frame = new JFrame("JFrame test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        b.setPreferredSize(new Dimension(900,900));
        frame.getContentPane().add(b);
        frame.pack();
    }
 
    public static void main(String[] args) {
        new JButtonTest();
    }
}
