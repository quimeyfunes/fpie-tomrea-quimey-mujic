package Pruebas;


import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import Objetos_moviles.Avioneta;

public class TestCreacionAvion {

	private Avioneta a;
	
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testCreacion(){
		
		try{
			a = new Avioneta(-10, (-10));
			fail("Deberia capturar excepcion OFFlimits");
		}catch(Exception e){}
		


		a = new Avioneta ( 50, 50);

		Assert.assertTrue(a.EstaVivo());
		Assert.assertTrue(a.RecolectarPuntos()== 0);
		
		
		Assert.assertTrue( ((a.getPosicion()).x == 50 ) );
		Assert.assertTrue( ((a.getPosicion()).y == 50 ) );

		a.Destructor();

		//muere y entrega los puntos
		Assert.assertTrue( a.RecolectarPuntos() > 0);
	}

}
