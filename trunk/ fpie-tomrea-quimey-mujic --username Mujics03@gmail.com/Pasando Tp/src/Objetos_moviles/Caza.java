package Objetos_moviles;
import java.awt.geom.Rectangle2D;
import Excepciones.GameOverException;
import Mapa.Vector2D;
import Armas.*;
import Mapa.*;

public class Caza extends Voladores{
	
	public void Actuar(){
		if ( Timing >= 5 ) {
			Timing = 0;
			this.seleccionarSiguienteArma();
			this.disparar();
		} else { 
			this.moverseIAsegunVel();
			Timing = Timing + 1;
		}
	}
	
	public void DESTRUCTOR(){
		vivo = false;
		ItemVida item_vida = new ItemVida();
		// falta la funcion crear en 
	}
	
	public void EstadoCorrecto(){
		bando = ObjetosMoviles.BandoEnemigo();
		puntos = 30; 
		Velocidad = 3;
		estrategia_vuelo = new LineaRectaDown();
		Blindaje blindaje = new Blindaje();
		blindaje.Blindaje( 100 );
		Vector2D p = ubicacion.XY();
		Cuerpo = new Rectangle2D.Double( p.x,p.y,4,4);
		PistolaLaser pistola_laser = new PistolaLaser();
		pistolar_laser.PistolaLaser( bando , new LineaRectaDown() );
		LanzadorCohetes lanzador_cohetes = new LanzadorCohetes();
		lanzador_cohetes.LanzadorCohetes( bando , new LineaRectaDown() );
		weapons.add( pistola_laser );
		weapons.add( lanzador_cohetes );
	}
}
