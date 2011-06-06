package Pruebas;
import junit.framework.*;
import Armas.Danio;
import Objetos_moviles.*;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BombarderoMuereYdejaArmaTest extends TestCase{
	// Testea la muerte de un Bombardero y que el item dejado sea agarrado por algo42
	
	// Variables
	private Bombardero bombardero= new Bombardero( 100 , 100 ); 
	private Algo42 algo42=new Algo42(100,90);
	private Danio danio= new Danio((short) 200); 
	private Municion municion;
	
	@Before
	public void setUp() throws Exception {

	}
	
	
	@Test
	public void testCreacion(){
		bombardero.analizarDanio( danio );
		Assert.assertFalse( bombardero.EstaVivo() );
		
		for ( int i = 0 ; i <= 9 ; i++ ){
			algo42.arriba();
		}
		
		// Algo42 agarra el item y se verifica que este sea el TorpedosDirigido
		algo42.seleccionarSiguienteArma();
		municion = algo42.disparar();
		Boolean b = (municion.getClass() == TorpedoDirigido.class);
		Assert.assertTrue( b );
		
	}
	
	
}
