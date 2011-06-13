package Objetos_moviles; 
import java.awt.event.KeyEvent;

import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.KeyPressedObservador;
import Vistas.VistaAlgo42;
import EstrategiasDeMov.LineaRectaUp;
import Excepciones.GameOverException;
import Armas.*;

public class Algo42 extends Voladores implements KeyPressedObservador{
	
	public void Destructor() throws GameOverException {
		Vivo = false; 
		throw new GameOverException();
	}
	
	public Algo42(double x, double y)
	{
		this.constructor(x, y, this);
	}
	
	protected void EstadoCorrecto(){ 
		this.bando = ObjetosMoviles.BandoUsuario();
		this.Velocidad = 5;
		this.blindaje = new Blindaje((short) 150);
		
		this.ConfigurarCuerpo(6,6);
		
		PistolaLaser pistola_laser = new PistolaLaser( this.bando ,new LineaRectaUp());
		this.weapons.add( pistola_laser );
	}

	@Override
	protected void Actuar() {
		
	}
	@Override
	public void keyPressed(KeyEvent event)
	{
		if(event.getKeyCode() == KeyEvent.VK_UP)
			this.ArribaSpeed();
		if(event.getKeyCode() == KeyEvent.VK_DOWN)
			this.AbajoSpeed();
		if(event.getKeyCode() == KeyEvent.VK_RIGHT)
			this.DerechaSpeed();
		if(event.getKeyCode() == KeyEvent.VK_LEFT)
			this.IzquierdaSpeed();
		if(event.getKeyCode()== KeyEvent.VK_SPACE)
			this.disparar();
	}

	@Override
	public Dibujable getVista() {
		return new VistaAlgo42();
	}
	
	private void ArribaSpeed(){
		for(int i=0;i<Velocidad;i++){
			this.arriba();
		}
	}
	
	private void AbajoSpeed(){
		for(int i=0;i<Velocidad;i++){
			this.abajo();
		}
	}
	
	private void DerechaSpeed(){
		for(int i=0;i<Velocidad;i++){
			this.derecha();
		}
	}
	
	private void IzquierdaSpeed(){
		for(int i=0;i<Velocidad;i++){
			this.izquierda();
		}
		
		
	}
	
}
