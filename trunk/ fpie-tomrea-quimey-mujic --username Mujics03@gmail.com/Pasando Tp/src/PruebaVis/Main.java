package PruebaVis;


import java.util.Random;

import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.DibujableExtra;
import ar.uba.fi.algo3.titiritero.vista.Ventana;
import ControladorInterfaz.ControladorMenu;
import Escenario.Escenario;

import ManejoXml.ParserNivelesXml;
import Menu.MenuInicial;
import Objetos_moviles.Algo42;
import Objetos_moviles.AvionCivil;
import Objetos_moviles.Avioneta;
import Objetos_moviles.Bombardero;
import Objetos_moviles.Caza;
import Objetos_moviles.Exploradores;
import Objetos_moviles.Guia;
import Objetos_moviles.HelicopterosPoliciaCivil;
import Sonido.Sound;
import Vistas.VentanaPrincipal;
import Vistas.VistaBlindajeAlgo42;
import Vistas.VistaFondoJuego;
import Vistas.VistaGameOver;
import Vistas.VistaNextLevel;
import Vistas.VistaPuntos;
import Vistas.VistaWinner;

//import Persistencia.*;

public class Main
{
	public static void main(String[] args)
	{

		ControladorMenu conMenu = new ControladorMenu();
		
		MenuInicial menu = new MenuInicial( conMenu );
		

	}


}
