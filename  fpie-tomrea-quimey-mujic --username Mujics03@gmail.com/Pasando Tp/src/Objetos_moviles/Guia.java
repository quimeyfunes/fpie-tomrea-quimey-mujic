package Objetos_moviles;

import java.util.LinkedList;

import Vistas.VistaGuia;
import ar.uba.fi.algo3.titiritero.DibujableExtra;

import Escenario.Escenario;
import EstrategiasDeMov.DerechaIzquierda;
import EstrategiasDeMov.LineaRectaDown;
import EstrategiasDeMov.LineaRectaUp;
import EstrategiasDeMov.MovDirigido;
import Armas.*;

public class Guia extends Voladores
{
	public Guia(double x, double y)
	{
		this.constructor(x, y, this);
	}
	
	public void Actuar(){
		if ( Timing >= 60 ) {
			Timing = 0;
			this.seleccionarSiguienteArma();
			this.disparar();
		} else { 
			this.moverseIAsegunVel();
			Timing = Timing + 1;
		}
	}
	
	protected void Destructor(){
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
		estrategia_vuelo = new DerechaIzquierda();
		this.blindaje = new Blindaje((short)1000);
		this.ConfigurarCuerpo(10,10);
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
		for ( int j = 0  ; j < todoLoQueEstaEnJuego.size() ; j=j+1 ){
			ObjetosMoviles elemento = todoLoQueEstaEnJuego.get( j );
			if ( this.condicion(elemento) )this.run(elemento);
		}
	}
	
	protected void run( ObjetosMoviles elemento ){
		elemento.CambiarEstrategiaDeVuelo( new LineaRectaUp() );
	}

	@Override
	public DibujableExtra getVista()
	{
		return new VistaGuia();
	}
}
