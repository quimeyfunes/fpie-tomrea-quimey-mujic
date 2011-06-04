package Pruebas;

import junit.framework.Assert;

import org.junit.Before;

import Objetos_moviles.Avioneta;


public class TestMovimientoIdaYVvuelta {
	
	private Avioneta avion;
	
	@Before
	public void setUp() throws Exception {
	avion = new Avioneta ( 100 , 100);
	}
	
	
	@Test
	prublic void testMovimiento(){
		
		for( int i = 0 ; i < 19, i++ ){
			avion.moverseIAsegunVel();
		}
		

		for( int i = 0 ; i < 3; i++ ){
			avion.moverseIAsegunVel();
		}
		
		
		 //viene, choca contra el borde inferior y sube
		 //tiene el mismo comportamiento para la subida
		 Assert.assertFalse( avion.EstaCercaAlAlimiteInferior(),1E-4);
		
	}
}
