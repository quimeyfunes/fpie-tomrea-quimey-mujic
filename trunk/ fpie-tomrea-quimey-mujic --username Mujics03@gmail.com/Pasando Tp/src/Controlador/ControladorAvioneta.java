package Controlador;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import Vistas.VentanaPrincipal;
import Vistas.VistaAvioneta;
import Vistas.*;
import ar.uba.fi.algo3.titiritero.vista.Ventana;
import Objetos_moviles.Avioneta;

public class ControladorAvioneta {

	public static void main(String[] args) {
		

		/*
		 * Primero instancio mi modelo: una pelota que se mueve por una mesa
		 */
		Avioneta avioneta = new Avioneta( 100 , 800 );
		Mesa unaMesa = new Mesa(10000, 10000);

		/*
		 * Luego instancio los objetos del framework: una ventana y el controlador
		 */		
		ControladorJuego controlador = new ControladorJuego(true);
		Ventana ventana = new VentanaPrincipal( controlador,800,800 );
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
		VistaAvioneta vistaAvioneta = new VistaAvioneta();
		vistaAvioneta.setPosicionable(avioneta);
		
		/*
		 * agrego la pelota a la lista de objetos vivios del controlador
		 * para que este le de vida dentro del gameloop
		 */
		controlador.agregarObjetoVivo(avioneta);
		
		/*
		 * Agrego los objetos que actuan como vista a la lista de dibujables del controlador
		 * para que sean repintados al final de cada gameloop
		 */
		
		controlador.agregarDibujable(vistaMesa);
		controlador.agregarDibujable(vistaAvioneta);
		
		/*
		 * finalmente establezco el intervalo de sleep dentro del gameloop
		 * y comienzo a ejecutar
		 */
		controlador.setIntervaloSimulacion(20);
		controlador.comenzarJuego();
		
	}
}
