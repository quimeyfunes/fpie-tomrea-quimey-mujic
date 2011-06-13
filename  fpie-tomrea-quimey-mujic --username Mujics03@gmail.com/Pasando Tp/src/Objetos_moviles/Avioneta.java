package Objetos_moviles;
import Vistas.VistaAvioneta;
import ar.uba.fi.algo3.titiritero.Dibujable;
import Armas.*;
import EstrategiasDeMov.IdaYvuelta;
import EstrategiasDeMov.LineaRectaDown;

public class Avioneta extends Voladores {
	
	public void Actuar(){
		if ( Timing >= 35 ) {
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
		this.Velocidad = 4;
		this.estrategia_vuelo = new IdaYvuelta();
		this.blindaje = new Blindaje((short)100);;
		
		this.ConfigurarCuerpo(6,6);
		
		PistolaLaser pistola_laser = new PistolaLaser(this.bando,new LineaRectaDown());
		this.weapons.add( pistola_laser );
	}

	@Override
	public Dibujable getVista() {
		return new VistaAvioneta();
	}
	
	
	
	
}
