package Pruebas;
import junit.framework.TestCase;
import Armas.Danio;
import Escenario.Escenario;
import Objetos_moviles.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.uba.fi.algo3.titiritero.ControladorJuego;

public class BombarderoMuereYdejaArmaTest extends TestCase{
	// Testea la muerte de un Bombardero y que el item dejado sea agarrado por algo42

	private Bombardero bombardero; 
	private Algo42 algo42;
	private Danio danio; 
	private Municion municion;
	
	@Before
	public void setUp() throws Exception {
		Escenario.reiniciarEscenario();
		Escenario.InicializarEscenario(new ControladorJuego(false));
		
		// Variables
		  bombardero= new Bombardero( 100 , 100 ); 
		  algo42=new Algo42(100,90);
		  danio= new Danio((short) 200); 
	}
	
	
	@Test
	public void testBombarderoMuereYdejaArmaTest(){
		bombardero.analizarDanio( danio );
		Assert.assertFalse( bombardero.EstaVivo() );
		
		for ( int i = 0 ; i <= 9 ; i++ ){
			algo42.arriba();
		}
		
		// Algo42 agarra el item y se verifica que este sea el TorpedosDirigido
		algo42.seleccionarSiguienteArma();
		municion = algo42.disparar();
		Assert.assertTrue( municion instanceof TorpedoDirigido );
		
	}
	
	
}
