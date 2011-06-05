package Pruebas;
import junit.framework.*;
import Objetos_moviles.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChoqueMultiplesMunicionesConAvionTest extends TestCase{
	//Testea el choque de algo42 contra muchas balas y su subsecuente muerte
	
	// Variables
	private Bombardero bombardero;
	private Algo42 algo42; 
	private Municion municion1, municion2, municion3, municion4;
	
	@Before
	public void setUp() throws Exception {
		//Creacion de unidades
		bombardero = new Bombardero ( 100 , 115 );
		algo42 = new Algo42 ( 100 , 100 );
		
		bombardero.seleccionarSiguienteArma();
		municion1 = bombardero.disparar();
		municion2 = bombardero.disparar();
		municion3 = bombardero.disparar();
		municion4 = bombardero.disparar();
	}
	
	
	@Test
	public void testCreacion(){
		int i; 
		for ( i = 0 ; i == 19 ; i++ ){
			bombardero.arriba();
		}
		
		try {
			int j; 
			for ( j = 0 ; j == 13 ;j ++ ){
				algo42.arriba();
			}
			Assert.fail("Deberia haber saltado excepcion GameOver");
		}catch(Exception e){}
		//Comprobacion de que las balas y algo42 esten muertos
		Assert.assertFalse( algo42.EstaVivo() );
		Assert.assertFalse( municion1.EstaVivo() );
		Assert.assertFalse( municion2.EstaVivo() );
		Assert.assertFalse( municion3.EstaVivo() );
	}
	
	
}
