package Persistencia;
import java.util.LinkedList;

import com.thoughtworks.xstream.XStream;

import Escenario.*;
import Objetos_moviles.ObjetosMoviles;

public class Persistencia {
	Escenario escenario = Escenario.getInstance();
	XStream xstream = new XStream();
	LinkedList<String> lista_xml = new LinkedList<String>();
	
	private void Persistir(){
		for (ObjetosMoviles elemento: escenario.objetosVivos() ){
			String xml = xstream.toXML(elemento);
			lista_xml.add( xml );
		}
	}

}

