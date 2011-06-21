package Vistas;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Sonido.Sound;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.vista.Ventana;

public class VentanaPrincipal extends Ventana implements KeyListener {
	
	private Sound testsong;

	public VentanaPrincipal(ControladorJuego cont,int ancho,int alto) {
		super(ancho,alto,cont);
		this.setTitle("Algo42 contra el mundo");
		this.addKeyListener(this);
		testsong = new Sound("Laguerradelasgalaxias.mid");
		testsong.playSound();
		
	}

	private static final long serialVersionUID = 1L;

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode()==KeyEvent.VK_P){
			this.controlador.detenerJuego();
		}
		if(e.getKeyCode()==KeyEvent.VK_K){
			this.controlador.comenzarJuego();
		}
		if(e.getKeyCode()==KeyEvent.VK_S){
			this.testsong.stopSound();
		}
		if(e.getKeyCode()==KeyEvent.VK_A){
			this.testsong.playSound();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
		

}
