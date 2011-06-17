package Pruebas;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;

import ar.uba.fi.algo3.titiritero.ControladorJuego;

import Escenario.Escenario;
import EstrategiasDeMov.Circular;
import Mapa.Vector2D;
import Objetos_moviles.Exploradores;

public class TestMovimientoCircular extends TestCase {
	private Exploradores Avion;
	private Vector2D puntoCentralPrueba;
	private double radio;
	private double posicionX;
	private double posicionY;
	
	@Before
	public void setUp() throws Exception {
		Escenario.reiniciarEscenario();
		Escenario.InicializarEscenario(new ControladorJuego(false));
		
		 posicionX=300;
		 posicionY=300;
		
		Avion = new Exploradores((double)posicionX,(double)posicionY);

		puntoCentralPrueba  = new Vector2D(posicionX,( posicionY - (Circular.radioStandarSegunDistancia((double)posicionX,(double)posicionY) )));

		radio = Circular.radioStandarSegunDistancia((double)posicionX,(double)posicionY);
		
	}
	
	private boolean ComprobarDistancia(){
		
		double distancia = this.puntoCentralPrueba.distance(Avion.getPosicion() );
		Boolean booleano = ( distancia >= (radio - 1) ) && (distancia < ( radio + 1 ) );
		//debido a redondeo debo tener en cuenta incerteza
		return booleano;
	}
	
	public void testMovimiento() {
		
		double PerimetroCirculo = 2*(Math.PI)* (this.radio);
		double turnos = PerimetroCirculo/3/4;
		//consigo el perimetro del circulo, divido por la cantidad de movimientos por turno del avion
		//luego, divido por 4, ya que voy a verificar que llegue a 1/4 del recorrido
		//O sea, el extremo que esta mas a la derecha del circulo, respecto a su centro
		
		for( int i = 0 ; i < turnos; i++ ){
			Avion.moverseIAsegunVel();
		}
		Assert.assertTrue( 	this.ComprobarDistancia() );
		
		Assert.assertTrue( (1>(Avion.getPosicion().distance( (posicionX+radio),(posicionY-radio) )) ) );
	
		//el resto son comprobacion para ver que no se salga de la distancia del radio
		for( int i = 0 ; i < 2414; i++ ){
			Avion.moverseIAsegunVel();
		}
 
		Assert.assertTrue( 	this.ComprobarDistancia() );
		
		for( int i=0;i<7345;i++){
			Avion.moverseIAsegunVel();			
		}
		
		Assert.assertTrue( 	this.ComprobarDistancia() );
		
		for( int i=0;i<2599;i++){
			Avion.moverseIAsegunVel();			
		}
		
		Assert.assertTrue( 	this.ComprobarDistancia() );
		

	
	}
}
