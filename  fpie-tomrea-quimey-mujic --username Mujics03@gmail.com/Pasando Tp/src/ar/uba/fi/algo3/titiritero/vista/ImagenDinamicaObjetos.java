package ar.uba.fi.algo3.titiritero.vista;
import java.awt.Graphics;
import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;

public class ImagenDinamicaObjetos extends Imagen{
	
    private Posicionable posicionable;
	
		
		public ImagenDinamicaObjetos(){		
		}

		public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
			Graphics grafico = (Graphics)superficeDeDibujo.getBuffer();
			boolean EstaVivo = this.posicionable.EstaVivo();
			if( EstaVivo ){
				grafico.drawImage(this.imagen, this.posicionable.getX(), this.posicionable.getY(), null);
			} else 
				this.imagen=null;
				grafico.drawImage(this.imagen, this.posicionable.getX(), this.posicionable.getY(), null);
			}
			
		
		    
		
		public void setPosicionable(Posicionable posiciona) {
			this.posicionable = posiciona;
		}

		public Posicionable getMonitoreable() {
			return this.posicionable;
		}




}


