package Escenario;

import java.util.LinkedList;

import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.Dibujable;

import Excepciones.FinEscenarioException;
import Objetos_moviles.ObjetosMoviles;

public class Escenario
{
	LinkedList<ObjetosMoviles> todoLoQueEstaEnJuego;
	int sumaDePuntos;
	static double LimiteX=1000;
	static double LimiteY=500;
	private static Escenario instance = null;
	private ControladorJuego controlador=null;
	
	
	static public double getLimiteX(){
		return LimiteX;
	}
	static public double getLimiteY(){
		return LimiteY;
	}
	
	 public static void  InicializarEscenario(ControladorJuego con){//si esto no se ejecuta primero, no funciona
		 createInstance();
		 instance.controlador=con;
	}
	
	private synchronized static void createInstance() {
		if (instance == null) { 
			instance = new Escenario();
	    }
	}
	
	public synchronized static void reiniciarEscenario() {
		instance = new Escenario();
	}
	
	public static Escenario getInstance() {
		if ( instance.controlador==null){
			throw new RuntimeException();
		}
	    return instance;
	}

	public Escenario()
	{
		sumaDePuntos = 0;
		todoLoQueEstaEnJuego = new LinkedList< ObjetosMoviles >();
	}
	
	public LinkedList<ObjetosMoviles> objetosVivos() 
	{
		return todoLoQueEstaEnJuego;
	}
	
	public void agregarObjeto(ObjetosMoviles objeto)
	{
		this.todoLoQueEstaEnJuego.add(objeto);//agrego para que pueda interactuar con otros objetos
		
		this.controlador.agregarObjetoVivo(objeto);//agrego al gameloop
		Dibujable vista = objeto.getVista();
		vista.setPosicionable(objeto);
		this.controlador.agregarDibujable(vista);//agrego a visibles ( reee polimorfico mal )
	}
	
	public void eliminarObjeto(ObjetosMoviles objeto)
	{
		this.todoLoQueEstaEnJuego.remove(objeto);
		//this.controlador.removerObjetoVivo(objeto);//lo saco del gameLoop
		//COMO VAMOS A HACER PARA PONER EN FALSE LA VISTA :s
	}


	private void limpiarListaYrecolectarPuntos()
	{
		//Itero sobre Muertos, borro sobre TodoLoQueEstaEnJuego , voy sumando puntos
		LinkedList<ObjetosMoviles> muertos = new LinkedList<ObjetosMoviles>();
		for (ObjetosMoviles movil : this.objetosVivos())
			if(!movil.EstaVivo())
				muertos.add(movil);
		
		for (ObjetosMoviles movil : muertos)
		{
			this.sumaDePuntos += movil.RecolectarPuntos();
			this.eliminarObjeto(movil);
		}
		
		if(this.sumaDePuntos >= 1000)
			throw new FinEscenarioException();
	}
	

	
	
}

