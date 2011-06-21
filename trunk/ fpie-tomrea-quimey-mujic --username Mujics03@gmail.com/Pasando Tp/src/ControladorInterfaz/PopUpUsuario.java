package ControladorInterfaz;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PopUpUsuario  extends Applet { 
	 
	
	public void start(){
		init();
	}
	
	
	 TextField txtUsuario;

	 public void init () 
	 { 
	  // Establece color azul para el applet 
	  setBackground (Color.lightGray);

	  // Crea etiqueta 
	  Label lblUsuario = new Label ("Introduzca su nombre:"); 
	  add (lblUsuario);

	  // Crea caja de texto amarilla 
	  txtUsuario = new TextField (15); 
	  txtUsuario.setBackground (Color.white); 
	  txtUsuario.addActionListener (new ActionListener ()
	  
	   { 
	    public void actionPerformed (ActionEvent evt) 
	    { 
	     String strUsuario = txtUsuario.getText (); 
	    // Con este usuario guardamos la partida en un hash
	     System.exit(0); 
	    
	     	    } 
	   }); 
	  add (txtUsuario); 
	 } 
	} 