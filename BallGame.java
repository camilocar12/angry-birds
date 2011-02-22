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
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class BallGame extends JFrame implements Runnable, KeyListener {
	
	private static final long serialVersionUID = -4561387616954048688L;
	private static final int WIDTH = 1000;
	private static final int HEIGHT = 625;
	private int direccion;
	private Image dbImage;
	private Image fondo;
	private Graphics dbg;
	private Canasta basket;
	private Pelota ball;
	private animacion animBall;
	
	public void run() {
	
	}
	
	public void actualiza() {
	
	}
	
	public void checaColision() {
	
	}
	
	public void paint(Graphics g) {
	
	}
	
	public void paint1() {
	
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
