package Objetos_moviles;
import java.awt.geom.Rectangle2D;
import java.util.LinkedList;

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
		estrategia_vuelo = new IdaYvuelta();//aca hay que poner de derecha a izquierda
		this.blindaje = new Blindaje((short)1000);
		Vector2D p = ubicacion.XY();
		Cuerpo = new Rectangle2D.Double( p.x,p.y,3,3);
		PistolaLaser pistola_laser = new PistolaLaser(bando , new LineaRectaDown());
		LanzadorMisiles lanzador_misiles = new LanzadorMisiles(bando, new MovDirigido());
		LanzadorCohetes lanzador_cohetes = new LanzadorCohetes(bando , new LineaRectaDown());
		
		weapons.add( pistola_laser );
		weapons.add( lanzador_misiles );
		weapons.add( lanzador_cohetes );
	}
	
	protected void Huyan(){
		Escenario escenario = escenario.getInstance();
		// buscar tipo generico Collection
		LinkedList<ObjetosMoviles> todoLoQueEstaEnJuego = escenario.objetosVivos();
		for ( int j = 0  ; j == todoLoQueEstaEnJuego.size() ; j=j+1 ){
			ObjetosMoviles elemento = todoLoQueEstaEnJuego.get( j );
			if ( this.condicion(elemento) )this.run();
		}
	}
	
	protected void run( ObjetosMoviles elemento ){
		elemento.CambiarEstrategiaDeVuelo( new LineaRectaUp() );
	}
	
	// Falta metodo Condicion
}
