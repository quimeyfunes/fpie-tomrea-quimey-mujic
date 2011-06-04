package Pruebas;


import static org.junit.Assert.fail;

import java.awt.Point;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Mapa.Ubicacion;

public class TestUbicacion {
	private Ubicacion a;
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testUbicacion(){
		try{
			a = new Ubicacion(-1,-1);
			fail("Deberia capturar excepcion OFFlimits");
		}catch(Exception e){}
		
		try{
			a = new Ubicacion( 9999999 , 9999999 );
			fail("Deberia capturar excepcion OFFlimits");
		}catch(Exception e){}



		a = new Ubicacion(-1,-1);

		Assert.assertEquals(a.EstaCercaAlAlimiteIzquierdo(), 1E-4);

		Assert.assertFalse( a.EstaCercaAlAlimiteDerecho, 1E-4 );

		a.translateBy(0,10);

		a.XY();

		Assert.assertEquals( a .XY() == new Point( 1 , 11 ), 1E-4 );
	}
}
