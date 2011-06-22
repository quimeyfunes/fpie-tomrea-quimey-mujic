package Persistencia;
import java.util.LinkedList;

import com.thoughtworks.xstream.XStream;

import Escenario.*;
import Objetos_moviles.ObjetosMoviles;

public class Persistencia {
	private Escenario escenario;
	private XStream xstream;
	private static LinkedList<String> lista_xml;
	
	public Persistencia(){
		this.escenario = Escenario.getInstance();
		this.xstream = new XStream();
		this.lista_xml = new LinkedList<String>();
	}
	
	public void Persistir(){
		for (ObjetosMoviles elemento: escenario.objetosVivos() ){
			String xml = xstream.toXML(elemento);
			lista_xml.add( xml );
		}
	}
	
	public void Cargar(LinkedList<String> lista_objetos){
		for (String elementoXml: lista_objetos){
			ObjetosMoviles objetoMovil = (ObjetosMoviles)xstream.fromXML(elementoXml);
			escenario.agregarObjeto(objetoMovil);
		}
	}
	
	public LinkedList getPartida(){
		return lista_xml;
	}

}

