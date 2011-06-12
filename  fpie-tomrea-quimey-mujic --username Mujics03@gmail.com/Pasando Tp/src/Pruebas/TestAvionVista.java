package Pruebas;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.vista.Cuadrado;
import ar.uba.fi.algo3.titiritero.vista.Ventana;

import Escenario.Escenario;
import Objetos_moviles.Avioneta;

public class TestAvionVista extends TestCase {
	
	
	@Before
	public void setUp() throws Exception {
		Escenario.reiniciarEscenario();
	}
	
	@Test
	public void TestAvionVista(){
		Avioneta avioneta = new Avioneta(5000,5000);
		
		ControladorJuego controlador = new ControladorJuego(false);
		Ventana ventana = new Ventana(10000,10000,controlador);
		controlador.setSuperficieDeDibujo(ventana);
		
		Cuadrado fondo = new Cuadrado(10000,10000);
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}










