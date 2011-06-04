package Pruebas;
import Armas.Blindaje;
import Armas.Danio;
import junit.framework.*;



public class BlindajeTest extends TestCase{
	// Testea el funcionamiento del blindaje y la excepcion cuando este es destruido
	
	// Variables
	Danio b;
	Blindaje A;
	
	b = Danio.De( 300 );
	A = Blindaje.De( 100 );
	
	// Verificar funcionamiento del fail 
	try{
		A.daniar( b );
		fail("Deberia saltar un excepcion CHAUblindaje");
	}
	
}
