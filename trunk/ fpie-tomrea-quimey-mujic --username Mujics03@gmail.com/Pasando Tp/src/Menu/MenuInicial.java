package Menu;




import java.awt.Button;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;

import ControladorInterfaz.ControladorMenu;


public class MenuInicial {
	
	private ControladorMenu control;
	
	private PanelFondo frameTemp; //marco que contendrá los controles
	private PanelFondo tuto;
	private boolean banderaJuego=false;

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
		//armado de la ventana
		this.frameTemp = new PanelFondo("Algo42ContraElMundo"); //creamos el marco
		this.frameTemp.setImage("fondomenu.jpg");
		Panel panelBotones = new Panel(); //creamos un panel para los botones
		
		 Button botonEmpezar = new Button("Empezar"); 
		 Button botonSalir = new Button("Salir"); 
		 Button botonTutorial = new Button("Tutorial"); 
		
		panelBotones.add(botonEmpezar); 
		panelBotones.add(botonSalir);  	
		panelBotones.add(botonTutorial);
		this.frameTemp.add("South", panelBotones);  //agregamos el panel al marco
		
		this.frameTemp.setSize(1000,700);  //seteamos las dimensiones del marco
		this.frameTemp.setVisible(true);  //mostramos el marco

		//agregamos el listener del evento de cerrado de la ventana		
		this.frameTemp.addWindowListener(new CloseListener());
	
		botonEmpezar.addActionListener(control.getListenerBotonEmpezar(this));
		botonSalir.addActionListener(control.getListenerBotonSalir());	
		botonTutorial.addActionListener(control.getListenerBotonTutorial(this));
		
		this.CrearTutorial();
		
	}
	
	public void CrearTutorial(){
		
		Button botonSalir = new Button("Salir"); 
		
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
		this.frameTemp.dispose();
		this.tuto.dispose();
		this.banderaJuego=true;
	}
	
	public boolean EmpiezaJuego(){
		return this.banderaJuego;
	}


	
}