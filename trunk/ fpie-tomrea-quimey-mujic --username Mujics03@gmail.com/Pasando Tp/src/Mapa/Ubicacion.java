package Mapa;
import java.awt.Point;

public class Ubicacion {
	
	Point Punto ;
	static int LimiteX=10000;
	static int LimiteY=10000;
	
	//Metodo para uso privado.Verifica si se fue del rango, y si es asi, lanza excepcion.	
	private void ComprobarOffLimits(Point punto){
		double X = punto.getX();
		double Y = punto.getY();
		
		if( (X<0) || (Y<0) || (X>LimiteX)||(Y>LimiteY) ) { 
			//TODO: lanzar excepcion OFFLimits
		}
		
	}
	
	//Constructor privado.Verifica que el punto este siendo creado dentro de los límites.Si falla, lanza OFFlimits.	
	private Ubicacion(Point punto){
		
		this.ComprobarOffLimits(punto);
		this.Punto=punto;
		
		}

	//Constructor publico.Devuelve una Ubicacion
	public static Ubicacion crearUbicacionEnXY(int X,int Y){
		Point punto = new Point(X,Y);
		return ( (new Ubicacion(punto) ));
	}
	
	//Me parece que aca habria que implementar una especie de singleton, cosa de poder tener distintos escenarios
	// con distintos tamanios. Por ahora lo dejo asi.
	public static int getLimiteX(){ return LimiteX; }
	public static int getLimiteY(){ return LimiteY; }
	public static void SetLimiteXY(int x,int y){
		LimiteX=x;
		LimiteY=y;
	}
	
	public boolean EstaCercaAlAlimiteDerecho(){
		
	}
	public boolean EstaCercaAlAlimiteInferior(){
		
	}
	
	public boolean EstaCercaAlAlimiteIzquierdo(){
		
	}
	
	public boolean EstaCercaAlAlimiteSuperior(){
		
	}
	
	//Devuelvo una copia, no violo encapsulamiento
	public Point XY(){
		return( (Point) ( (this.Punto).clone() ) );
	}
	
	//Devuelven la distancia a los respectivos limites, desde la posicion actual.	
	private double distanciaAlimiteDerecho(){
		return ( (this.Punto).distance( Ubicacion.getLimiteX() , Punto.y) ) ;
	}
	
	private double distanciaAlimiteInferior(){
		return ( (this.Punto).distance( Punto.x , 0) ) ;
	}
	
	private double distanciaAlimiteIzquierdo(){
		return ( (this.Punto).distance( 0 , Punto.y) ) ;
	}
	
	private double distanciaAlimiteSuperior(){
		return ( (this.Punto).distance( Punto.x , Ubicacion.getLimiteY()) ) ;
	}
	
	//Translada si no queda en posicion invalida.Sino, lanza OFFlimits.
	public void translateBy(Point punto){
		
		this.Punto.translate(punto.x, punto.y);
		this.ComprobarOffLimits(this.Punto);
		
	}
	
	
	
	}
