package PruebaVis;

import java.awt.Event;
import java.awt.Menu;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.DibujableExtra;
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

		// seteo el controlador y lo dejo listo para correr
		ControladorJuego controlador = new ControladorJuego(false);
		
		Ventana ventanaMenu = new VentanaPrincipal(controlador, (int) LimiteX + 50, (int) LimiteY + 50);
		controlador.setSuperficieDeDibujo(ventanaMenu);
		ventanaMenu.setVisible(true);
		controlador.setIntervaloSimulacion(20);
		
		
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
		ventanaMenu.setVisible(false);
		Ventana ventana = new VentanaPrincipal(controlador, (int) LimiteX + 50, (int) LimiteY + 50);
		controlador.setSuperficieDeDibujo(ventana);
		ventana.setVisible(true);

		VistaFondoJuego fondoJuego = new VistaFondoJuego();
		controlador.agregarDibujable(fondoJuego);

		//controlador.setIntervaloSimulacion(20);
		// fin seteo controlador
		//Escenario.InicializarEscenario(controlador);

		ParserNivelesXml parser = new ParserNivelesXml();
		boolean perdio = false;
		boolean gano = false;
		while ((!perdio) && (!gano))
		{
			Escenario.InicializarEscenario(controlador);

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

			controlador.agregarObjetoVivo(Escenario.getInstance());
			
	
			
			Algo42 algo42 = new Algo42(950, 50);

			DibujableExtra vistaAlgo = new VistaBlindajeAlgo42();
			vistaAlgo.setMonitoreable(algo42);
			controlador.agregarDibujable(vistaAlgo);

			Dibujable VistaPuntos = new VistaPuntos(Escenario.getInstance());
			controlador.agregarDibujable(VistaPuntos);

			Guia guia = new Guia(20, 400);
			guia.setBlindaje(parser.getVidaGuia());

			controlador.agregarKeyPressObservador(algo42);
			
			
			try
			{
				controlador.comenzarJuego();
				Guardar partida = new Guardar();
				partida.GuardarPartida(algo42, Escenario.getInstance());
			}
			catch (GameOverException e)
			{
				System.out.println("Llgo al catch");
				VistaGameOver game_over = new VistaGameOver();
				controlador.agregarDibujable(game_over);
			}
			if(!perdio && parser.getUltimoNivel())
				gano = true;
			else if(!perdio)
				parser.pasarNivel();
				Cargar partida = new Cargar();
				partida.CargarPartida();
		}

		
		
	}
}
