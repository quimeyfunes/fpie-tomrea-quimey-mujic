package Controlador;
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
		Bombardero bombardero = new Bombardero( 160  ,LimiteY -10);
		Avioneta avioneta = new Avioneta( 100 , LimiteY-10 );
		Mesa unaMesa = new Mesa((int)LimiteX,(int)LimiteY);

		/*
		 * Luego instancio los objetos del framework: una ventana y el controlador
		 */		
		ControladorJuego controlador = new ControladorJuego(true);
		Ventana ventana = new VentanaPrincipal( controlador,(int)LimiteX,(int)LimiteY );
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
		VistaBombardero vistaBombardero = new VistaBombardero();
		VistaAvioneta vistaAvioneta = new VistaAvioneta();
		vistaAvioneta.setPosicionable(avioneta);
		vistaBombardero.setPosicionable(bombardero);
		
		/*
		 * agrego la pelota a la lista de objetos vivios del controlador
		 * para que este le de vida dentro del gameloop
		 */
		controlador.agregarObjetoVivo(avioneta);
		controlador.agregarObjetoVivo(bombardero);
		
		/*
		 * Agrego los objetos que actuan como vista a la lista de dibujables del controlador
		 * para que sean repintados al final de cada gameloop
		 */
		
		controlador.agregarDibujable(vistaMesa);
		controlador.agregarDibujable(vistaAvioneta);
		controlador.agregarDibujable(vistaBombardero);
		
		/*
		 * finalmente establezco el intervalo de sleep dentro del gameloop
		 * y comienzo a ejecutar
		 */
		controlador.setIntervaloSimulacion(20);
		controlador.comenzarJuego();
		
	}
}
