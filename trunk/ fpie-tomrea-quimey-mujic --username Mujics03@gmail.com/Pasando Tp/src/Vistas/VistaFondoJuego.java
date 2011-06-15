package Vistas;


import java.awt.Graphics;

import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Imagen;



public class VistaFondoJuego extends Imagen {
	
	
	
	public VistaFondoJuego(){
		setNombreArchivoImagen("fondojuego.jpg");
		
	}
	
	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
		Graphics grafico = (Graphics)superficeDeDibujo.getBuffer();
		grafico.drawImage(this.imagen,0, 0, null);
	}
	

}
