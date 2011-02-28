import java.awt.Image;
import java.awt.Rectangle;

public class Canasta extends Objeto {
	
	public Canasta(int posX, int posY, Image image) {
		
		super(posX, posY, image);
	}
	
	public Rectangle getPerimetro() { 
		
		return new Rectangle(getPosX() + 4, getPosY() + 81, 109, 8);
	}
}
