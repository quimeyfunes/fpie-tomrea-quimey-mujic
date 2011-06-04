package Objetos_moviles;


public class IdaYvuelta extends Estrategia_De_Vuelo{
	
	public void CalcularMovimiento(Objetos_moviles objeto){
		
		if (objeto.EstaCercaAlAlimiteSuperior()){Parametro=0;}
		if (objeto.EstaCercaAlAlimiteInferior()){Parametro=1;}
		
		if(Parametro==0){ objeto.abajo;}else{objeto.arriba;}
		
	}

}
