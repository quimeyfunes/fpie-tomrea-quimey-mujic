package Pruebas;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Escenario.Escenario;
import Excepciones.OffLimitsException;
import Mapa.Ubicacion;
import Mapa.Vector2D;

public class TestUbicacion extends TestCase{
	private Ubicacion a;
	@Before
	public void setUp() throws Exception {
		Escenario.reiniciarEscenario();
	}
	
	@Test
	public void testUbicacion(){
		try{
			a =  Ubicacion.crearUbicacionEnXY(-1,-1);
			fail("Deberia capturar excepcion OFFlimits");
		}catch(OffLimitsException e){
			
		}
		
		try{
			a = Ubicacion.crearUbicacionEnXY( 9999999 , 9999999 );
			fail("Deberia capturar excepcion OFFlimits");
		}catch(OffLimitsException OffLimitsException){}



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
