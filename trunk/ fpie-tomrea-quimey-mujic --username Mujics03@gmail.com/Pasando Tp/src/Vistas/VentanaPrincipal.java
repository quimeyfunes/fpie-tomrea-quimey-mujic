package Vistas;

import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import ControladorInterfaz.ControladorMenuJuego;
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
		inicializarMenus();
		
	}

	private static final long serialVersionUID = 1L;

	@Override
	public synchronized void keyPressed(KeyEvent e) {
		
		if (e.getKeyCode()==KeyEvent.VK_P){
			this.controlador.detenerJuego();
			System.out.println("parar juego");
		}
		if(e.getKeyCode()==KeyEvent.VK_K){
			this.controlador.comenzarJuego();
			System.out.println("comenzar juego");
			}
		
		if(e.getKeyCode()==KeyEvent.VK_S){
			this.testsong.stopSound();
		}
		if(e.getKeyCode()==KeyEvent.VK_A){
		if (!this.testsong.estaSonando()){this.testsong.playSound();}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	private void inicializarMenus() {

	     MenuBar mbarra = new MenuBar();

	     Menu m = new Menu( "Juego" );
	     MenuItem pausar = new MenuItem( "Pausar");
	     pausar.addActionListener(new ControladorMenuJuego(controlador,testsong));
	     m.add( pausar);

	     MenuItem guardar = new MenuItem( "Guardar");
	     guardar.addActionListener(new ControladorMenuJuego(controlador,testsong));
	     m.add( guardar );

	     m.addSeparator();
	     
	     MenuItem salir = new MenuItem( "Salir");
	     salir.addActionListener(new ControladorMenuJuego(controlador,testsong));
	     m.add(  salir );

	     mbarra.add( m );



	     m = new Menu( "Sonido" );

	     MenuItem activar = new MenuItem( "Activar (a)" ) ;
	     activar.addActionListener(new ControladorMenuJuego(controlador,testsong));
	     m.add( activar );

	     m.addSeparator();

	     MenuItem desactivar = new MenuItem( "Desactivar (s)" ) ;
	     desactivar.addActionListener(new ControladorMenuJuego(controlador,testsong));
	     m.add( desactivar );


	     mbarra.add( m );



	     setMenuBar( mbarra );
	     
	     

	     }
		

}
