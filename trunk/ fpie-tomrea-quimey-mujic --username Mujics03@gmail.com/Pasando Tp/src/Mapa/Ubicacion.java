package Mapa;

import Escenario.Escenario;
import EstrategiasDeMov.EstrategiaDeVuelo;
import Excepciones.OffLimitsException;

public class Ubicacion {
	
	Vector2D Punto ;
	private static double LimiteX= Escenario.getLimiteX();
	private static double LimiteY= Escenario.getLimiteX();
	
	//Metodo para uso privado.Verifica si se fue del rango, y si es asi, lanza excepcion.	
	private void ComprobarOffLimits(Vector2D punto) throws OffLimitsException{
		double X = punto.getX();
		double Y = punto.getY();
		
		if( (X<0) || (Y<0) || (X>LimiteX)||(Y>LimiteY) ) { 
			throw( new OffLimitsException());
		}
		
	}
	
	//Constructor privado.Verifica que el punto este siendo creado dentro de los límites.Si falla, lanza OFFlimits.	
	private Ubicacion(Vector2D punto) throws OffLimitsException{
		
		this.ComprobarOffLimits(punto);
		this.Punto=punto;
		
		}

	//Constructor publico.Devuelve una Ubicacion
	public static Ubicacion crearUbicacionEnXY(double X,double Y) throws OffLimitsException{
		Vector2D punto = new Vector2D(X,Y);
		return ( (new Ubicacion(punto) ));
	}
	
	//Cercania a los limites.
	
	public boolean EstaCercaAlAlimiteDerecho(){
		return  (this.distanciaAlimiteDerecho()) <= (EstrategiaDeVuelo.getMinimoMovimiento()*5);	
		}

	public boolean EstaCercaAlAlimiteInferior(){
		return  (this.distanciaAlimiteInferior()) <= (EstrategiaDeVuelo.getMinimoMovimiento()*5);
		
	}
	
	public boolean EstaCercaAlAlimiteIzquierdo(){
		return  (this.distanciaAlimiteIzquierdo()) <= (EstrategiaDeVuelo.getMinimoMovimiento()*5);	
	}
	
	public boolean EstaCercaAlAlimiteSuperior(){
		return  (this.distanciaAlimiteSuperior()) <= (EstrategiaDeVuelo.getMinimoMovimiento()*5);
	}
	
	//Devuelvo una copia, no violo encapsulamiento
	public Vector2D XY(){
		return( (Vector2D) ( (this.Punto).clone() ) );
	}
	
	//Devuelven la distancia a los respectivos limites, desde la posicion actual.	
	private double distanciaAlimiteDerecho(){
		return ( (this.Punto).distance( LimiteX , Punto.y) ) ;
	}
	
	private double distanciaAlimiteInferior(){
		return ( (this.Punto).distance( Punto.x , 0) ) ;
	}
	
	private double distanciaAlimiteIzquierdo(){
		return ( (this.Punto).distance( 0 , Punto.y) ) ;
	}
	
	private double distanciaAlimiteSuperior(){
		return ( (this.Punto).distance( Punto.x , LimiteY) ) ;
	}
	
	//Translada si no queda en posicion invalida.Sino, lanza OFFlimits.
	public void translateBy(Vector2D punto) throws OffLimitsException{
		
		this.Punto.translate(punto.x, punto.y);
		this.ComprobarOffLimits(this.Punto);
		
	}
	
	
	
	}
