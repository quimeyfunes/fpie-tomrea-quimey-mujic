package Pruebas;


import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Mapa.Ubicacion;
import Mapa.Vector2D;

public class TestUbicacion {
	private Ubicacion a;
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testUbicacion(){
		try{
			a =  Ubicacion.crearUbicacionEnXY(-1,-1);
			fail("Deberia capturar excepcion OFFlimits");
		}catch(Exception e){}
		
		try{
			a = Ubicacion.crearUbicacionEnXY( 9999999 , 9999999 );
			fail("Deberia capturar excepcion OFFlimits");
		}catch(Exception e){}



		a = Ubicacion.crearUbicacionEnXY(1,1);

		Assert.assertTrue(a.EstaCercaAlAlimiteIzquierdo());

		Assert.assertFalse( a.EstaCercaAlAlimiteDerecho() );
		
		Vector2D tra = new Vector2D(0,10);

		a.translateBy( tra );
		
		Vector2D otro = a.XY();


		Assert.assertTrue( otro.x == 1 );
		Assert.assertTrue(otro.y == 11);
	}
}
