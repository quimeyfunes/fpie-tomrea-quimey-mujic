package PruebaVis;

import java.util.Random;

import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.DibujableExtra;
import Sonido.Sound;
import Vistas.*;
import ar.uba.fi.algo3.titiritero.vista.Ventana;
import Escenario.Escenario;
import Excepciones.GameOverException;
import ManejoXml.ParserNivelesXml;

import Menu.MenuInicial;
import Objetos_moviles.*;
import Persistencia.*;

public class PruebaVisual
{

	public static void main(String[] args)
	{

		double LimiteX = Escenario.getLimiteX();
		double LimiteY = Escenario.getLimiteY();
		double AltDeEnemy = LimiteY - 20;
		// esos son limites que uso para probar la simulacion

		Sound testsong = new Sound("Laguerradelasgalaxias.mid");
		testsong.playSound();
		
		// seteo el controlador y lo dejo listo para correr
		ControladorJuego controlador = new ControladorJuego(false);
		controlador.setIntervaloSimulacion(20);
		Escenario.InicializarEscenario(controlador);
		//+++++++++++++++++++++++++++++++
		
		Ventana ventanaMenu = new VentanaPrincipal(controlador, (int) LimiteX + 50, (int) LimiteY + 50);
		controlador.setSuperficieDeDibujo(ventanaMenu);
		ventanaMenu.setVisible(true);
		
		 
		MenuInicial menuListener = new MenuInicial();
		VistaFondoMenuInicial fondo = new VistaFondoMenuInicial();
		VistaEmpezarNivelBoton vistaEmpezar = new VistaEmpezarNivelBoton();
		VistaSalirJuegoBoton vistaSalir = new VistaSalirJuegoBoton();

		menuListener.setControlador(controlador);

		controlador.agregarMouseClickObservador(menuListener);
		controlador.agregarDibujable(fondo);
		controlador.agregarDibujable(vistaEmpezar);
		controlador.agregarDibujable(vistaSalir);
		
		try{
			controlador.comenzarJuego();
		}catch(Exception e){
			
		}
		controlador.DetenerBorrarJuego();
		controlador.comenzarJuego(1);
		menuListener=null;//ya no esta mas
		vistaEmpezar=null;
		vistaSalir=null;
		ventanaMenu.dispose();//asi no queda colgado atras
		
		Ventana ventana = new VentanaPrincipal(controlador, (int) LimiteX + 50, (int) LimiteY + 50);
		controlador.setSuperficieDeDibujo(ventana);
		ventana.setVisible(true);
		

		ParserNivelesXml parser = new ParserNivelesXml();
		boolean perdio = false;
		boolean gano = false;
		while ((!perdio) && (!gano))
		{
			VistaFondoJuego fondoJuego = new VistaFondoJuego();
			controlador.agregarDibujable(fondoJuego);
			
			controlador.agregarObjetoVivo(Escenario.getInstance());

			Random r = new Random();
			for (int i = 0; i < parser.getCantCazas(); i++)
			{
				Caza caza = new Caza((double) r.nextInt((int) Escenario.getLimiteX()), AltDeEnemy);
			}

			for (int i = 0; i < parser.getCantExploradores(); i++)
			{
				Exploradores explorador = new Exploradores((double) r.nextInt((int) Escenario.getLimiteX()), AltDeEnemy);
			}

			for (int i = 0; i < parser.getCantAvionetas(); i++)
			{
				Avioneta avioneta = new Avioneta((double) r.nextInt((int) Escenario.getLimiteX()), AltDeEnemy);
			}

			for (int i = 0; i < parser.getCantBombarderos(); i++)
			{
				Bombardero bombardero = new Bombardero((double) r.nextInt((int) Escenario.getLimiteX()), AltDeEnemy);
			}

			for (int i = 0; i < parser.getCantAvionCivil(); i++)
			{
				AvionCivil avion = new AvionCivil((double) r.nextInt((int) Escenario.getLimiteX()), (double) r
						.nextInt((int) Escenario.getLimiteY()));
			}

			for (int i = 0; i < parser.getCantHelicopteros(); i++)
			{
				HelicopterosPoliciaCivil hel = new HelicopterosPoliciaCivil((double) r.nextInt((int) Escenario
						.getLimiteX()), (double) r.nextInt((int) Escenario.getLimiteY()));
			}
			
			Guia guia = new Guia(20, 400);
			guia.setBlindaje(parser.getVidaGuia());
			
			Algo42 algo42 = new Algo42(950, 50);//ver de definir esto afuera
			DibujableExtra vistaAlgo = new VistaBlindajeAlgo42();
			vistaAlgo.setMonitoreable(algo42);
			controlador.agregarDibujable(vistaAlgo);
			Dibujable VistaPuntos = new VistaPuntos(Escenario.getInstance());
			controlador.agregarDibujable(VistaPuntos);


			controlador.agregarKeyPressObservador(algo42);
			
			
			try
			{
				controlador.comenzarJuego();
				//Guardar partida = new Guardar();
				//partida.GuardarPartida(algo42, Escenario.getInstance());
			}
			catch (GameOverException e)
			{
				perdio=true;
				System.out.println("Perdiste, entrena mas nw");
				testsong.cambiarTema("Whispering.mid");
			}
			
			if(!perdio && parser.getUltimoNivel()){
				gano = true;
			}
			else if(!perdio){
				parser.pasarNivel();
			System.out.println("nivel ganado");
				//Cargar partida = new Cargar();
				//partida.CargarPartida();
			}
		}
		
		controlador.DetenerBorrarJuego();
		VistaGameOver game_over = new VistaGameOver();
		controlador.agregarDibujable(game_over);
		controlador.comenzarJuego();

		
		
	}
}
