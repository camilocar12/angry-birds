
package angrybirds;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Tablero extends JPanel implements ActionListener{
    
    private final int INITIAL_X = 100;
    private final int INITIAL_Y = 420;
    private final int DELAY =50;
    private Timer timer;
    private int x, y;
    private int secuencia;

    public Tablero(){
        this.secuencia = 0;
        initBoard();
    }

    private void initBoard() {
        setBackground(Color.WHITE);
       
        x = INITIAL_X;
        y = INITIAL_Y;
        //Fires one or more ActionEvents at specified intervals.
        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image fondo = loadImage("fondo.png");
        g.drawImage(fondo, 0, 0, null);
        
        Image pajaro = loadImage("pajaro.png");
        //g.drawImage(pajaro, x, y,x+80, y +80,0,0,250,246,this);
        g.drawImage(pajaro, x, y,x+80,y+(42560/813),(this.secuencia*(813/2)),0,(this.secuencia*(813/2))+(813/2),266,this);
        g.drawRect(x, y, 80,(42560/813));
        /*g.drawImage(pajaro, 430,460 , 100, 100, null);
        g.drawRect(440,467, 80,80);*/
        
        Image cerdo = loadImage("cerdo.gif");
       /* g.drawImage(cerdo, 0, 0,97,(187/2),500,500,597,(1187/2),this);
        g.drawRect(0,0,97,(187/2));*/
        g.drawImage(cerdo, 430,460 , 100, 100, null);
        g.drawRect(440,467, 80,80);
        
    }

   
    @Override
    public void actionPerformed(ActionEvent e) {
        x += 5;
        if(this.secuencia == 5){
          this.secuencia = 0;
        }else 
            this.secuencia++;
        
       //TAMANO MAXIMO. ESTO DEBE SER AJUSTADO A PARTIR DE VARIABLES. 
       if(x>=800){
           x=INITIAL_X;
       repaint();
       }
               
       }
    
    
    public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }

   
}
