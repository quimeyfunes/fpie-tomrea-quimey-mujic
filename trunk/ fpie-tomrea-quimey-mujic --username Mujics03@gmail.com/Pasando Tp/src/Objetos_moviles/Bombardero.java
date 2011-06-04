package Objetos_moviles;
import java.awt.geom.Rectangle2D;
import Excepciones.GameOverException;
import Mapa.Vector2D;
import Armas.*;
import Mapa.*;

public class Bombardero extends Voladores{
	
	public void Actuar(){
		if ( Timing >= 6 ) {
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
		// verificar que item deja
	}
	
	public void EstadoCorrecto(){
		bando = ObjetosMoviles.BandoEnemigo();
		puntos = 30; 
		Velocidad = 1;
		estrategia_vuelo = new ZigZag();
		Blindaje blindaje = new Blindaje();
		blindaje.Blindaje( 200 );
		Vector2D p = ubicacion.XY();
		Cuerpo = new Rectangle2D.Double( p.x,p.y,8,8);
		PistolaLaser pistola_laser = new PistolaLaser();
		pistolar_laser.PistolaLaser( bando , new LineaRectaDown() );
		LanzadorMisiles lanzador_misiles = new LanzadorMisiles();
		lanzadorMisiles.LanzadorMisiles( bando, new MovDirigido() );
		LanzadorCohetes lanzador_cohetes = new LanzadorCohetes();
		lanzador_cohetes.LanzadorCohetes( bando , new LineaRectaDown() );
		weapons.add( pistola_laser );
		weapons.add( lanzador_misiles );
		weapons.add( lanzador_cohetes );
	}
	
}
