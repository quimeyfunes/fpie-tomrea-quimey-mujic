package Pruebas;

import Mapa.Vector2D;
import Objetos_moviles.*;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Armas.*;

public class Algo42DisparaYcambiaDeArmaTest extends TestCase{
	// Testea el disparo de un torpedo dirigido por Algo42 contra una avioneta
	
	// Variables
	@SuppressWarnings("unused")
	private Avioneta avioneta;//sin un enemigo, el misil estalla xD, es necesario que exista al menos 1
	private Algo42 algo42;
	private Municion municion;
	private Vector2D valor_esperado;
	private LanzadorMisiles misiles_dirigidos;
	
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void test(){
	
	//Creacion unidades
	avioneta = new Avioneta(120, 120);
	algo42= new Algo42(100, 100);
	
	//Seteo y acoplamiento de los misiles
	misiles_dirigidos = new LanzadorMisiles(algo42.getBando(), new MovDirigido());
	
	algo42.agregarArma( misiles_dirigidos );
	
	//El misil es disparado y pasa a actuar como tal
	municion = algo42.disparar();
	municion.moverseIAsegunVel();
	
	// Ubicacion esperada del misil
	valor_esperado.setLocation( 100 , 108 ); 
	Assert.assertEquals( valor_esperado , municion.getPosicion() );
	
	algo42.seleccionarSiguienteArma();
	municion = algo42.disparar();
	Assert.assertTrue(  municion.getClass()== TorpedoDirigido.class );
	//esta comparacion de clase se hace solo en las pruebas, no en el codigo real, asi que no esta mal
	}
}