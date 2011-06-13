package ControladorAvioneta;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import Vistas.*;
import ar.uba.fi.algo3.titiritero.vista.Ventana;
import Escenario.Escenario;
import Objetos_moviles.*;

public class ControladorAvioneta {

	public static void main(String[] args) {
		
		double LimiteX = Escenario.getLimiteX();
		double LimiteY = Escenario.getLimiteY();
		double AltDeEnemy = LimiteY-20;
	
		Caza caza = new Caza ( 20 , AltDeEnemy );
		Exploradores explorador = new Exploradores( 300, AltDeEnemy );
		Bombardero bombardero = new Bombardero( 700  ,AltDeEnemy);
		Avioneta avioneta = new Avioneta( 500 , AltDeEnemy );
		Mesa unaMesa = new Mesa((int)LimiteX+50,(int)LimiteY+50);

		/*
		 * Luego instancio los objetos del framework: una ventana y el controlador
		 */		
		ControladorJuego controlador = new ControladorJuego(true);
		Ventana ventana = new VentanaPrincipal( controlador,(int)LimiteX+ 50,(int)LimiteY +50);
		controlador.setSuperficieDeDibujo(ventana);
		ventana.setVisible(true);
		
		/*
		 * Instancio un cuadrado para que actue como vista de la mesa
		 */
		VistaMesa vistaMesa = new VistaMesa();
		vistaMesa.setPosicionable(unaMesa);
		
		/*
		 * Instancio una imagen para que actue como vista de la pelota
		 */
		VistaExplorador vistaExplorador = new VistaExplorador();
		VistaBombardero vistaBombardero = new VistaBombardero();
		VistaAvioneta vistaAvioneta = new VistaAvioneta();
		VistaCaza vistaCaza = new VistaCaza();
		vistaAvioneta.setPosicionable(avioneta);
		vistaBombardero.setPosicionable(bombardero);
		vistaExplorador.setPosicionable(explorador);
		vistaCaza.setPosicionable(caza);
		/*
		 * agrego la pelota a la lista de objetos vivios del controlador
		 * para que este le de vida dentro del gameloop
		 */
		controlador.agregarObjetoVivo(avioneta);
		controlador.agregarObjetoVivo(bombardero);
		controlador.agregarObjetoVivo(explorador);
		controlador.agregarObjetoVivo(caza);
		/*
		 * Agrego los objetos que actuan como vista a la lista de dibujables del controlador
		 * para que sean repintados al final de cada gameloop
		 */
		
		controlador.agregarDibujable(vistaMesa);
		controlador.agregarDibujable(vistaAvioneta);
		controlador.agregarDibujable(vistaBombardero);
		controlador.agregarDibujable(vistaExplorador);
		controlador.agregarDibujable(vistaCaza);
		/*
		 * finalmente establezco el intervalo de sleep dentro del gameloop
		 * y comienzo a ejecutar
		 */
		controlador.setIntervaloSimulacion(20);
		controlador.comenzarJuego();
		
	}
}
