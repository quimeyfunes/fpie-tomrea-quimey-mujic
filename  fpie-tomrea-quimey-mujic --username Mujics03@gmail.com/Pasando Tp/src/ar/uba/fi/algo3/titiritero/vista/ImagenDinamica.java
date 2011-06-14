package ar.uba.fi.algo3.titiritero.vista;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.Monitoreable;
import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;

/*
 * Esta clase representa una imagen JPG abstrayendo al usuario de los detalles de Java2D
 * Simplemente requiere de una referencia al nombre del archivo JPG
 */
public class ImagenDinamica extends Imagen{
	
	public ImagenDinamica(){
		
	}

	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
		Graphics grafico = (Graphics)superficeDeDibujo.getBuffer();
		short vida = this.monitoreable.getBlindajeReferencia();
		if(vida > 145){
			grafico.drawImage(this.imagen, this.posicionable.getX(), this.posicionable.getY(), null);
			System.out.print(this.monitoreable.getBlindajeReferencia());
		}
		else if(vida < 130 && vida >=100){
			setNombreArchivoImagen("vida90.jpg");
			grafico.drawImage(this.imagen, this.posicionable.getX(), this.posicionable.getY(), null);
			System.out.print(this.monitoreable.getBlindajeReferencia());
		}
		else if(vida < 100  && vida >=80){
			setNombreArchivoImagen("vida40.jpg");
			grafico.drawImage(this.imagen, this.posicionable.getX(), this.posicionable.getY(), null);
			System.out.print(this.monitoreable.getBlindajeReferencia());
		}
		else if(this.monitoreable.getBlindajeReferencia() < 80){
			setNombreArchivoImagen("vida10.jpg");
			grafico.drawImage(this.imagen, this.posicionable.getX(), this.posicionable.getY(), null);
			System.out.print(this.monitoreable.getBlindajeReferencia());
		}
		
		
	}
	    
	
	public void setMonitoreable(Monitoreable monitoreable) {
		this.monitoreable = monitoreable;
	}

	public Monitoreable getMonitoreable() {
		return monitoreable;
	}


    private Monitoreable monitoreable;

}
