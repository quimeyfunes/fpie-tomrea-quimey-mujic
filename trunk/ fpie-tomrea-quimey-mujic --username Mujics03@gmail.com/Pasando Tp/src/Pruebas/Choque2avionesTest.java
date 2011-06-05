package Pruebas;
import junit.framework.*;
import Armas.Danio;
import Objetos_moviles.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Choque2avionesTest extends TestCase{
	// Testea el choque de algo42 contra una avioneta, y la esperada muerta de la avioneta despues 
	
	// Variables
	Algo42 algo42; 
	Avioneta avioneta; 
	int valorEsperado; 
	Danio danio; 
	
	@Before
	public void setUp() throws Exception {
		// Creaciones de unidades
		algo42 = new Algo42( 150 , 145 );
		avioneta = new Avioneta( 150 , 150 );
	}
	

	@Test
	public void testCreacion(){
		int i;
		for ( i = 0 ; i == 2 ; i++ ){
			algo42.arriba();
		}
		
		Assert.assertFalse( avioneta.EstaVivo() );
		danio = algo42.fuerzaDeChoque();
		valorEsperado = danio.lastimar();
		Assert.assertEquals( valorEsperado , 50 );
	}
	
	
}
