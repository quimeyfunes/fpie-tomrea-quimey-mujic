package EstrategiasDeMov;

import Escenario.Escenario;
import Objetos_moviles.ObjetosMoviles;

public abstract class EstrategiaDeVuelo{
	
	//movimiento lateral igual a 1/10 del tamanio del escenario
	private static double slide= ( Escenario.getLimiteX()/10);
	private static double MinimoMovimiento = 1;
	
	public double Parametro;
	
	public static double getMinimoMovimiento(){
		return MinimoMovimiento;
	}
	public static double getSlide(){
		return slide;
	}
	public void restartearParametro(){
		this.Parametro=0;
	}
	
	public abstract void CalcularMovimiento(ObjetosMoviles objeto);

}
