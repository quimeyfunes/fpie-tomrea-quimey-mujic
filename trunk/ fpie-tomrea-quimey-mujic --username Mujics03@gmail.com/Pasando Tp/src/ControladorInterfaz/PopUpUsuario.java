package ControladorInterfaz;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class PopUpUsuario  extends JFrame { 
	
	public void start(){
		init();
	}
	
	
	 TextField txtUsuario;

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
	    // Con este usuario guardamos la partida en un hash
	     System.exit(0); 
	    
	     	    } 
	   }); 
	  add (txtUsuario); 
	 } 
	} 