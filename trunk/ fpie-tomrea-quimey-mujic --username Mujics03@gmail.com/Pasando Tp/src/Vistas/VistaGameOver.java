package Vistas;

import java.awt.Graphics;

import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Imagen;


public class VistaGameOver extends Imagen {
	public VistaGameOver() {
		setNombreArchivoImagen("Gameover.jpg");
	}
	
	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
		Graphics grafico = (Graphics)superficeDeDibujo.getBuffer();
		grafico.drawImage(this.imagen, 50, 50, null);
	}
}