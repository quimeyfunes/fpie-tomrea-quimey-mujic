package Menu;




import java.awt.Button;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import ControladorInterfaz.ControladorMenu;


public class MenuInicial {
	
	private PanelFondo frameTemp; //marco que contendrá los controles

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
		//armado de la ventana
		frameTemp = new PanelFondo("Algo42ContraElMundo"); //creamos el marco
		Panel panelBotones = new Panel(); //creamos un panel para los botones
		panelBotones.add(botonEmpezar); 
		panelBotones.add(botonSalir);  	
		panelBotones.add(botonTutorial);
		frameTemp.add("South", panelBotones);  //agregamos el panel al marco
		
		frameTemp.setSize(1000,700);  //seteamos las dimensiones del marco
		frameTemp.setVisible(true);  //mostramos el marco

		//agregamos el listener del evento de cerrado de la ventana		
		frameTemp.addWindowListener(new CloseListener());
	
		botonEmpezar.addActionListener(control.getListenerBotonEmpezar());
		botonSalir.addActionListener(control.getListenerBotonSalir());	
		botonTutorial.addActionListener(control.getListenerBotonTutorial());
		
	}


	
}