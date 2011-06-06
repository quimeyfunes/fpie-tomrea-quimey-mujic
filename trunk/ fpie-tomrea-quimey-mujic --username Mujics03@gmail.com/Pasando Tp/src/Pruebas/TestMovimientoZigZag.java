package Pruebas;



import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Objetos_moviles.Bombardero;
import Objetos_moviles.EstrategiaDeVuelo;

public class TestMovimientoZigZag extends TestCase {
	
	private double limiteDeSlide;
	private Bombardero avion;

	@Before
	public void setUp() throws Exception {
		limiteDeSlide =  EstrategiaDeVuelo.getSlide();
		avion = new Bombardero ( 2000, 2000);
	}
	
	@Test
	public void testMovimiento(){
		 
		for (int i = 0; i < limiteDeSlide; i++){
			avion.moverseIAsegunVel();
		}

		double unXantes = (avion.getPosicion()).x;

		for (int i = 0; i < 3; i++){
			avion.moverseIAsegunVel();
		}

		double unXdespues = (avion.getPosicion()).x;

		//luego de llegar al limite de slide, cambia de direccion
		//primer izquierda abajo, luego derecha abajo
		Assert.assertTrue( unXantes < unXdespues );
		

		for (int i = 0; i < limiteDeSlide; i++){
			avion.moverseIAsegunVel();
		}


		 unXantes = (avion.getPosicion()).x;

		for (int i = 0; i < 3; i++){
			avion.moverseIAsegunVel();
		}

		unXdespues = (avion.getPosicion()).x;

		//ahora, de vuelta izquierda abajo
		Assert.assertTrue( unXantes > unXdespues ); 
	}
}
