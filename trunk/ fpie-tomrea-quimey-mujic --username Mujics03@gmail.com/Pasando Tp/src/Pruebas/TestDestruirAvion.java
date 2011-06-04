package Pruebas;
import static org.junit.Assert.fail;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Objetos_moviles.Algo42;
import Objetos_moviles.Municion;
import Armas.*;

import cuentas1.CuentaBancaria;

public class TestDestruirAvion {
	private ControladorArmas ControladorA  =  new ControladorArmas();
	private Algo42 avion = new Algo42( 20,20);
	private Municion municion;
	
	@Before
	public void setUp() throws Exception {
		
		ControladorA.add( new PistolaLaser(ObjetosMoviles.getBandoEnemigo(),new LineaRectaUp() );
		municion = ControladorA.dispararElArmaSeleccionadaDesd (20,15);
		municion.moverseIAsegunVel();
	}

	@Test(expected=CHAUblindaje.class)
	public void testDestruir() {
		try{
			municion.moverseIAsegunVel();
			fail("Deberia capturar excepcion");
		}catch(Exception e){}
		try{
			for( int i=0; i<5; i++ ){
				municion = ControladorA .dispararElArmaSeleccionadaDesde(20,15);
				municion.moverseIAsegunVel();
			}
			fail("Deberia capturar excepcion");
		}catch(Exception e){}
		
		Assert.assertFalse(avion.EstaVivo(), 1E-4 );
		
	}
	
	
}
