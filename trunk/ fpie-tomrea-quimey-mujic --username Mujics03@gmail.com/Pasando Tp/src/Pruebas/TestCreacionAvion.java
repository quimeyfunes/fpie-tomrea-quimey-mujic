package Pruebas;


import static org.junit.Assert.fail;

import java.awt.Point;

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

		Assert.assertEquals(a.EstaVivo(), 1E-4);
		Assert.assertEquals(a.RecolectarPuntos()== 0, 1E-4));
		Assert.assertEquals( a.getPosicion() == new Point(50,50), 1E-4);

		a.DESTRUCTOR();

		//muere y entrega los puntos
		Assert.assertEquals( a.RecolectarPuntos() > 0, 1E-4) );
	}

}
