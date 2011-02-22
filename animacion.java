import java.awt.Image;
import java.util.ArrayList;

public class animacion {
	
	private ArrayList cuadros;
	private int indiceCuadroActual;
	private long tiempoDeAnimacion;
	private long duracionTotal;
	
	public animacion() {
		
		cuadros = new ArrayList();
		duracionTotal = 0;
		iniciar();
	}
	
	public class cuadroDeAnimacion {
		
		Image imagen;
		long tiempoFinal;
		
		public cuadroDeAnimacion() {
			
			this.imagen = null;
			this.tiempoFinal = 0;
		}
		
		public cuadroDeAnimacion(Image imagen, long tiempoFinal) {
			
			this.imagen = imagen;
			this.tiempoFinal = tiempoFinal;
		}
		
		public Image getImagen() {
			
			return imagen;
		}
		
		public long getTiempoFinal() {
			
			return tiempoFinal;
		}
		
		public void setImagen(Image imagen) {
			this.imagen = imagen;
		}
		
		public void setTiempoFinal(long tiempoFinal) {
			
			this.tiempoFinal = tiempoFinal;
		}
	}
	
	public synchronized void sumaCuadro(Image imagen, long duracion) {
		
		duracionTotal += duracion;
		cuadros.add(new cuadroDeAnimacion(imagen, duracionTotal));
	}
	
	public synchronized void iniciar() {
		
		tiempoDeAnimacion = 0;
		indiceCuadroActual = 0;
	}
	
	public synchronized void actualiza(long tiempoTranscurrido) {
		
		if(cuadros.size() > 1) {
			
			tiempoDeAnimacion += tiempoTranscurrido;
			
			if(tiempoDeAnimacion >= duracionTotal) {
				
				tiempoDeAnimacion = tiempoDeAnimacion % duracionTotal;
				indiceCuadroActual = 0;
			}
			
			while(tiempoDeAnimacion > getCuadro(indiceCuadroActual).tiempoFinal) {
				
				indiceCuadroActual++;
			}
		}
	}
	
	public synchronized Image getImagen() {
		
		if (cuadros.size() == 0) {
			
			return null;
		}
		
		else {
			
			return getCuadro(indiceCuadroActual).imagen;
		}
	}
	
	private cuadroDeAnimacion getCuadro(int i) {
		
		return (cuadroDeAnimacion)cuadros.get(i);
	}
}
