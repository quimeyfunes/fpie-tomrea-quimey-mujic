package Objetos_moviles;
import Armas.*;

public class Avioneta extends Voladores {
	
	public void Actuar(){
		if ( Timing >= 5 ) {
			Timing = 0;
			this.disparar();
		} else { 
			this.moverseIAsegunVel();
			Timing = Timing + 1;
		}
	}
	
	public Avioneta(double x, double y)
	{
		this.constructor(x, y, this);
	}
	
	public void EstadoCorrecto(){
		
		this.bando = ObjetosMoviles.BandoEnemigo();
		this.puntos = 20; 
		this.Velocidad = 5;
		this.estrategia_vuelo = new IdaYvuelta();
		this.blindaje = new Blindaje((short)100);;
		
		this.ConfigurarCuerpo(5,5);
		
		PistolaLaser pistola_laser = new PistolaLaser(this.bando,new LineaRectaDown());
		this.weapons.add( pistola_laser );
	}
	
	
}
