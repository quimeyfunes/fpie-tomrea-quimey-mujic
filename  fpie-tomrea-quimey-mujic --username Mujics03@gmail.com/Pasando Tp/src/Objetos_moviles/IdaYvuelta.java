package Objetos_moviles;


public class IdaYvuelta extends EstrategiaDeVuelo{
	
	public void CalcularMovimiento(ObjetosMoviles objeto){
		
		if (objeto.EstaCercaAlAlimiteSuperior()){Parametro=0;}
		if (objeto.EstaCercaAlAlimiteInferior()){Parametro=1;}
		
		if(Parametro==0)
		objeto.abajo();
		else
			objeto.arriba();
		
	}
	public IdaYvuelta(){
		this.restartearParametro();
	}
}
