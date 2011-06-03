package Pruebas;


import org.junit.Before;
import org.junit.Test;

public class TestTorpedoTeledirigido {
	private Algo42 objetivo;
	private ControladorArmas controladorArmas; 
	private LanzadorDeMisilesTeledirigidos armaF;
	@Before
	public void setUp() throws Exception {
		

		objetivo = new Algo42( 107, 93 ); 
		controladorA = new ControladorArmas();

		 
		armaF = new LanzadorDeMisilesTeledirigidos(ObjetosMoviles.getBandoEnemigo(),new MovDirigido();
		controladorA.add(armaF);
	}
	
	@Test
	public void testTorpedo(){
		Assert.assertEquals( objetivo.EstaVivo(), 1E-4 );

		Municion misil = controladorA.dispararElArmaSeleccionadaDesde(102,93);
		Assert.assertEquals( misil.EstaVivo(), 1E-4 );
		misil.moverseIAsegunVel();

		Assert.assertFalse (misil.EstaVivo(), 1E-4 );
	}

}
