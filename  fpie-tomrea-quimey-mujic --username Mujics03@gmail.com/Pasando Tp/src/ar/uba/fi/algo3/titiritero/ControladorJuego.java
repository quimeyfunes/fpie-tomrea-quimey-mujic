package ar.uba.fi.algo3.titiritero;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import Excepciones.GameOverException;
import ar.uba.fi.algo3.titiritero.audio.Reproductor;

import Excepciones.FinEscenarioException;

/**
 * @author Nicolas
 * Esta clase es la encargada de manejar todo el gameloop. Básicamente tiene una lista
 * de ObjetosVivos y una Dibujables que son recorridas en cada gameloop.
 */
public class ControladorJuego implements Runnable {
	
	public ControladorJuego(boolean activarReproductor){
		
		this.objetosVivos = new ArrayList<ObjetoVivo>();
		this.dibujables = new ArrayList<Dibujable>();
		this.mouseClickObservadores = new ArrayList<MouseClickObservador>();
		this.keyPressedObservadores = new ArrayList<KeyPressedObservador>();
		this.estaReproductorActivo = activarReproductor;
		if(this.estaReproductorActivo)
			this.reproductor = new Reproductor();
			
		
	}
	
	public boolean estaEnEjecucion(){
		return this.estaEnEjecucion;
	}
	
	public void comenzarJuego(){
		estaEnEjecucion = true;
		
		try{
			while(estaEnEjecucion){
				simular();
				dibujar();
				Thread.sleep(intervaloSimulacion);
				this.ActualizarListas();//Lo agregue para poder agregar cosas "mientras corre el loop"
			}
		}
		catch (Exception e) 
		{
			if(e.getClass()== GameOverException.class){
				throw (GameOverException)e;
			}
			else{
				if(e.getClass()== FinEscenarioException.class){
				this.DetenerBorrarJuego();//esto se puede mejorar deteniendo en escenario
				}
			}
		}
	}

	public void comenzarJuegoAsyn(){
		Thread thread = new Thread(this);
		thread.start();
		if(this.estaReproductorActivo){
			this.reproductor.encender();
			this.hiloAudio =  new Thread(this.reproductor);
			this.hiloAudio.start();
		}
	}

	/**
	 * Le da comienzo al juego poniendo en marcha el gameloop.
	 * @param cantidadDeCiclos cantidad de ciclos que debe correr el gameloop..  
	 */
	public void comenzarJuego(int cantidadDeCiclos){
		int contador = 0;
		estaEnEjecucion = true;
		try{
			while(contador < cantidadDeCiclos && estaEnEjecucion){
				simular();
				dibujar();
				Thread.sleep(intervaloSimulacion);
				contador++;
				this.ActualizarListas();//Lo agregue para poder agregar cosas "mientras corre el loop"
			}
		}
		catch (Exception e) {
			if(e.getClass()== GameOverException.class)
				throw (GameOverException)e;
			else
				if(e.getClass()== FinEscenarioException.class)
					this.DetenerBorrarJuego();//esto se puede mejorar deteniendo en escenario
		}
	}
	
	/**
	 * Detiene el juego provocando la salida del gameloop.
	 */
	public void DetenerBorrarJuego(){
		this.objetosVivos.clear();
		this.keyPressedObservadores.clear();
		this.mouseClickObservadores.clear();
		this.dibujables.clear();
		this.RestartearListasTemporales();
		this.estaEnEjecucion = false;
		if(reproductor!=null)
			this.reproductor.apagar();
	}
	
	public void detenerJuego(){
		this.estaEnEjecucion = false;
		if(reproductor!=null)
			this.reproductor.apagar();
	}
	
	public void agregarObjetoVivo(ObjetoVivo objetoVivo){
		//objetosVivos.add(objetoVivo);
		this.ObjetosVivosAagregarAlFinalDeUnLoop.add(objetoVivo);
	}
	
	public void removerObjetoVivo(ObjetoVivo objetoVivo){
		//objetosVivos.remove(objetoVivo);
		this.ObjetosVivosAeliminarAlFinalDeUnLoop.add(objetoVivo);
	}

	public void agregarDibujable(Dibujable unDibujable){
		//dibujables.add(unDibujable);
		this.DibujablesAagregarAlFinalDeUnLoop.add(unDibujable);
	}
	
	public void removerDibujable(Dibujable unDibujable){
		//dibujables.remove(unDibujable);
		this.DibujablesAeliminarAlFinalDeUnLoop.add(unDibujable);
	}
	
	public long getIntervaloSimulacion() {
		return intervaloSimulacion;
	}

	public void setIntervaloSimulacion(long intervaloSimulacion) {
		this.intervaloSimulacion = intervaloSimulacion;
	}
 
	private void dibujar() {
		Iterator<Dibujable> iterador = dibujables.iterator();
		while(iterador.hasNext()){
			Dibujable dibujable = iterador.next();			
			dibujable.dibujar(this.superficieDeDibujo);	
			
			if (dibujable.Borrar()){
				this.removerDibujable(dibujable);
				}
			
			}		
		this.superficieDeDibujo.actualizar();
	}
	
