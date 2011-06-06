package Pruebas;
import junit.framework.*;
import Armas.Danio;
import Objetos_moviles.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CazaMuerteYdejaVidaTest extends TestCase{
	// Testea la muerte del caza y que algo sigue vivo debido al item liberado por este.
	
	// Variables
	private Caza caza; 
	private Danio danio; 
	private Algo42 algo42; 
	
	@Before
	public void setUp() throws Exception {
		//Inicializa las unidades
		// verificar si va a haber un inicializar o si lo seteo desde las pruebas
	
		caza = new Caza( 100 , 100);
		
		danio = new Danio((short) 200);
		caza.analizarDanio( danio );
		algo42 = new Algo42( 100 , 100 );
		
		algo42.VerificarColision();
		
		danio.setearPoder( (short) 160 );
		algo42.analizarDanio( danio );
		
	}
	
	

	@Test
	public void testCreacion(){
		//Algo sigue vivo debido a la vida del item obtenido 
		Assert.assertFalse( algo42.EstaVivo() );
	}
	

}
