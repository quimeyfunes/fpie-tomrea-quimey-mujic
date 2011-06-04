package Objetos_moviles;
import java.util.LinkedList;
import Escenario.*;
import Excepciones.ChauBlindajeException; 
import Armas.*;
import Objetos_moviles.*;

public class Voladores extends ObjetosMoviles{

	boolean vivo;
	int Timing;
	ControladorArmas weapons;
	
	protected void ActuarAnteColision(ObjetosMoviles movil){
		// Los aviones se dañan entre si
		Danio danioTemp = this.fuerzaDeChoque(); 
		this.analizarDanio( movil.fuerzaDeChoque() );
		movil.analizarDanio( danioTemp );
	}
	
	
	public boolean PuedeManejarItems(){
		return true;
	}
	
	public boolean PuedeSerAtacado(){
		return true;
	}
	
	
	protected void VerificarColision(){
		Escenario escenario = escenario.getInstance();
		// buscar tipo generico Collection
		Collection todoLoQueEstaEnJuego = escenario.objetosVivos();
		int j; 
		for ( j = 0 , j = todoLoQueEstaEnJuego.size() , j++ ){
			ObjetosMoviles elemento = todoLoQueEstaEnJuego.get( j );
			if ( this.condicionComun(elemento) ) elemento.ActuarAnteColision(this);
			}
		}
	
	public void agregarArma( ArmasFisicas arma )  throws ChauBlindajeException {
		if ( this.EstaVivo() ) weapons.add(arma) {
		} else throw new ChauBlindajeException();
	}
		
	protected Municion disparar()  throws ChauBlindajeException {
		// Corregir metodo weapons
		if ( this.EstaVivo() ) weapons.dispararElArmaSeleccionadaDesde( ubicacion XY ){
		} else throw new ChauBlindajeException();
	}
	
	protected Danio fuerzaDeChoque(){
		// verificar porque no reconoce el new, d dond sale blindaje
		Danio danio =  new Danio();
		danio.Danio( blindaje.getHitPoints() );
		return danio;
	}
	
	public void main(String[] args) {
		vivo = true;
		Timing = 0;
		weapons = new ControladorArmas();
	}

	protected void manejarItemVida( ItemVida item )  throws ChauBlindajeException {
		// de dond sale blindaje
		if ( this.EstaVivo() ) blindaje.repararPor( item ) {
		} else throw new ChauBlindajeException();
	}
	
	protected void seleccionarSiguienteArma()  throws ChauBlindajeException {
		// no reconoce weapons
		if ( this.EstaVivo() ) weapons.seleccionarSiguienteArma(){
		} else throw new ChauBlindajeException();
	}
}
