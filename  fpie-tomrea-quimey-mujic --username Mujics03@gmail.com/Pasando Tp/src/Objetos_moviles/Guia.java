package Objetos_moviles;
import java.awt.geom.Rectangle2D;

import Escenario.Escenario;
import Excepciones.GameOverException;
import Mapa.Vector2D;
import Armas.*;
import Mapa.*;

public class Guia extends Voladores{
	
	public void Actuar(){
		if ( Timing >= 2 ) {
			Timing = 0;
			this.seleccionarSiguienteArma();
			this.disparar();
		} else { 
			this.moverseIAsegunVel();
			Timing = Timing + 1;
		}
	}
	
	protected void DESTRUCTOR(){
		Vivo = false;
		this.Huyan;
	}
	
	public void EstadoCorrecto(){
		bando = ObjetosMoviles.BandoEnemigo();
		puntos = 0; 
		Velocidad = 10;
		estrategia_vuelo = new IdaYvuelta();
		Blindaje blindaje = new Blindaje();
		blindaje.Blindaje( 1000 );
		Vector2D p = ubicacion.XY();
		Cuerpo = new Rectangle2D.Double( p.x,p.y,3,3);
		PistolaLaser pistola_laser = new PistolaLaser();
		pistolar_laser.PistolaLaser( bando , new LineaRectaDown() );
		LanzadorMisiles lanzador_misiles = new LanzadorMisiles();
		lanzadorMisiles.LanzadorMisiles( bando, new MovDirigido() );
		LanzadorCohetes lanzador_cohetes = new LanzadorCohetes();
		lanzador_cohetes.LanzadorCohetes( bando , new LineaRectaDown() );
		weapons.add( pistola_laser );
		weapons.add( lanzador_misiles );
		weapons.add( lanzador_cohetes );
		weapons.add( lanzador_misiles );
		weapons.add( lanzador_cohetes );
	}
	
	protected void Huyan(){
		Escenario escenario = escenario.getInstance();
		// buscar tipo generico Collection
		Collection todoLoQueEstaEnJuego = escenario.objetosVivos();
		int j; 
		for ( j = 0 , j = todoLoQueEstaEnJuego.size() , j++ ){
			ObjetosMoviles elemento = todoLoQueEstaEnJuego.get( j );
			if ( this.condicion(elemento) )this.run();
		}
	}
	
	protected void run( ObjetosMoviles elemento ){
		elemento.CambiarEstrategiaDeVuelo( new LineaRectaUp() );
	}
	
}
