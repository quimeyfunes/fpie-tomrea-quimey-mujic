package Objetos_Moviles;
import java.awt.Point;

import Mapa.Ubicacion;

public abstract class Objetos_moviles {

	boolean Vivo;
	Ubicacion ubicacion;
	int puntos;
	Blindaje blindaje;
	Estrategia_De_Vuelo estrategia_vuelo;
	String bando;
	int Velocidad;
	
	public void Destructor(){
		Vivo = false;
	}
	
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
	
	public boolean EstaVivo(){
		return Vivo;
	}
	
	public int RecolectarPuntos(){
		if ( this.Vivo ) return 0; 
		else return puntos;
	}
	
	public void Recibir_danio( int danio ){
		blindaje.Daniar_por( danio );
		// falta On 0 vida morir
	}
	
	public void Cambiar_Estrategia_De_Vuelo( Estrategia_De_Vuelo nueva_estrategia ){
		if ( this.Vivo ) estrategia_vuelo = nueva_estrategia;
		// if false ChauBlindaje signal
	}

	public void direccion( Point direccion_parametro ){
		
	}
	
	public String getBando(){
		return bando;
	}
	
	public void moverse(){
		if ( this.Vivo ) this.estrategia_vuelo.CalcularMovimiento( this );
	}
	
	public void moverseIAsegunVel(){
		if ( this.Vivo ) {
			for ( int i = 0 ; i == Velocidad ; i++ ) this.moverse();
		}
		// else ChauBlindaje signal
	}
	
	public void setBando( String bando_parametro ){
		bando = bando_parametro;
	}
	
	public void setBlindaje( int cantidad ){
		blindaje = Blindaje.de( cantidad ); 
	}
	
	public void setPosicion( Ubicacion ubicacion_parametro ){
		ubicacion = ubicacion_parametro;
	}
	
	public void arriba(){
		Point pt= new Point(0,1);
		this.direccion(pt);
	}
	
	public void abajo(){
		Point pt=new Point(0,-1);
		this.direccion(pt);
	}
	
	public void derecha(){
		Point pt = new Point(1,0);
		this.direccion(pt);
	}
	
	public void izquierda(){
		Point pt= new Point(-1,0);
		this.direccion(pt);
	}
	
	
}
