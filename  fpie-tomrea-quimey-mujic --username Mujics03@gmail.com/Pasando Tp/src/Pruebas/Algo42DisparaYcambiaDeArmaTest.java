package Pruebas;

import Mapa.Vector2D;
import Objetos_moviles.*;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.uba.fi.algo3.titiritero.ControladorJuego;

import Armas.*;
import Escenario.Escenario;
import EstrategiasDeMov.MovDirigido;

public class Algo42DisparaYcambiaDeArmaTest extends TestCase{
	// Testea el disparo de un torpedo dirigido por Algo42 contra una avioneta
	
	// Variables
	@SuppressWarnings("unused")
	private Avioneta avioneta;//sin un enemigo, el misil estalla xD, es necesario que exista al menos 1
	private Algo42 algo42;
	private Municion municion;
	private Vector2D valor_esperado= new Vector2D(100,108);
	private LanzadorMisiles misiles_dirigidos;
	
	@Before
	public void setUp() throws Exception {
		Escenario.reiniciarEscenario();
		Escenario.InicializarEscenario(new ControladorJuego(false));
	}
	
	@Test
	public void test(){
	
	//Creacion unidades
	avioneta = new Avioneta(120, 120);
	algo42= new Algo42(100, 100);
	
	//Seteo y acoplamiento de los misiles
	misiles_dirigidos = new LanzadorMisiles(algo42.getBando(), new MovDirigido());
	
	algo42.agregarArma( misiles_dirigidos );
	municion = algo42.disparar();
	municion.moverseIAsegunVel();
	
	// Ubicacion esperada del misil
	Assert.assertEquals(municion.getClass(), Laser.class);
	Assert.assertEquals( valor_esperado , municion.getPosicion() );
	
	algo42.seleccionarSiguienteArma();
	municion = algo42.disparar();
	Assert.assertTrue(  municion.getClass()== TorpedoDirigido.class );
	//esta comparacion de clase se hace solo en las pruebas, no en el codigo real, asi que no esta mal
	}
}
