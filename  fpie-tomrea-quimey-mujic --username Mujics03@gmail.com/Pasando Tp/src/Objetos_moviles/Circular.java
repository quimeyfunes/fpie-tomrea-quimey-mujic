package Objetos_moviles;

import Mapa.Vector2D;


public class Circular extends EstrategiaDeVuelo {
	
	private Vector2D VectorQueGira;

	@Override
	public void CalcularMovimiento(ObjetosMoviles objeto) {
		boolean LimR;
		boolean LimL;
		double SafarDeLimiteIzquierdo;
		double SafarDeLimiteDerecho;
		
		LimR = objeto.EstaCercaAlAlimiteDerecho();
		LimL = objeto.EstaCercaAlAlimiteIzquierdo();
		
		SafarDeLimiteIzquierdo = this.VectorQueGira
		SafarDeLimiteDerecho =

	}

	public static double radioStandarSegunDistancia(Vector2D posicion) {
		
		return ((( posicion.y)/2.0)-50);
	}

	public Circular(double radio){
		
		
	}
	
}
