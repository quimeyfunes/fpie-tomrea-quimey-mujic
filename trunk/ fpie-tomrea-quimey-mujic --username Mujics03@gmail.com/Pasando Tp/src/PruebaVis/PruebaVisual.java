package PruebaVis;
import java.util.ArrayList;

import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.ObjetoVivo;
import Vistas.*;
import ar.uba.fi.algo3.titiritero.vista.ImagenDinamica;
import ar.uba.fi.algo3.titiritero.vista.Ventana;
import Escenario.BlindajeAlgo42;
import Escenario.Escenario;
import Excepciones.GameOverException;
import Objetos_moviles.*;

public class PruebaVisual {

	public static void main(String[] args) {
		
		double LimiteX = Escenario.getLimiteX();
		double LimiteY = Escenario.getLimiteY();
		double AltDeEnemy = LimiteY-20;
		//esos son limites que uso para probar la simulacion
		
		//seteo el controlador y lo dejo listo para correr		
		ControladorJuego controlador = new ControladorJuego(false);
		Ventana ventana = new VentanaPrincipal( controlador,(int)LimiteX+ 50,(int)LimiteY +50);
		controlador.setSuperficieDeDibujo(ventana);
		ventana.setVisible(true);
		
		controlador.setIntervaloSimulacion(20);
		//fin seteo controlador
		Escenario.InicializarEscenario(controlador);
	
		Caza caza = new Caza ( 40 , AltDeEnemy );
		Exploradores explorador = new Exploradores( 300, AltDeEnemy );
		Bombardero bombardero = new Bombardero( 700  ,AltDeEnemy);
		Avioneta avioneta = new Avioneta( 500 , AltDeEnemy );
		Algo42 algo42 = new Algo42(950,50);
		
		
		Dibujable vistaAlgo = new VistaVidaAlgo42();
		BlindajeAlgo42 blindaje = new BlindajeAlgo42(algo42);
		vistaAlgo.setPosicionable(blindaje);
		((ImagenDinamica) vistaAlgo).setMonitoreable(blindaje);
		controlador.agregarDibujable(vistaAlgo);
		//Guia guia = new Guia(20,400);
		AvionCivil avion = new AvionCivil(50,50);
	
		controlador.agregarKeyPressObservador(algo42);
		try
		{
			controlador.comenzarJuego();
		}
		catch(GameOverException e)
		{
			controlador.detenerJuego();
			Dibujable vistaGameOver = new VistaGameOver();
			controlador.agregarDibujable(vistaGameOver);
		}
		
	}
}
