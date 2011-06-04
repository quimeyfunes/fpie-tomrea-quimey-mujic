package Pruebas;
import Armas.Blindaje;
import Armas.Danio;
import junit.framework.*;

public class BlindajeTest extends TestCase{
	// Testea el funcionamiento del blindaje y la excepcion cuando este es destruido
	
	// Variables
	Danio d = new Danio((short)300);
	Blindaje b = new Blindaje((short)100);

	// Verificar funcionamiento del fail 
	/*try
	{
		b.daniar(d);
		Assert.fail("Deberia saltar un excepcion CHAUblindaje");
	}
	catch
	{
		
	}*/
	
}
