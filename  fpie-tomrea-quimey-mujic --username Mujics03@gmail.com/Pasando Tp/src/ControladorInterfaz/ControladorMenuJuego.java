package ControladorInterfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ar.uba.fi.algo3.titiritero.ControladorJuego;

public class ControladorMenuJuego implements ActionListener{

	private ControladorJuego controlador;

	public ControladorMenuJuego(ControladorJuego controlador) {
		this.controlador = controlador;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
	String opcion = arg0.getActionCommand();
	
	if (opcion.equalsIgnoreCase("Pausar") ){
		System.out.println(arg0.toString());
		 controlador.detenerJuego();
	}
	if (opcion.equalsIgnoreCase("Salir") ){
		System.exit(0);
	}
	if (opcion.equalsIgnoreCase("Guardar") ){
		
	}
	if (opcion.equalsIgnoreCase("Activar") ){
		
	}
	if (opcion.equalsIgnoreCase("Desactivar") ){
		
	}
	 
		
	}
	
	
	
	
}