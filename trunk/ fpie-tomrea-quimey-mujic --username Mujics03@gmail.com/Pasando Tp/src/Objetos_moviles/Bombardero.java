package Objetos_moviles;
import java.awt.geom.Rectangle2D;
import Mapa.Vector2D;
import Armas.*;

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
		this.bando = ObjetosMoviles.BandoEnemigo();
		this.puntos = 30; 
		this.Velocidad = 1;
		this.estrategia_vuelo = new ZigZag();
		this.blindaje = new Blindaje((short)200);
		Vector2D p = ubicacion.XY();
		this.Cuerpo = new Rectangle2D.Double( p.x,p.y,8,8);
		PistolaLaser pistola_laser = new PistolaLaser( bando , new LineaRectaDown() );
		LanzadorMisiles lanzador_misiles = new LanzadorMisiles(bando, new MovDirigido());
		LanzadorCohetes lanzador_cohetes = new LanzadorCohetes(bando, new MovDirigido());
		this.weapons.add( pistola_laser );
		this.weapons.add( lanzador_misiles );
		this.weapons.add( lanzador_cohetes );
	}
	
}
