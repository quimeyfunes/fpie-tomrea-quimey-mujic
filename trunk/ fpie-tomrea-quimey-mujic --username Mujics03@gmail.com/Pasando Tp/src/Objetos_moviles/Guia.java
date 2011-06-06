package Objetos_moviles;

import java.util.LinkedList;

import Escenario.Escenario;
import Armas.*;

public class Guia extends Voladores
{
	public Guia(double x, double y)
	{
		this.constructor(x, y, this);
	}
	
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
		this.Huyan();
	}
	
	private boolean condicion(ObjetosMoviles elem){
		return (elem != this) && (elem.EstaVivo() ) && ( elem.getBando()==this.bando) && (elem.PuedeManejarItems());
	}
	
	public void EstadoCorrecto(){
		bando = ObjetosMoviles.BandoEnemigo();
		puntos = 0; 
		Velocidad = 10;
		estrategia_vuelo = new IdaYvuelta();//aca hay que poner de derecha a izquierda
		this.blindaje = new Blindaje((short)1000);
		this.ConfigurarCuerpo(3,3);
		PistolaLaser pistola_laser = new PistolaLaser(bando , new LineaRectaDown());
		LanzadorMisiles lanzador_misiles = new LanzadorMisiles(bando, new MovDirigido());
		LanzadorCohetes lanzador_cohetes = new LanzadorCohetes(bando , new LineaRectaDown());
		
		weapons.add( pistola_laser );
		weapons.add( lanzador_misiles );
		weapons.add( lanzador_cohetes );
	}
	
	protected void Huyan(){
		Escenario escenario = Escenario.getInstance();
		// buscar tipo generico Collection
		LinkedList<ObjetosMoviles> todoLoQueEstaEnJuego = escenario.objetosVivos();
		for ( int j = 0  ; j == todoLoQueEstaEnJuego.size() ; j=j+1 ){
			ObjetosMoviles elemento = todoLoQueEstaEnJuego.get( j );
			if ( this.condicion(elemento) )this.run(elemento);
		}
	}
	
	protected void run( ObjetosMoviles elemento ){
		elemento.CambiarEstrategiaDeVuelo( new LineaRectaUp() );
	}
}
