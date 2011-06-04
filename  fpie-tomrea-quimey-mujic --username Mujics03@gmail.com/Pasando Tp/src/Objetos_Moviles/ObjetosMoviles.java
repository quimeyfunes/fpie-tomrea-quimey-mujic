package ObjetosMoviles;

import Armas.Blindaje;
import Armas.Danio;
import Excepciones.*;
import Mapa.Ubicacion;
import Mapa.Vector2D;


import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;

public abstract class ObjetosMoviles {

	boolean Vivo;
	Ubicacion ubicacion;
	int puntos;
	Blindaje blindaje;
	EstrategiaDeVuelo estrategia_vuelo;
	byte bando;
	byte Velocidad;
	Rectangle2D.Double Cuerpo;
	
	//Constantes
	public static byte BandoUsuario(){
		return 1;
	}
	
	public static byte BandoEnemigo(){
		return 2;
		
	}
	//Fin
	
	public void Destructor(){
		Vivo = false;
	}
	
	//LIMITES
	public boolean EstaCercaAlAlimiteDerecho(){
		return ubicacion.EstaCercaAlAlimiteDerecho();
	}
	
	public boolean EstaCercaAlAlimiteIzquierdo(){
		return ubicacion.EstaCercaAlAlimiteIzquierdo();
	}
	
	public boolean EstaCercaAlAlimiteSuperior(){
		return ubicacion.EstaCercaAlAlimiteSuperior();
	}
	
	public boolean EstaCercaAlAlimiteInferior(){
		return ubicacion.EstaCercaAlAlimiteInferior();
	}
	//FIN LIMITES
	
	public boolean EstaVivo(){
		return Vivo;
	}
	
	public int RecolectarPuntos(){
		if ( this.Vivo ) return 0; 
		else return puntos;
	}
	
	//"ENTRE OBJETOS"
	public void analizarDanio( Danio danio ){
		
		try{		
		blindaje.daniar( danio );
		}
		catch(ChauBlindajeException ChauE){
			this.Destructor();
			}
		}
	
	public void CambiarEstrategiaDeVuelo( EstrategiaDeVuelo nueva_estrategia ) throws ChauBlindajeException{
		if ( this.Vivo ) estrategia_vuelo = nueva_estrategia;
		else{
			throw new ChauBlindajeException();
		}
	}

	public byte getBando(){
		return bando;
	}
	
	public Rectangle2D.Double getCuerpo(){
		return Cuerpo;
		
	}

	public Vector2D getPosicion(){
		
	}
	//FIN "ENTRE OBJETOS"
	private void moverse(){
		if ( this.Vivo ) this.estrategia_vuelo.CalcularMovimiento( this );
	}
	
	public void moverseIAsegunVel() throws ChauBlindajeException{
		if ( this.Vivo ) {
			for ( int i = 0 ; i == Velocidad ; i++ ) this.moverse();
		}
		else{
			throw new ChauBlindajeException();
		}
	}
	
	public void setBando( byte unBando ){
		bando = unBando;
	}
	
	public void setBlindaje( short cantidad ){
		blindaje = new Blindaje( cantidad ); 
	}
	
	public void setPosicion( Ubicacion ubi ){
		ubicacion = ubi;
	}
	
	//MOVIMIENTOS
	public void arriba(){
		Vector2D pt= new Vector2D(0,1);
		this.direccion(pt);
	}
	public void abajo(){
		Vector2D pt= new Vector2D(0,-1);
		this.direccion(pt);
	}
	public void derecha(){
		Vector2D pt = new Vector2D(1,0);
		this.direccion(pt);
	}
	public void izquierda(){
		Vector2D pt= new Vector2D(-1,0);
		this.direccion(pt);
	}
	
	public void direccion( Vector2D DireccionAmoverse ){
		
		if (this.EstaVivo()){ this.Direccion(DireccionAmoverse);}
		else{
			throw new ChauBlindajeException();
			}
		}

	private void Direccion(Vector2D DirToMove) {
		//"normaliza el movimiento a minimo movimiento"
		DirToMove.normalizeThis();
		DirToMove.scaleThis( EstrategiaDeVuelo.getMinimoMovimiento());
		
		try{
			ubicacion.translateBy(DirToMove);
			
			double TempAncho = Cuerpo.width;
			double TempTamanio = Cuerpo.height;
			
			//una forma de trasladar el rectangulo.
			Cuerpo = new Rectangle2D.Double(Cuerpo.x +(DirToMove.x),Cuerpo.y+(DirToMove.y), TempAncho, TempTamanio);
			this.VerificarColision();
			
		}catch( OffLimitsException OffExc ){
			this.Destructor();
			
		}
		

		
		
		
	}
	
	//Fin sector movimientos
}