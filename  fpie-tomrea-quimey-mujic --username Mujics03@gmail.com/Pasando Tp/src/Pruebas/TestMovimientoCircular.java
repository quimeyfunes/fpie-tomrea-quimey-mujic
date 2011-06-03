package Pruebas;


import java.awt.Point;


import org.junit.Assert;
import org.junit.Before;

public class TestMovimientoCircular {
	private Explorador Avion;
	private Point puntoCentralPrueba;
	private Point radio;
	
	@Before
	public void setUp() throws Exception {
		
		avion = new Explorador(800,800)();

		puntoCentralPrueba  = new Point(800,( 800 - (Circular.radioStandarSegunDistancia(800,800) )  ));

		radio = Circular.radioStandarSegunDistancia(800,800);
		
	}
	
	public void testMovimiento() {
		for( int i = 0 ; i < 2345; i++ ){
			avion.moverseIAsegunVel();
		}
		Point distancia = puntoCentralPrueba.dist(avion.getPosicion );
		Boolean booleano = ( distancia >= (radio - 1) ) || (distancia < ( radio + 1 ) )//debido a redondeo debo tener en cuenta incerteza
		Assert.assertEquals( booleano ,  1E-4);
		
		
		for( int i = 0 ; i < 1456; i++ ){
			avion.moverseIAsegunVel();
		}

		distancia = puntoCentralPrueba.dist(avion.getPosicion );
		booleano = ( distancia >= (radio - 1) ) || (distancia < ( radio + 1 ) ); 
		Assert.assertEquals( booleano ,  1E-4);
		

	
	}
}
