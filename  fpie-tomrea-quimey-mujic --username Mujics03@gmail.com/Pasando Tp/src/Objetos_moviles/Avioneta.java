package Objetos_moviles;
import java.awt.geom.Rectangle2D;
import Mapa.Vector2D;
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
	
	public void EstadoCorrecto(){
		this.bando = ObjetosMoviles.BandoEnemigo();
		this.puntos = 20; 
		this.Velocidad = 5;
		this.estrategia_vuelo = new IdaYvuelta();
		this.blindaje = new Blindaje((short)100);;
		Vector2D p = ubicacion.XY();
		this.Cuerpo = new Rectangle2D.Double( p.x,p.y,5,5);
		PistolaLaser pistola_laser = new PistolaLaser(this.bando,new LineaRectaDown());
		this.weapons.add( pistola_laser );
	}
	
	
}
