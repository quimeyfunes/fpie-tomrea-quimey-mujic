package Objetos_Moviles;

import Mapa.Ubicacion;

public abstract class Estrategia_De_Vuelo{
	
	//movimiento lateral igual a 1/10 del tamanio del escenario
	private static double slide= (Ubicacion.getLimiteX()/10);
	private static double MinimoMovimiento = 1;
	
	public double Parametro=0;
	
	public static double getMinimoMovimiento(){
		return MinimoMovimiento;
	}
	public static double getSlide(){
		return slide;
	}
	public void restartearParametro(){
		this.Parametro=0;
	}
	
	public abstract void CalcularMovimiento(Objetos_moviles objeto);

}
