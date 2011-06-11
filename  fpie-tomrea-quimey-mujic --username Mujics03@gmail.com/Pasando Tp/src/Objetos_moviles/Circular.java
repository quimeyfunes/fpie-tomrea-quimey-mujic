package Objetos_moviles;

import Mapa.Vector2D;
import java.lang.Math;



public class Circular extends EstrategiaDeVuelo {
	
	private Vector2D VectorQueGira;
	private double MinimoAnguloCircular;

	@Override
	public void CalcularMovimiento(ObjetosMoviles objeto) {
		boolean LimR;
		boolean LimL;
		boolean SafarDeLimiteIzquierdo;
		boolean SafarDeLimiteDerecho;
		
		LimR = objeto.EstaCercaAlAlimiteDerecho();
		LimL = objeto.EstaCercaAlAlimiteIzquierdo();
		
		SafarDeLimiteIzquierdo = (this.VectorQueGira.y>0)&& (this.VectorQueGira.x>0);
		SafarDeLimiteDerecho = (this.VectorQueGira.y<0) && (this.VectorQueGira.x<0);
		
		if ( (LimR) && (SafarDeLimiteIzquierdo==false) ){
			objeto.abajo();
		}
		
		if ( (LimL) && (SafarDeLimiteDerecho==false)){
			objeto.arriba();
		}
		
		if ( (LimR=false) && (LimL=false)){
			objeto.direccion(this.VectorQueGira);
		}
		
		this.HacerGirarVector();

	}

	private void HacerGirarVector() {
		
		//http://www.velocityreviews.com/forums/t150749-rotate-around-non-origin-pivot-point.html
			
			double xtemp;
			double a= this.MinimoAnguloCircular;
			double x= this.VectorQueGira.x;
			double y= this.VectorQueGira.y;
			
			xtemp = (x * (float)Math.cos(a)) - (y * (float)Math.sin(a));
			y = (x * (float)Math.sin(a)) + (y * (float)Math.cos(a));
			x = xtemp;
			
			this.VectorQueGira.setLocation(x, y);
		
	}

	public static double radioStandarSegunDistancia(Vector2D posicion) {
		return ((( posicion.y)/2.0)-50);
	}
	
	public static double radioStandarSegunDistancia( double x,double y){
		return (radioStandarSegunDistancia( new Vector2D(x,y)));
	}

	public Circular(double radio){
		this.MinimoAnguloCircular = Math.atan(EstrategiaDeVuelo.getMinimoMovimiento()/radio);
		this.VectorQueGira = new Vector2D(1,0);
	}
	
}
