package Menu;


import java.awt.Button;
import java.awt.Label;
import java.awt.Panel;

import java.awt.TextField;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import ControladorInterfaz.ControladorMenu;


public class MenuInicial{
	
	private ControladorMenu control;
	
	private PanelFondo frameTemp; 
	private PanelFondo tuto;
	private boolean banderaJuego=false;
	private boolean banderaCargarJuego=false;
	private TextField Caja_texto = new TextField(15);
	
	//Clase auxiliar para escuchar el evento de cerrado de la ventana
	public static class CloseListener extends WindowAdapter
	{	public void windowClosing(WindowEvent e)
		{	e.getWindow().setVisible(false);
			System.exit(0);
		}
	}
	
	public MenuInicial(ControladorMenu control)
	{
		this.control=control;
		this.CrearMenuPrincipal();
		this.CrearTutorial();
		this.MostrarMenuInicial();
		
	}
	
	private void CrearMenuPrincipal(){
		//armado de la ventana
		this.frameTemp = new PanelFondo("Algo42ContraElMundo"); //creamos el marco
		this.frameTemp.setImage("fondomenu.jpg");
		Panel panelBotones = new Panel(); //creamos un panel para los botones
		
		 Button botonEmpezar = new Button("Empezar"); 
		 Button botonSalir = new Button("Salir"); 
		 Button botonTutorial = new Button("Tutorial"); 
		 Button botonCargarJuego = new Button("Cargar Juego"); 
		 Label lblUsuario = new Label ("Introduzca Usuario:"); 
		panelBotones.add(botonEmpezar); 
		panelBotones.add(botonSalir);  	
		panelBotones.add(botonTutorial);
		panelBotones.add(lblUsuario);
		panelBotones.add(Caja_texto);
		panelBotones.add(botonCargarJuego);
		this.frameTemp.add("South", panelBotones);  //agregamos el panel al marco
		this.frameTemp.setSize(1000,700);  //seteamos las dimensiones del marco
		//agregamos el listener del evento de cerrado de la ventana		
		this.frameTemp.addWindowListener(new CloseListener());
	
		botonEmpezar.addActionListener(control.getListenerBotonEmpezar(this));
		botonSalir.addActionListener(control.getListenerBotonSalir());	
		botonTutorial.addActionListener(control.getListenerBotonTutorial(this));
		botonCargarJuego.addActionListener(control.getListenerBotonCargarPartida(this));
	}
	
	private void CrearTutorial(){
		
		Button botonSalir = new Button("Volver a Menu Principal"); 
		
		tuto = new PanelFondo("Tutorial"); //creamos el marco
		tuto.setImage("fondotutorial.jpg");
		Panel panelBotones = new Panel(); //creamos un panel para los botones
		panelBotones.add(botonSalir); 
		tuto.add("South", panelBotones);  //agregamos el panel al marco
		
		tuto.setSize(1300 ,750);  //seteamos las dimensiones del marco

		//agregamos el listener del evento de cerrado de la ventana		
		botonSalir.addActionListener(control.getListenerBotonAtras(this));	
	}
	
	public void MostrarTutorial(){
		this.tuto.setVisible(true);
		this.frameTemp.setVisible(false);
	}
	
	
	public void MostrarMenuInicial(){
		this.frameTemp.setVisible(true);
		this.tuto.setVisible(false);
	}

	public synchronized void MostrarEmpezarJuego() {
		this.tuto.setVisible(false);
		this.frameTemp.setVisible(false);
		this.banderaJuego=true;
	}
	
	public boolean EmpiezaJuego(){
		return this.banderaJuego;
	}
	
	public synchronized void MostrarCargarJuego() {
		System.out.println("----Entro en MostrarCargarJuego");
		this.frameTemp.dispose();
		this.tuto.dispose();
		this.banderaCargarJuego = true;
		this.banderaJuego=true;
		
	}

	public boolean getCargarJuego() {
		return this.banderaCargarJuego;
	}

	public String getUsuario(){
		System.out.println("Leggo al getUsuario, el usuario es: ");
		System.out.println(Caja_texto.getText());
		return Caja_texto.getText();
	}
	
}