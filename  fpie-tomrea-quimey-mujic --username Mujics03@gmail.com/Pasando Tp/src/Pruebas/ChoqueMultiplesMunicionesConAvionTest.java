package Pruebas;
import junit.framework.*;

public class ChoqueMultiplesMunicionesConAvionTest extends TestCase{
	//Testea el choque de algo42 contra muchas balas y su subsecuente muerte
	
	// Variables
	Bombardero bombardero;
	Algo42 algo42; 
	Municion municion1, municion2, municion3, municion4;
	
	//Creacion de unidades
	bombardero.CrearEnXY( 100 , 115 );
	algo42.crearEnXY( 100 , 100 );
	
	bombardero.seleccionarSiguienteArma();
	municion1 = bombardero.disparar();
	municion2 = bombardero.disparar();
	municion3 = bombardero.disparar();
	municion4 = bombardero.disparar();
	
	int i; 
	for ( i = 0 ; i = 19 ; i++ ){
		bombardero.arriba();
	}
	
	try {
		int i; 
		for ( i = 0 ; i = 13 ; i++ ){
			algo42.arriba();
		}
		fail("Deberia haber saltado excepcion GameOver");
	}
	//Comprobacion de que las balas y algo42 esten muertos
	assertFalse( algo42.EstaVivo );
	assertFalse( municion1.EstaVivo );
	assertFalse( municion2.EstaVivo );
	assertFalse( municion3.EstaVivo );
	
}
