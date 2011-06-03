package Pruebas;
import junit.framework.*;


public class BombarderoMuereYdejaArmaTest extends TestCase{
	// Testea la muerte de un Bombardero y que el item dejado sea agarrado por algo42
	
	// Variables
	Bombardero bombardero; 
	Algo42 algo42;
	Danio danio; 
	
	// Creacion de unidades
	bombardero.CrearEnXY( 100 , 100 );
	algo42.CrearEnXY( 100 , 90 );
	
	//El bombardero es daniado y deberia morir para luego liberar el item
	danio = Danio.De( 200 );
	bombardero.analizarDanio( danio );
	assertFalse( bombardero.EstaVivo );
	
	int i; 
	for ( i = 0 ; i = 9 ; i++ ){
		algo42.arriba();
	}
	
	// Algo42 agarra el item y se verifica que este sea el TorpedosDirigido
	algo42.seleccionarSiguienteArma();
	municion = algo42.disparar();
	assertTrue( municion isistanceof TorpedosDirigido );
}
