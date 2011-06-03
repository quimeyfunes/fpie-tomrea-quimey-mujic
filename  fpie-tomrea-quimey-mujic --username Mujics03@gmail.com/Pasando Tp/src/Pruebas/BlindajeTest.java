package Pruebas;
import junit.framework.*;



public class BlindajeTest extends TestCase{
	// Testea el funcionamiento del blindaje y la excepcion cuando este es destruido
	
	// Variables
	Danio b;
	Blinjade A;
	
	b = Danio.De( 300 );
	A = Blindaje.De( 100 );
	
	// Verificar funcionamiento del fail 
	try{
		A.daniarPor( b );
		fail("Deberia saltar un excepcion CHAUblindaje");
	}
	
}
