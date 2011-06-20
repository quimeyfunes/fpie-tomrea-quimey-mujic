package Menu;




import java.awt.Button;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import ControladorInterfaz.ControladorMenu;


public class MenuInicial {
	
	private ControladorMenu control;
	
	private PanelFondo frameTemp; //marco que contendrá los controles
	private PanelFondo tuto;

	private Button botonEmpezar = new Button("Empezar"); 
	private Button botonSalir = new Button("Salir"); 
	private Button botonTutorial = new Button("Tutorial"); 

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
		frameTemp = new PanelFondo("Algo42ContraElMundo"); //creamos el marco
		frameTemp.setImage("fondomenu.jpg");
		Panel panelBotones = new Panel(); //creamos un panel para los botones
		panelBotones.add(botonEmpezar); 
		panelBotones.add(botonSalir);  	
		panelBotones.add(botonTutorial);
		frameTemp.add("South", panelBotones);  //agregamos el panel al marco
		
		frameTemp.setSize(1000,700);  //seteamos las dimensiones del marco
		frameTemp.setVisible(true);  //mostramos el marco

		//agregamos el listener del evento de cerrado de la ventana		
		frameTemp.addWindowListener(new CloseListener());
	
		botonEmpezar.addActionListener(control.getListenerBotonEmpezar(this));
		botonSalir.addActionListener(control.getListenerBotonSalir());	
		botonTutorial.addActionListener(control.getListenerBotonTutorial(this));
		
	}
	
	public void MostrarTutorial(){
		
		this.frameTemp.setVisible(false);
		
		tuto = new PanelFondo("Tutorial"); //creamos el marco
		tuto.setImage("fondotutorial.jpg");
		Panel panelBotones = new Panel(); //creamos un panel para los botones
		panelBotones.add(botonSalir); 
		tuto.add("South", panelBotones);  //agregamos el panel al marco
		
		tuto.setSize(1300 ,750);  //seteamos las dimensiones del marco
		tuto.setVisible(true);  //mostramos el marco

		//agregamos el listener del evento de cerrado de la ventana		
		botonSalir.addActionListener(control.getListenerBotonAtras());	
	}
	
	public void MostrarMenuInicial(){
		this.frameTemp.setVisible(true);
		this.tuto.setVisible(false);
	}

	public void MostrarEmpezarJuego() {
		
	}


	
}