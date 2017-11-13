
package angrybirds;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AngryBirds extends JFrame {
    
    public AngryBirds() {
       initUI();
       
    }
private void initUI() {

        add(new Tablero());
        setSize(800,600);
        setTitle("Angry Birds");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
    }


    public static void main(String[] args) {
       AngryBirds ex = new AngryBirds();
        ex.setVisible(true); 
        
    }
    
}
