package Persistencia;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Hashtable;
import java.util.LinkedList;
import Menu.*;

import com.thoughtworks.xstream.XStream;

import Escenario.*;
import Objetos_moviles.ObjetosMoviles;

public class Persistencia {
	private Escenario escenario;
	private XStream xstream;
	private static LinkedList<ObjetosMoviles> lista_xml;
	
	public Persistencia(){
		this.escenario = Escenario.getInstance();
		this.xstream = new XStream();
		this.lista_xml = new LinkedList<ObjetosMoviles>();
	}
	
	public void Persistir(String Usuario, Hashtable Usuarios){
		System.out.println("Cantidad en Persistir");
		System.out.println((escenario.objetosVivos()).size());
		for (ObjetosMoviles elemento: escenario.objetosVivos() ) {
			lista_xml.add( elemento );
		}
		String nivel = Usuario + "Nivel";
		Usuarios.put(nivel , escenario.getNivelActiual());
		String puntos = Usuario + "Puntos";
		Usuarios.put(Usuario, lista_xml);
		Usuarios.put(puntos, escenario.getPuntos());
		try {
			
			xstream.toXML(Usuarios,new FileOutputStream("Hash_usuarios.xml"));
		} catch (FileNotFoundException e) {
			System.out.println("Error archivo en persistir");
			e.printStackTrace();
		}
	}
	
	public void Cargar(String usuario){
		try {
			Hashtable Usuarios_persistidos = (Hashtable) xstream.fromXML(new FileInputStream("Hash_usuarios.xml"));
			LinkedList<ObjetosMoviles> lista_a_cargar = (LinkedList<ObjetosMoviles>) Usuarios_persistidos.get(usuario);
			if (lista_a_cargar == null ) {
				Juego juego = new Juego();
				juego.jugar();
			}
			for ( ObjetosMoviles elemento : lista_a_cargar )	escenario.agregarObjeto(elemento);
		} catch (FileNotFoundException e) {
			Juego juego = new Juego();
			juego.jugar();
		}
	}
	
	public LinkedList getPartida(){
		return lista_xml;
	}
	public int getPuntos(String Usuario){
		Hashtable Usuarios_persistidos;
		try {
			Usuarios_persistidos = (Hashtable) xstream.fromXML(new FileInputStream("Hash_usuarios.xml"));
			String puntos = Usuario + "Puntos";
			return (Integer) Usuarios_persistidos.get(puntos);
		} catch (FileNotFoundException e) {
			return 0;
		}
	}
	public int getNivel(String Usuario){
		Hashtable Usuarios_persistidos;
		try {
			Usuarios_persistidos = (Hashtable) xstream.fromXML(new FileInputStream("Hash_usuarios.xml"));
			String nivel = Usuario + "Nivel";
			return (Integer) Usuarios_persistidos.get(nivel);
		} catch (FileNotFoundException e) {
			return 0;
		}
	}
}

