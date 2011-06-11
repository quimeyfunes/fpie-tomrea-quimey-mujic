package Objetos_moviles;

import Armas.Blindaje;
import Armas.Danio;
import EstrategiasDeMov.EstrategiaDeVuelo;
import Excepciones.*;
import Mapa.Ubicacion;
import Mapa.Vector2D;


import java.awt.geom.Rectangle2D;

public abstract class ObjetosMoviles {

	protected boolean Vivo;
	protected Ubicacion ubicacion;
	protected int puntos;
	protected Blindaje blindaje;
	protected EstrategiaDeVuelo estrategia_vuelo;
	protected byte bando;
	protected byte Velocidad;
	protected Rectangle2D.Double Cuerpo;
	
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
	
	//Para que interactue el ESCENARIO
	public boolean EstaVivo(){
		return Vivo;
	}
	
	public int RecolectarPuntos(){
		if ( this.Vivo ) return 0; 
		else return puntos;
	}

	public void moverseIAsegunVel() throws ChauBlindajeException{
		if ( this.EstaVivo() ) {
			for ( int i = 0 ; i < this.Velocidad ; i=i+1 ){
				
				this.moverse();
				
				}
		}
		else{
			throw new ChauBlindajeException();
		}
	}
	
	public void VIVIR(){
		if (this.EstaVivo()){
			this.Actuar();
		}
		else
			throw new ChauBlindajeException();
		
	}
	
	//FIN interactuar con ESCENARIO.
	
	
	//"ENTRE OBJETOS"
	
	public short getVida()
	{
		return this.blindaje.getHitPoints();
	}

	public void analizarDanio( Danio danio ){
		
		try{		
		this.blindaje.daniar( danio );
		}
		catch(ChauBlindajeException ChauE){
			this.Destructor();
			}
		}
	
	public void CambiarEstrategiaDeVuelo( EstrategiaDeVuelo nueva_estrategia ) throws ChauBlindajeException{
		if ( this.EstaVivo() ) estrategia_vuelo = nueva_estrategia;
		else{
			throw new ChauBlindajeException();
		}
	}

	public byte getBando(){
		return this.bando;
	}
	
	public Rectangle2D.Double getCuerpo(){
		return this.Cuerpo;
		
	}

	public Vector2D getPosicion(){
		
		double x1= this.Cuerpo.x+this.Cuerpo.width/2.0;
		double y1= this.Cuerpo.y-this.Cuerpo.height/2.0; 
		Vector2D pos = new Vector2D(x1 ,y1);
		return pos;
			
	}
	
	public abstract boolean PuedeManejarItems();
	
	public abstract boolean PuedeSerAtacado();
	
	//FIN "ENTRE OBJETOS"
	

	//MUY PRIVADO
	
	public void setBando( byte unBando ){
		bando = unBando;
	}
	
	public void setBlindaje( short cantidad ){
		blindaje = new Blindaje( cantidad ); 
	}
	
	public void setPosicion( Ubicacion ubi ){
		ubicacion = ubi;
	}
	
	protected void moverse(){
		if ( this.EstaVivo() ) this.estrategia_vuelo.CalcularMovimiento( this );
	}

	protected boolean smallCondicion(ObjetosMoviles obj){
		return( (this.EstaVivo()) && (obj != this) && (obj.EstaVivo()) && (( obj.getBando()!= this.bando)) );
		
	}

	protected boolean condicionComun(ObjetosMoviles obj){
		return (this.smallCondicion(obj))&& ( obj.getCuerpo()).intersects(this.Cuerpo);
		
	}
	//FIN MUY PRIVADO
	
	//UNIMOV
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

	//Fin UNIMOV
	
	//Interno
	
	protected void ConfigurarCuerpo(double Alto,double Ancho){
		Vector2D p = this.ubicacion.XY();
		this.Cuerpo = new Rectangle2D.Double( (p.x)-(Ancho/2.0),(p.y)+(Alto/2.0),Ancho,Alto);
	}
	
	private void Direccion(Vector2D DirToMove) {
		//"normaliza el movimiento a minimo movimiento"
		DirToMove.normalizeThis();
		DirToMove.scaleThis( EstrategiaDeVuelo.getMinimoMovimiento());
		
		try{
			ubicacion.translateBy(DirToMove);
			
			double TempAncho = this.Cuerpo.width;
			double TempTamanio = this.Cuerpo.height;
			
			Vector2D pos = this.ubicacion.XY();
			
			//una forma de trasladar el rectangulo.
			this.Cuerpo.setRect(pos.x-(TempAncho/2.0),pos.y+(TempTamanio/2.0),TempAncho, TempTamanio);
			this.VerificarColision();
			
		}catch( OffLimitsException OffExc ){
			this.Destructor();
		}
	}

	protected abstract void Actuar();

	protected abstract void ActuarAnteColision(ObjetosMoviles movil);
	
	protected abstract void EstadoCorrecto();
	
	//"itero sobre una copia sin mi"
	//"BALAS ENEMIGAS verifican colision con USER"
	//"BALAS USER verifican colision con FLOTA ENEMIGA"
	//"ITEMS verifican colision con USER"
	//"FLOTA ENEMIGA verifica colision con USER(pero no entre si)"	
	protected abstract void VerificarColision();

	
	//FIN Interno
	
}
