import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class BallGame extends JFrame implements Runnable, KeyListener {
	
	private static final long serialVersionUID = -4561387616954048688L;
	private static final int WIDTH = 1000;
	private static final int HEIGHT = 625;
	private int direccion;
	private int vidas;
	private Image dbImage;
	private Image fondo;
	private Graphics dbg;
	private Pelota ball;
	private Canasta basket;
	private animacion animBall;
	private long tiempoActual;
	
	
	public BallGame() {
		
		vidas = 5;
		fondo = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/fondo.jpg")); // fondo del JFrame
		int posX = WIDTH / 2; // posX de la pelota
		int posY = HEIGHT / 2; // posY de la pelota
		
		Image bola1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/basketball.gif"));
		Image bola2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/basketball2.gif"));
		Image bola3 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/basketball3.gif"));
		Image bola4 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/basketball4.gif"));
		
		animBall = new animacion();
		animBall.sumaCuadro(bola1, 100);
		animBall.sumaCuadro(bola2, 100);
		animBall.sumaCuadro(bola3, 100);
		animBall.sumaCuadro(bola4, 100);
		
		ball = new Pelota(posX, posY, bola1);
		
		Thread t = new Thread(this);
		t.start();
	}
	
	public void run() {
		
		tiempoActual = System.currentTimeMillis();
		while(vidas > 0) {
		
			actualiza();
			repaint();
		
			try	{
				// El thread se duerme.
				Thread.sleep (20);
			}
			catch (InterruptedException ex)	{
				System.out.println("Error en " + ex.toString());
			}
		}
	}
	
	public void actualiza() {

		long tiempoTranscurrido = System.currentTimeMillis() - tiempoActual;
		tiempoActual += tiempoTranscurrido;
		animBall.actualiza(tiempoTranscurrido);
	}
	
	public void checaColision() {
	
	}
	
	public void paint(Graphics g) {
		
		if(dbImage == null) {
			
			dbImage = createImage(this.getSize().width, this.getSize().height);
			dbg = dbImage.getGraphics();
		}
		dbg.setColor(getBackground());
		dbg.fillRect(0, 0, this.getSize().width, this.getSize().height);
		dbg.setColor(getForeground());
		paint1(dbg);
		g.drawImage(dbImage, 0, 0, this);
	}
	
	public void paint1(Graphics g) {
		
		g.drawImage(fondo, 0, 0, getSize().width, getSize().height, this);
				
		if(ball != null) {
			
			g.drawImage(animBall.getImagen(), ball.getPosX(), ball.getPosY(), this);
		}
		
		else {
			
			g.drawString("No se cargo la imagen...", 20, 20);
		}
	}
	
	public void keyPressed(KeyEvent e) {
	
	}
	
	public void keyTyped(KeyEvent e) {
	
	}
	
	public void keyReleased(KeyEvent e) {
	
	}
	public static void main (String args[]) {
		
		BallGame juego = new BallGame();
		juego.setSize(WIDTH, HEIGHT);
		juego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		juego.setVisible(true);
	}
}