	/**
	 * Ejecuta la simulacion recorriendo la coleccion de objetivos vivos.
	 */
	private void simular() {
		this.superficieDeDibujo.limpiar();
		Iterator<ObjetoVivo> iterador = objetosVivos.iterator();
		while(iterador.hasNext()){
			iterador.next().vivir();
		}
	}

	public SuperficieDeDibujo getSuperficieDeDibujo() {
		return superficieDeDibujo;
	}

	public void setSuperficieDeDibujo(SuperficieDeDibujo superficieDeDibujo) {
		this.superficieDeDibujo = superficieDeDibujo;
	}
	
	/**
	 * Se encarga de derivar el manejo del evento click al objeto vista correspondiente
	 * @param x posición horizontal del mouse
	 * @param y posición vertial del mouse
	 */
	public void despacharMouseClick(int x, int y){
		MouseClickObservador mouseClickObservador;
		Iterator<MouseClickObservador> iterador = this.mouseClickObservadores.iterator();
		while(iterador.hasNext()){
			mouseClickObservador = iterador.next();
			mouseClickObservador.MouseClick(x, y);
		}
	}
	
	public void agregarMouseClickObservador(MouseClickObservador unMouseClickObservador){
		this.mouseClickObservadores.add(unMouseClickObservador);
	}
	
	public void removerMouseClickObservador(MouseClickObservador unMouseClickObservador){
		this.mouseClickObservadores.remove(unMouseClickObservador);
	}
	
	/**
	 * Se encarga de derivar el manejo del evento keyPress al objeto vista correspondiente
	 * @param KeyEvent evento
	 */
	public void despacharKeyPress(KeyEvent event){
		for (KeyPressedObservador observador : this.keyPressedObservadores){
			observador.keyPressed(event);
		}
	}
	
	public void agregarKeyPressObservador(KeyPressedObservador unMouseClickObservador){
		this.keyPressedObservadores.add(unMouseClickObservador);
	}
	
	public void removerKeyPressObservador(KeyPressedObservador unMouseClickObservador){
		this.keyPressedObservadores.remove(unMouseClickObservador);
	}	
	
	
	//*****************************************************
	private void ActualizarListas(){
		
	this.ActualizarObjetosVivosNuevos();
	this.ActualizarDibujablesNuevos();
	this.ActualizarObjetosVivosAeliminar();
	this.ActualizarDibujablesAeliminar();
	this.RestartearListasTemporales();
		
	}
	
	private void ActualizarObjetosVivosNuevos(){
		if (!this.ObjetosVivosAagregarAlFinalDeUnLoop.isEmpty()){
			for(ObjetoVivo obj :this.ObjetosVivosAagregarAlFinalDeUnLoop){			
			this.objetosVivos.add(obj);
		}
		}
	}

	private void ActualizarDibujablesNuevos(){
		if (!this.DibujablesAagregarAlFinalDeUnLoop.isEmpty()){
			for(Dibujable dib :this.DibujablesAagregarAlFinalDeUnLoop){			
			this.dibujables.add(dib);
		}
		}
	}
	
	private void ActualizarObjetosVivosAeliminar(){
	if (!this.ObjetosVivosAeliminarAlFinalDeUnLoop.isEmpty()){
		for(ObjetoVivo obj :this.ObjetosVivosAeliminarAlFinalDeUnLoop){			
		this.objetosVivos.remove(obj);
		}
		}
	}
	
	private void ActualizarDibujablesAeliminar(){
		if (!this.DibujablesAeliminarAlFinalDeUnLoop.isEmpty()){
			for(Dibujable dib :this.DibujablesAeliminarAlFinalDeUnLoop){			
			this.dibujables.remove(dib);
			}
			}
		}
	
	private void RestartearListasTemporales(){
		this.ObjetosVivosAagregarAlFinalDeUnLoop.clear();
		this.ObjetosVivosAeliminarAlFinalDeUnLoop.clear();
		this.DibujablesAagregarAlFinalDeUnLoop.clear();
		this.DibujablesAeliminarAlFinalDeUnLoop.clear();
		
	}
	//esto lo agregue yo para poder agregar cosas "mientras corre el loop"
	private List<ObjetoVivo> ObjetosVivosAagregarAlFinalDeUnLoop= new ArrayList<ObjetoVivo>();
	private List<Dibujable> DibujablesAagregarAlFinalDeUnLoop= new ArrayList<Dibujable>();
	private List<ObjetoVivo> ObjetosVivosAeliminarAlFinalDeUnLoop= new ArrayList<ObjetoVivo>();
	private List<Dibujable> DibujablesAeliminarAlFinalDeUnLoop= new ArrayList<Dibujable>();
	//******************************************************************************
	
	private long intervaloSimulacion;
	private boolean estaEnEjecucion;
	private List<ObjetoVivo> objetosVivos;
	private List<Dibujable> dibujables;
	private List<MouseClickObservador> mouseClickObservadores;
	private List<KeyPressedObservador> keyPressedObservadores;
	private SuperficieDeDibujo superficieDeDibujo;
	private Reproductor reproductor;
	private Thread hiloAudio;
	private boolean estaReproductorActivo;
	
	public void run() {
		this.comenzarJuego();
	}

	public Reproductor getReproductorDeAudio() {
		if(!this.estaReproductorActivo)
			throw new OperacionNoValida();
		return this.reproductor;
	}	
}
