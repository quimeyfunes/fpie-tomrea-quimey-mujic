package EstrategiasDeMov;

import Objetos_moviles.ObjetosMoviles;

public class LineaRectaUp extends EstrategiaDeVuelo{

	@Override
	public void CalcularMovimiento(ObjetosMoviles objeto) {
		objeto.arriba();
	}
	

}
