package Vistas;

import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.vista.Ventana;

public class VentanaPrincipal extends Ventana {

	public VentanaPrincipal(ControladorJuego cont) {
		super(222,242,cont);
		this.setTitle("Ejemplo");
	}

	private static final long serialVersionUID = 1L;

}
