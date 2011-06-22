package ControladorInterfaz;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import Persistencia.Persistencia;
import Escenario.*;
import javax.swing.JFrame;

public class PopUpUsuario  extends JFrame { 
	
	public void start(){
		init();
	}
	
	
	
	 TextField txtUsuario;
	 String strUsuario;
	 
	 public void init () 
	 { 
	  // Establece color azul para el applet 
	  setBackground (Color.lightGray);


	  // Crea caja de texto amarilla 
	  txtUsuario = new TextField ("Escriba su Nombre", 15); 
	  txtUsuario.setBackground (Color.white); 
	  txtUsuario.addActionListener (new ActionListener ()
	  
	   { 
	    public void actionPerformed (ActionEvent evt) 
	    { 
	     String strUsuario = txtUsuario.getText ();
	     System.out.println(strUsuario);
	     Escenario escenario = Escenario.getInstance();
	     Hashtable usuarios = escenario.getUsuarios();
	     Persistencia persis = new Persistencia();
	     persis.Persistir(strUsuario, usuarios);	    
	     System.exit(0);
	    }
	   }); 
	  add (txtUsuario);
	  
	 } 
	 
}

	