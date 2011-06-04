package Objetos_moviles;
import java.awt.geom.Rectangle2D;
import Excepciones.GameOverException;
import Mapa.Vector2D;
import Armas.*;
import Mapa.*;

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
		bando = ObjetosMoviles.BandoEnemigo();
		puntos = 20; 
		Velocidad = 5;
		estrategia_vuelo = new IdaYvuelta();
		Blindaje blindaje = new Blindaje();
		blindaje.Blindaje( 100 );
		Vector2D p = ubicacion.XY();
		Cuerpo = new Rectangle2D.Double( p.x,p.y,5,5);
		PistolaLaser pistola_laser = new PistolaLaser();
		pistolar_laser.PistolaLaser( bando , new LineaRectaDown() )
		weapons.add( pistola_laser );
	}
	
	
}
