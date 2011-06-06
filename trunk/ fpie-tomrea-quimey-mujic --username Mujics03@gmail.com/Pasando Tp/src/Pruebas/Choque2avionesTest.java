package Pruebas;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Escenario.Escenario;
import Objetos_moviles.Algo42;
import Objetos_moviles.Avioneta;

public class Choque2avionesTest
{
	// Testea el choque de algo42 contra una avioneta, y la esperada muerta de la avioneta despues 
	
	private Algo42 algo42; 
	private Avioneta avioneta; 
	
	@Before
	public void setUp() throws Exception {
		Escenario.reiniciarEscenario();
	}
	
	@Test
	public void choque2avionesTest()
	{
	algo42 = new Algo42(150, 145);
	avioneta= new Avioneta(150, 150);
	
	for (int j = 0; j <= 2; j++) {
		algo42.arriba();
	}
	
	Assert.assertFalse( avioneta.EstaVivo() );
	Assert.assertEquals( algo42.getVida() , 50 );
	}
}