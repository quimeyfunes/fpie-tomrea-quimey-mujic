package Pruebas;


import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import ar.uba.fi.algo3.titiritero.ControladorJuego;

import Armas.ControladorArmas;
import Armas.LanzadorMisiles;
import Escenario.Escenario;
import EstrategiasDeMov.MovDirigido;
import Mapa.Vector2D;
import Objetos_moviles.Algo42;
import Objetos_moviles.Municion;
import Objetos_moviles.ObjetosMoviles;

public class TestTorpedoTeledirigido extends TestCase {
	private Algo42 objetivo;
	private ControladorArmas controladorArmas; 
	private LanzadorMisiles armaF;
	@Before
	public void setUp() throws Exception {
		
		Escenario.reiniciarEscenario();
		Escenario.InicializarEscenario(new ControladorJuego(false));
		
		objetivo = new Algo42( 110, 110 ); 
		controladorArmas = new ControladorArmas();		 
		armaF = new LanzadorMisiles(ObjetosMoviles.BandoEnemigo(),new MovDirigido());
		controladorArmas.add(armaF);
	}
	
	@Test
	public void testTorpedo(){
		Assert.assertTrue( objetivo.EstaVivo() );
		
		Vector2D pos = new Vector2D( 110,125);

		Municion misil = controladorArmas.dispararElArmaSeleccionada(pos);
		Assert.assertTrue( misil.EstaVivo() );
		misil.moverseIAsegunVel();
		misil.moverseIAsegunVel();

		Assert.assertFalse (misil.EstaVivo() );
		Assert.assertTrue( objetivo.getVida()==110);
	}

}
