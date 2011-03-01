import java.awt.Image;
import java.awt.Rectangle;

public class Pelota extends Objeto {
	
	public Pelota(int posX, int posY, Image image) {
		
		super(posX, posY, image);
	}
	
	public Rectangle getPerimetro() { 
		
		return new Rectangle(getPosX() + 20, getPosY() + 24, 23, 23);
	}
}
