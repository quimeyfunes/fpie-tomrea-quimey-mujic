package Objetos_Moviles;
import java.awt.Point;

public class Objetos_moviles {

	boolean Vivo;
	Ubicacion ubicacion;
	int puntos;
	Blindaje blindaje;
	Estrategia_vuelo estrategia_vuelo;
	String bando;
	int Velocidad;
	
	public void Destructor(){
		Vivo = false;
	}
	
	public boolean Cerca_limite_derecho(){
		return ubicacion.Cerca_limite_derecho;
	}
	
	public boolean Cerca_limite_izquierdo(){
		return ubicacion.Cerca_limite_izquierdo;
	}
	
	public boolean Cerca_limite_superior(){
		return ubicacion.Cerca_limite_superior;
	}
	
	public boolean Cerca_limite_inferior(){
		return ubicacion.Cerca_limite_inferior;
	}
	
	public boolean getVivo(){
		return vivo;
	}
	
	public int getPuntos(){
		if ( this.vivo ) return 0; 
		else return puntos;
	}
	
	public void Recibir_danio( int danio ){
		blindaje.Daniar_por( danio );
		// falta On 0 vida morir
	}
	
	public void Cambiar_estrategia_vuelo( Estrategia_vuelo nueva_estrategia ){
		if ( this.vivo ) estrategia_vuelo = nueva_estrategia;
		// if false ChauBlindaje signal
	}

	public void setDireccion( Point direccion_parametro ){
		if ( this.vivo ) direccion = direccion_parametro;
		// else Chaublindaje signal
	}
	
	public String getBando(){
		return bando;
	}
	
	public void Mover(){
		if ( this.vivo ) estrategia_vuelvo.Calcular_movimiento( this );
	}
	
	public void Mover_segun_velocidad(){
		if ( this.vivo ) {
			int i;
			for ( i = 0, i = velocidad , i++ ) this.Mover();
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
	
	
}
