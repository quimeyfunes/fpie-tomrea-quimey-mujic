package Pruebas;


import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.uba.fi.algo3.titiritero.ControladorJuego;

import Armas.Danio;
import Escenario.Escenario;
import Mapa.Vector2D;
import Objetos_moviles.Avioneta;

public class TestCreacionAvion {

	private Avioneta a;
	
	@Before
	public void setUp() throws Exception {
		Escenario.reiniciarEscenario();
		Escenario.InicializarEscenario(new ControladorJuego(false));
	}
	
	@Test
	public void testCreacion(){
		
		try{
			a = new Avioneta(-10, (-10));
			fail("Deberia capturar excepcion OFFlimits");
		}catch(Exception e){}
		
		double x= 100;
		double y= 110;


		a = new Avioneta ( x, y);

		Assert.assertTrue(a.EstaVivo());
		Assert.assertTrue(a.RecolectarPuntos()== 0);
		
		Vector2D posA = a.getPosicion();
		
		Vector2D posBuscada = new Vector2D(x,y);
		
		
		Assert.assertTrue( posA.x == posBuscada.x );
		Assert.assertTrue( posA.y == posBuscada.y );

		a.analizarDanio(new Danio((short)300));

		//muere y entrega los puntos
		Assert.assertTrue( a.RecolectarPuntos() > 0);
	}

}
