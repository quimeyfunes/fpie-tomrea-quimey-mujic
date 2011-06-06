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
import Excepciones.GameOverException;

public class TestDestruirAvion {
	private ControladorArmas ControladorA;
	private Algo42 avion = new Algo42( 20,20);
	private Municion municion;
	
	@Before
	public void setUp() throws Exception {
	}
	@Test
	public void testDestruir() {
		
		this.ControladorA= new ControladorArmas();
		this.ControladorA.add( new PistolaLaser( ObjetosMoviles.BandoEnemigo(),new LineaRectaUp()));
		this.municion = ControladorA.dispararElArmaSeleccionada( new Vector2D(20,15));
		this.municion.moverseIAsegunVel();
		
		try{
			municion.moverseIAsegunVel();
			fail("Deberia capturar excepcion");
		}catch(ChauBlindajeException e){}
		
		try{
			for( int i=0; i<5; i++ ){
				municion = ControladorA .dispararElArmaSeleccionada( new Vector2D(20,15));
				municion.moverseIAsegunVel();
			}
		}catch(GameOverException e){}
		
		Assert.assertFalse(avion.EstaVivo());
		
	}
	
	
}
