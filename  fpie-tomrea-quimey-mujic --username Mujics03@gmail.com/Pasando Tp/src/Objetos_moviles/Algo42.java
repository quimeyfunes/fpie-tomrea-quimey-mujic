package Objetos_moviles; 
import java.awt.event.KeyEvent;

import ar.uba.fi.algo3.titiritero.DibujableExtra;
import ar.uba.fi.algo3.titiritero.KeyPressedObservador;
import Vistas.VistaAlgo42;
import EstrategiasDeMov.LineaRectaUp;
import Excepciones.GameOverException;
import Armas.*;

public class Algo42 extends Voladores implements KeyPressedObservador{
	
	private boolean banderaDisparar=false;
	private boolean banderacambiarArma=false;
	private boolean up=false;
	private boolean down=false;
	private boolean right=false;
	private boolean left=false;
	
	public void Destructor() throws GameOverException {
		Vivo = false; 
		//throw new GameOverException();
	}
	
	public Algo42(double x, double y)
	{
		this.constructor(x, y, this);
	}
	
	protected void EstadoCorrecto(){ 
		this.bando = ObjetosMoviles.BandoUsuario();
		this.Velocidad = 5;
		this.blindaje = new Blindaje((short) 250);
		
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
		
		if(this.right){
			this.DerechaSpeed();
			this.right=false;
		}
		if(this.left){
			this.IzquierdaSpeed();
			this.left=false;
		}
		if(this.up){
			this.ArribaSpeed();
			this.up=false;
		}
		if(this.down){
			this.AbajoSpeed();
			this.down=false;
		}
		
	}
	@Override
	public synchronized void keyPressed(KeyEvent event)
	{
		if(event.getKeyCode() == KeyEvent.VK_UP)
			this.up=true;
		if(event.getKeyCode() == KeyEvent.VK_DOWN)
			this.down=true;
		if(event.getKeyCode() == KeyEvent.VK_RIGHT)
			this.right=true;
		if(event.getKeyCode() == KeyEvent.VK_LEFT)
			this.left=true;
		if(event.getKeyCode()== KeyEvent.VK_SPACE)
			this.banderaDisparar=true;  
		if(event.getKeyCode()== KeyEvent.VK_Z)
			this.banderacambiarArma=true;
			
	}
	

	@Override
	public DibujableExtra getVista() {
		return new VistaAlgo42();
	}
	
	private synchronized void ArribaSpeed(){
		
		if(!this.EstaCercaAlAlimiteSuperior()){
			for(int i=0;i<Velocidad;i++){
				this.arriba();
				}
			}
		}
	
	private synchronized void AbajoSpeed(){
		if(!this.EstaCercaAlAlimiteInferior()){
			for(int i=0;i<Velocidad;i++){
				this.abajo();
				}
			}
		}
	
	private synchronized void DerechaSpeed(){
		if(!this.EstaCercaAlAlimiteDerecho()){
			for(int i=0;i<Velocidad;i++){
				this.derecha();
				}
			}
		}
	
	private synchronized void IzquierdaSpeed(){
		if(!this.EstaCercaAlAlimiteIzquierdo()){
			for(int i=0;i<Velocidad;i++){
				this.izquierda();
				}
			}
		}
	
}
