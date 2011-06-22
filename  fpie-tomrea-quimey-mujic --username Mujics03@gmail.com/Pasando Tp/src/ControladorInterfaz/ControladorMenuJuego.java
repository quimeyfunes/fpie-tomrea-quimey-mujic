package ControladorInterfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Sonido.Sound;
import ar.uba.fi.algo3.titiritero.ControladorJuego;

public class ControladorMenuJuego implements ActionListener{

	private ControladorJuego controlador;
	private Sound testSong;

	public ControladorMenuJuego(ControladorJuego controlador, Sound testsong) {
		this.controlador = controlador;
		this.testSong = testsong;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
	String opcion = arg0.getActionCommand();
	
	if (opcion.equalsIgnoreCase("Pausar/Despausar (p)") ){
		 controlador.detenerJuego();
		 controlador.changePausado();
	}
	if (opcion.equalsIgnoreCase("Salir") ){
		System.exit(0);
	}
	if (opcion.equalsIgnoreCase("Guardar") ){
		PopUpUsuario popUp = new PopUpUsuario();
		popUp.start();
		popUp.setVisible(true);
		popUp.setSize(80, 80);
		controlador.detenerJuego();
		controlador.changePausado();
		
	}
	if (opcion.equalsIgnoreCase("Activar (a)") ){
		if(!this.testSong.estaSonando())
			this.testSong.playSound();
		
	}
	if (opcion.equalsIgnoreCase("Desactivar (s)") ){
		this.testSong.stopSound();
	}
	 
	
	}
	
	
	
	
}