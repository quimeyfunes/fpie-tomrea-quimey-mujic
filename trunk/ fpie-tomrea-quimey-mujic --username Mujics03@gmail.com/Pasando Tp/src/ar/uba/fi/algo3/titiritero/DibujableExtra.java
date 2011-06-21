package ar.uba.fi.algo3.titiritero;

/*
 * Esta interfaz expande la funcionalidad de dibujable, para que las vistas puedan hacerse
 * dinamicas y preguntarles mas cosas a los objetos del modelo que estan observando
 */

public interface DibujableExtra extends Dibujable {
	
	public Monitoreable getMonitoreable();
	public void setMonitoreable(Monitoreable monitoreable);
	public boolean Borrar();
	

}
