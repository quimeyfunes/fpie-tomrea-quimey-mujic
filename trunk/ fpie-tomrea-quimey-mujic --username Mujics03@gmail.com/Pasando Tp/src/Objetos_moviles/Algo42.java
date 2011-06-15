package Objetos_moviles; 
import java.awt.event.KeyEvent;

import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.KeyPressedObservador;
import Vistas.VistaAlgo42;
import EstrategiasDeMov.LineaRectaUp;
import Excepciones.GameOverException;
import Armas.*;

public class Algo42 extends Voladores implements KeyPressedObservador{
	
	private boolean banderaDisparar=false;
	private boolean banderacambiarArma=false;
	
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
		
		this.ConfigurarCuerpo(30,30);
		
		PistolaLaser pistola_laser = new PistolaLaser( this.bando ,new LineaRectaUp());
		this.weapons.add( pistola_laser );
	}

	@Override
	protected void Actuar() {
		if (this.banderaDisparar){
			this.disparar();
			this.banderaDisparar=false;//dispara en su turno
		}
		if(this.banderacambiarArma){
			this.seleccionarSiguienteArma();
			this.banderacambiarArma=false;
		}
		
		this.VerificarColision();
		
	}
	@Override
	public synchronized void keyPressed(KeyEvent event)
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
			this.banderaDisparar=true;  
		if(event.getKeyCode()== KeyEvent.VK_Z){
			this.banderacambiarArma=true;
		}
			
	}

	@Override
	public Dibujable getVista() {
		return new VistaAlgo42();
	}
	
	private synchronized void ArribaSpeed(){
		for(int i=0;i<Velocidad;i++){
			this.arriba();
		}
	}
	
	private synchronized void AbajoSpeed(){
		for(int i=0;i<Velocidad;i++){
			this.abajo();
		}
	}
	
	private synchronized void DerechaSpeed(){
		for(int i=0;i<Velocidad;i++){
			this.derecha();
		}
	}
	
	private synchronized void IzquierdaSpeed(){
		for(int i=0;i<Velocidad;i++){
			this.izquierda();
		}
		
		
	}
	
}
