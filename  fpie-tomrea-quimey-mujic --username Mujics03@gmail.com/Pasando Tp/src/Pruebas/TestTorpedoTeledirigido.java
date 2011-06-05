package Pruebas;


import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import Armas.ControladorArmas;
import Armas.LanzadorMisiles;
import Mapa.Vector2D;
import Objetos_moviles.Algo42;
import Objetos_moviles.MovDirigido;
import Objetos_moviles.Municion;
import Objetos_moviles.ObjetosMoviles;

public class TestTorpedoTeledirigido {
	private Algo42 objetivo;
	private ControladorArmas controladorArmas; 
	private LanzadorMisiles armaF;
	@Before
	public void setUp() throws Exception {
		

		objetivo = new Algo42( 107, 93 ); 
		controladorArmas = new ControladorArmas();

		 
		armaF = new LanzadorMisiles(ObjetosMoviles.BandoEnemigo(),new MovDirigido());
		controladorArmas.add(armaF);
	}
	
	@Test
	public void testTorpedo(){
		Assert.assertTrue( objetivo.EstaVivo() );
		
		Vector2D pos = new Vector2D( (double)102,(double)93);

		Municion misil = controladorArmas.dispararElArmaSeleccionada(pos);
		Assert.assertTrue( misil.EstaVivo() );
		misil.moverseIAsegunVel();

		Assert.assertFalse (misil.EstaVivo() );
	}

}
