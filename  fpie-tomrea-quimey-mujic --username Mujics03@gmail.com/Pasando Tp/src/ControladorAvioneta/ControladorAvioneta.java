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
		

		/*
		 * Primero instancio mi modelo: una pelota que se mueve por una mesa
		 */
		Caza caza = new Caza ( 350 , LimiteY - 100 );
		Exploradores explorador = new Exploradores( 250, LimiteY - 50 );
		Bombardero bombardero = new Bombardero( 160  ,LimiteY -10);
		Avioneta avioneta = new Avioneta( 100 , LimiteY-10 );
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
