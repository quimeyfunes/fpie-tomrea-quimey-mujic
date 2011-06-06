package Objetos_moviles;
import java.util.LinkedList;
import Escenario.*;
import Excepciones.ChauBlindajeException; 
import Mapa.Ubicacion;
import Armas.*;

public abstract class Voladores extends ObjetosMoviles{
	
	protected int Timing=0;
	protected ControladorArmas weapons = new ControladorArmas();
	
	protected void ActuarAnteColision(ObjetosMoviles movil){
		// Los aviones se dañan entre si
		//Danio danioTemp = this.fuerzaDeChoque(); 
		//this.analizarDanio( movil.fuerzaDeChoque() );
		//movil.analizarDanio( danioTemp );
	}
	
	protected void constructor(double x, double y, Voladores v)
	{
		v.setPosicion(Ubicacion.crearUbicacionEnXY(x, y));
		v.EstadoCorrecto();
		v.Vivo=true;
		Escenario.getInstance().agregarObjeto(v);//entra al mundo de los vivos		
	}
	
	
	public boolean PuedeManejarItems(){
		return true;
	}
	
	public boolean PuedeSerAtacado(){
		return true;
	}
	
	
	public void VerificarColision(){
		Escenario esc = Escenario.getInstance();
		// buscar tipo generico Collection
		LinkedList<ObjetosMoviles> todoLoQueEstaEnJuego = esc.objetosVivos();
		int j; 
		for ( j = 0 ; j == todoLoQueEstaEnJuego.size() ; j++ ){
			ObjetosMoviles elemento = todoLoQueEstaEnJuego.get( j );
			if ( this.condicionComun(elemento) ) elemento.ActuarAnteColision(this);
			}
		}
	
	public void agregarArma( ArmasFisicas arma )  throws ChauBlindajeException {
		if ( this.EstaVivo() ){ this.weapons.add(arma);} 
		 else throw new ChauBlindajeException();
	}
		
	public Municion disparar()  throws ChauBlindajeException {
		// Corregir metodo weapons,lo puse como public
		if ( this.EstaVivo() ){ 
			return  weapons.dispararElArmaSeleccionada( this.ubicacion.XY() );
		}
		 else throw new ChauBlindajeException();
	}
	
	public Danio fuerzaDeChoque(){
		Danio danio =  new Danio(blindaje.getHitPoints());
		return danio;
	}

	protected void manejarItemVida( ItemVida item )  throws ChauBlindajeException {
		// de dond sale blindaje
		if ( this.EstaVivo() ) {blindaje.repararPor( item ) ;}
		 else throw new ChauBlindajeException();
	}
	
	public void seleccionarSiguienteArma()  throws ChauBlindajeException {
		if ( this.EstaVivo() ){ weapons.seleccionarSiguienteArma();}
		 else throw new ChauBlindajeException();
	}
}
