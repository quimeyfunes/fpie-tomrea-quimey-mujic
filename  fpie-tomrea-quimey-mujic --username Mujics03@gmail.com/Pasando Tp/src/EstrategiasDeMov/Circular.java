package EstrategiasDeMov;

import Mapa.Vector2D;
import Objetos_moviles.ObjetosMoviles;

import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.lang.Math;



public class Circular extends EstrategiaDeVuelo {
	
	private Vector2D VectorQueGira;
	private double MinimoAnguloCircular;

	@Override
	public void CalcularMovimiento(ObjetosMoviles objeto) {
		boolean LimR;
		boolean LimL;
		boolean LimS;
		boolean LimI;
		boolean SafarDeLimiteIzquierdo;
		boolean SafarDeLimiteDerecho;
		
		LimR = objeto.EstaCercaAlAlimiteDerecho();
		LimL = objeto.EstaCercaAlAlimiteIzquierdo();
		LimS = objeto.EstaCercaAlAlimiteSuperior();
		LimI = objeto.EstaCercaAlAlimiteInferior();
		
		SafarDeLimiteIzquierdo = (this.VectorQueGira.y>0)&& (this.VectorQueGira.x>0);
		SafarDeLimiteDerecho = (this.VectorQueGira.y<0) && (this.VectorQueGira.x<0);
		
		if ( (LimR) && (!SafarDeLimiteIzquierdo) ){
			objeto.abajo();
			objeto.izquierda();
		}
		
		if ( (LimL) && (!SafarDeLimiteDerecho)){
			objeto.arriba();
			objeto.derecha();
		}
		
		if ( LimS ) {
			objeto.abajo();
		}
		
		if ( LimI ) {
			objeto.arriba();
		}
		
		if ( (!LimR) && (!LimL)){
			objeto.direccion(this.VectorQueGira);
		}
		
		this.HacerGirarVector();

	}

	private void HacerGirarVector() {
		
		//http://www.velocityreviews.com/forums/t150749-rotate-around-non-origin-pivot-point.html
			
		Point2D original = this.VectorQueGira;
		AffineTransform at = AffineTransform.getRotateInstance(this.MinimoAnguloCircular, 0, 0);
		Point2D rotated = at.transform(original, null);
			
			this.VectorQueGira.setLocation(rotated.getX(), rotated.getY());
		
	}

	public static double radioStandarSegunDistancia(Vector2D posicion) {
		return ((( posicion.y)/2.0)-50);//numero magico para evitar borde
	}
	
	public static double radioStandarSegunDistancia( double x,double y){
		return (radioStandarSegunDistancia( new Vector2D(x,y)));
	}

	public Circular(double radio){
		this.MinimoAnguloCircular = (Math.atan(EstrategiaDeVuelo.getMinimoMovimiento()/radio));
		this.SentidoAgujasDelReloj();//default
		this.VectorQueGira = new Vector2D(1,0);
	}
	
	public void SentidoAgujasDelReloj(){
		
		if (this.MinimoAnguloCircular>0){
			this.MinimoAnguloCircular=this.MinimoAnguloCircular*-1;
		}
	}
	public void SentidoContraAgujasDelReloj(){
		if (this.MinimoAnguloCircular<0){
			this.MinimoAnguloCircular=this.MinimoAnguloCircular*-1;
		}
		
	}
	
}
