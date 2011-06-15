package Escenario;

import java.util.Iterator;
import java.util.LinkedList;

import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.DibujableExtra;
import ar.uba.fi.algo3.titiritero.ObjetoVivo;
import ar.uba.fi.algo3.titiritero.vista.ObjetoDeTexto;
import Objetos_moviles.Algo42;
import Objetos_moviles.ObjetosMoviles;
import Excepciones.FinEscenarioException;

public class Escenario implements ObjetoVivo,ObjetoDeTexto
{
	LinkedList<ObjetosMoviles> todoLoQueEstaEnJuego;
	LinkedList<ObjetosMoviles> temp;
	int sumaDePuntos;
	static double LimiteX=1200;
	static double LimiteY=500;
	private static Escenario instance = null;
	private ControladorJuego controlador=null;
	
	
	static synchronized public double getLimiteX(){
		return LimiteX;
	}
	static synchronized public double getLimiteY(){
		return LimiteY;
	}
	
	 public synchronized static void  InicializarEscenario(ControladorJuego con){//si esto no se ejecuta primero, no funciona
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
	
	public static synchronized Escenario getInstance() {
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
	
	public synchronized LinkedList<ObjetosMoviles> objetosVivos() 
	{
		
		return todoLoQueEstaEnJuego;
	}
	
	public synchronized void agregarObjeto(ObjetosMoviles objeto)
	{		
		this.todoLoQueEstaEnJuego.add(objeto);
		
		this.controlador.agregarObjetoVivo(objeto);//agrego al gameloop
		DibujableExtra vista = objeto.getVista();
		vista.setMonitoreable(objeto);
		this.controlador.agregarDibujable((Dibujable)vista);//agrego a visibles ( reee polimorfico mal )
	}
	
	public  synchronized void eliminarObjeto(ObjetosMoviles objeto)
	{//hay que hacer esto bien de alguna forma
		this.todoLoQueEstaEnJuego.remove(objeto);
		this.controlador.removerObjetoVivo(objeto);//lo saco del gameLoop
		this.controlador.removerDibujable(objeto.getVista());
	}


	private synchronized void limpiarListaYrecolectarPuntos()
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
		
		if( (this.sumaDePuntos >= 1000 )|| (this.NoQuedanEnemigos())){//aca va la logistica de pasar de level
			//this.controlador.detenerJuego();
			throw new FinEscenarioException();
		}
	}
		
	@Override
	public void vivir() {
		this.limpiarListaYrecolectarPuntos();
	}
	
	public int getPuntos(){
		return this.sumaDePuntos;
	}
	@Override
	public String getTexto() {
		return String.valueOf((this.sumaDePuntos)) ;
	}
	
	 private boolean NoQuedanEnemigos(){
		 boolean NoHayEnemigos=true;
		 boolean Algo42EstaVivo=false;
		 Iterator<ObjetosMoviles> it = this.todoLoQueEstaEnJuego.iterator();
		 
		 while(NoHayEnemigos && it.hasNext()){
			 ObjetosMoviles obj = it.next();
			 
			 if (obj.getBando()!=ObjetosMoviles.BandoUsuario()){
				 NoHayEnemigos=false;	 
			 }else
				 if(obj.getClass()==Algo42.class){//no esta mal porque estamos pidiendo por el user
					 Algo42EstaVivo=true; 
				 }
		 }
		 return( NoHayEnemigos)&&(Algo42EstaVivo ); 
	 }
			 
		
	}
	



