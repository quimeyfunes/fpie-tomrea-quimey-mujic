package EstrategiasDeMov;

import Objetos_moviles.ObjetosMoviles;

public class LineaRectaDown extends EstrategiaDeVuelo {

	@Override
	public void CalcularMovimiento(ObjetosMoviles objeto) {
		objeto.abajo();
	}

}
