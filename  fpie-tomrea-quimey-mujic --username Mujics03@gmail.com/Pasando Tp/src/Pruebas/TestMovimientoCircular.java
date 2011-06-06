package Pruebas;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;

import Mapa.Vector2D;
import Objetos_moviles.Circular;
import Objetos_moviles.Exploradores;

public class TestMovimientoCircular extends TestCase {
	private Exploradores Avion;
	private Vector2D puntoCentralPrueba;
	private double radio;
	
	@Before
	public void setUp() throws Exception {
		
		Avion = new Exploradores((double)800,(double)800);

		puntoCentralPrueba  = new Vector2D(800,( 800 - (Circular.radioStandarSegunDistancia((double)800,(double)800) )  ));

		radio = Circular.radioStandarSegunDistancia((double)800,(double)800);
		
	}
	
	public void testMovimiento() {
		for( int i = 0 ; i < 2345; i++ ){
			Avion.moverseIAsegunVel();
		}
		double distancia = puntoCentralPrueba.distance(Avion.getPosicion() );
		Boolean booleano = ( distancia >= (radio - 1) ) || (distancia < ( radio + 1 ) );//debido a redondeo debo tener en cuenta incerteza
		Assert.assertTrue( booleano );
		
		
		for( int i = 0 ; i < 1456; i++ ){
			Avion.moverseIAsegunVel();
		}

		distancia = puntoCentralPrueba.distance(Avion.getPosicion() );
		booleano = ( distancia >= (radio - 1) ) || (distancia < ( radio + 1 ) ); 
		Assert.assertTrue( booleano );
		

	
	}
}
