package Pruebas;
import static org.junit.Assert.fail;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Mapa.Vector2D;
import Objetos_moviles.Algo42;
import Objetos_moviles.LineaRectaUp;
import Objetos_moviles.Municion;
import Objetos_moviles.ObjetosMoviles;
import Armas.*;
import Excepciones.ChauBlindajeException;

public class TestDestruirAvion {
	private ControladorArmas ControladorA  =  new ControladorArmas();
	private Algo42 avion = new Algo42( 20,20);
	private Municion municion;
	
	@Before
	public void setUp() throws Exception {
		
		ControladorA.add( new PistolaLaser( ObjetosMoviles.BandoEnemigo(),new LineaRectaUp()));
		municion = ControladorA.dispararElArmaSeleccionada( new Vector2D(20,15));
		municion.moverseIAsegunVel();
	}

	@Test(expected=ChauBlindajeException.class)
	public void testDestruir() {
		try{
			municion.moverseIAsegunVel();
			fail("Deberia capturar excepcion");
		}catch(Exception e){}
		try{
			for( int i=0; i<5; i++ ){
				municion = ControladorA .dispararElArmaSeleccionada( new Vector2D(20,15));
				municion.moverseIAsegunVel();
			}
			fail("Deberia capturar excepcion");
		}catch(Exception e){}
		
		Assert.assertFalse(avion.EstaVivo());
		
	}
	
	
}
