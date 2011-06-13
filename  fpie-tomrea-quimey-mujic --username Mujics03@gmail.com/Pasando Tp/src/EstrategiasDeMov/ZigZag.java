package EstrategiasDeMov;

import Mapa.Vector2D;
import Objetos_moviles.ObjetosMoviles;

public class ZigZag extends EstrategiaDeVuelo{
	
	Vector2D dirAsc = new Vector2D(-1,-1);

	@Override
	public void CalcularMovimiento(ObjetosMoviles objeto) {
		if (this.Parametro <= EstrategiaDeVuelo.getSlide()){
			objeto.direccion( new Vector2D(-1,-1));
				if (objeto.EstaCercaAlAlimiteIzquierdo()){this.Parametro=EstrategiaDeVuelo.getSlide()+1;}
		}
		else{
			objeto.direccion( new Vector2D(1,-1));
			if ( objeto.EstaCercaAlAlimiteDerecho() ){this.restartearParametro();}
		}
		Parametro=Parametro+1;
		if (Parametro> EstrategiaDeVuelo.getSlide()*2 ){ this.restartearParametro();}
		
	}

}
