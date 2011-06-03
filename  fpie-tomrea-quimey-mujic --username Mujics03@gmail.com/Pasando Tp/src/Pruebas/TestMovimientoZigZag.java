package Pruebas;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestMovimientoZigZag {
	
	private int limiteDeSlide;
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

		Point unXantes = avion.getPosicion.getX();

		for (int i = 0; i < 3; i++){
			avion.moverseIAsegunVel();
		}

		Point unXdespues = avion.getPosicion.getX();

		//luego de llegar al limite de slide, cambia de direccion
		//primer izquierda abajo, luego derecha abajo
		Assert.assertEquals( unXantes < unXdespues, 1E-4 );
		

		for (int i = 0; i < limiteDeSlide; i++){
			avion.moverseIAsegunVel();
		}


		Point unXantes = avion.getPosicion.getX();

		for (int i = 0; i < 3; i++){
			avion.moverseIAsegunVel();
		}

		Point unXdespues = avion.getPosicion.getX();

		//ahora, de vuelta izquierda abajo
		Assert.assertEquals( unXantes > unXdespues, 1E-4 ); 
	}
}
