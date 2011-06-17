package Vistas;
import java.awt.Graphics;

import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Imagen;



public class VistaTutorialBoton extends Imagen{
	
	private static int posX = 350;
	private static int posY = 350;
	private static int ancho = 330;
	private static int alto = 60;
	
	public VistaTutorialBoton(){
		setNombreArchivoImagen("tutorial.jpg");
		
	}
	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
		Graphics grafico = (Graphics)superficeDeDibujo.getBuffer();
		grafico.drawImage(this.imagen,posX, posY, null);
	}
	
	public static int getPosX(){
		return posX;
	}
	
	public static int getPosY(){
		return posY;
	}

	public static int getAncho() {
		return ancho;
	}

	public static int getAlto() {
		return alto;
	}
}



 