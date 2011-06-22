package Persistencia;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Hashtable;
import java.util.LinkedList;

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
		for (ObjetosMoviles elemento: escenario.objetosVivos() ) {
			lista_xml.add( elemento );
		}
		Usuarios.put(Usuario, lista_xml);
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
			for ( ObjetosMoviles elemento : (LinkedList<ObjetosMoviles>) Usuarios_persistidos.get(usuario) )	escenario.agregarObjeto(elemento);
		} catch (FileNotFoundException e) {
			System.out.println("Error archivo en Cargar");
			e.printStackTrace();
		}
	}
	
	public LinkedList getPartida(){
		return lista_xml;
	}

}

