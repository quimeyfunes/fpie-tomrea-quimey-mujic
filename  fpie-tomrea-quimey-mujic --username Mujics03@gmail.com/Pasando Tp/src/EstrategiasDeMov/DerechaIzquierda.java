package EstrategiasDeMov;

import Objetos_moviles.ObjetosMoviles;

public class DerechaIzquierda extends EstrategiaDeVuelo
{

	public void CalcularMovimiento(ObjetosMoviles objeto){
		
		if (objeto.EstaCercaAlAlimiteDerecho()){Parametro=0;}
		if (objeto.EstaCercaAlAlimiteIzquierdo()){Parametro=1;}
		
		if(Parametro==0)
			objeto.izquierda();
		else
			objeto.derecha();
		
	}
	
	public DerechaIzquierda(){
		this.restartearParametro();
	}

}
