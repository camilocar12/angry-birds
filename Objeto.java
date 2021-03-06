import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Rectangle;

public class Objeto {
	
	private int posX;
	private int posY;
	private ImageIcon icono;
	
	public Objeto(int posX, int posY, Image image) {
		
		this.posX = posX;
		this.posY = posY;
		icono = new ImageIcon(image);
	}
	
	public void setPosX(int posX) { 
	                                                       
			this.posX = posX;
	}   
                                                     
	public void setPosY(int posY) { 
	                                                  
		this.posY = posY;
	} 
                                                  
	public void setImageIcon(ImageIcon icono) {
                                                  
		this.icono = icono;
	}
	
	public int getPosX() {

        return posX;
    }

    public int getPosY() { 

        return posY;
    }

    public ImageIcon getImageIcon() {

        return icono;
    }

    public int getAncho() { 

        return icono.getIconWidth();
    }

    public int getAlto() {

        return icono.getIconHeight();
  }

  public Image getImagenI() {

  		return icono.getImage();
  }
  
  public Rectangle getPerimetro() {
  		
 		return new Rectangle(getPosX(), getPosY(),getAncho(), getAlto());
  }
  
  public boolean intersecta(Objeto obj) {
  	
  		return getPerimetro().intersects(obj.getPerimetro());
  }
  
}
