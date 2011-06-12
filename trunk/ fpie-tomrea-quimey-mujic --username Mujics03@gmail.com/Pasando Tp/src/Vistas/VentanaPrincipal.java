package Vistas;

import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.vista.Ventana;

public class VentanaPrincipal extends Ventana {

	public VentanaPrincipal(ControladorJuego cont,int ancho,int alto) {
		super(ancho,alto,cont);
		this.setTitle("Ejemplo");
	}

	private static final long serialVersionUID = 1L;

}
