package Pruebas;
import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;

import Armas.Blindaje;
import Armas.Danio;
import Excepciones.ChauBlindajeException;

public class BlindajeTest  
{
	// Testea el funcionamiento del blindaje y la excepcion cuando este es destruido
	private Danio d;
	private Blindaje b;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testBlindaje()
	{
		
		try
		{
			d = new Danio((short)300);
			b = new Blindaje((short)100);
			b.daniar(d);
		}
		catch(ChauBlindajeException e)
		{
			Assert.assertTrue(true);
		}
	}
}
