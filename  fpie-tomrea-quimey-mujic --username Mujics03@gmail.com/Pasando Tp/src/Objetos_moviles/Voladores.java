package Objetos_moviles;
import java.util.Iterator;
import java.util.LinkedList;
import Escenario.*;
import Excepciones.ChauBlindajeException; 
import Mapa.Ubicacion;
import Armas.*;

public abstract class Voladores extends ObjetosMoviles{
	
	protected int Timing=0;
	protected ControladorArmas weapons = new ControladorArmas();
	
	protected void ActuarAnteColision(ObjetosMoviles movil){
		// Los aviones se da�an entre si
		Danio danioTemp = this.fuerzaDeChoque(); 
		this.analizarDanio( ((Voladores)movil).fuerzaDeChoque() );
		movil.analizarDanio( danioTemp );
	}
	
	protected void constructor(double x, double y, Voladores v)
	{
		weapons = new ControladorArmas();
		this.Vivo = true;
		this.Timing = 0;
		v.setPosicion(Ubicacion.crearUbicacionEnXY(x, y));
		v.EstadoCorrecto();
		Escenario.getInstance().agregarObjeto(v);//entra al mundo de los vivos		
	}
	
	
	public boolean PuedeManejarItems(){
		return true;
	}
	
	public boolean PuedeSerAtacado(){
		return true;
	}
		
	public synchronized void  VerificarColision(){
		
		boolean bandera=false;
		LinkedList<ObjetosMoviles> ObjVi =  Escenario.getInstance().objetosVivos();
		Iterator<ObjetosMoviles> it = ObjVi.iterator();
		
		while(it.hasNext() && !bandera){
			ObjetosMoviles elemento = it.next();
			if ( (this.condicionComun(elemento))){
				elemento.ActuarAnteColision(this);
				bandera=true;
			}
		}
	}
	
	public void agregarArma( ArmasFisicas arma )  throws ChauBlindajeException {
		if ( this.EstaVivo() ){ this.weapons.add(arma);} 
		 else throw new ChauBlindajeException();
	}
		
	public  synchronized Municion disparar()  throws ChauBlindajeException {
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
