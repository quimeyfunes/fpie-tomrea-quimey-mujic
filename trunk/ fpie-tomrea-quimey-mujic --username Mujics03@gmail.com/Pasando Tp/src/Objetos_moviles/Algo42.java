package Objetos_moviles; 
import EstrategiasDeMov.LineaRectaUp;
import Excepciones.GameOverException;
import Armas.*;

public class Algo42 extends Voladores{
	
	protected void DESTRUCTOR() throws GameOverException {
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
		
		this.ConfigurarCuerpo(4,4);
		
		PistolaLaser pistola_laser = new PistolaLaser( this.bando ,new LineaRectaUp());
		this.weapons.add( pistola_laser );
	}

	@Override
	protected void Actuar() {
		// TODO Auto-generated method stub
		
	}
}
