package Objetos_moviles;

public class LineaRectaDown extends EstrategiaDeVuelo {

	@Override
	public void CalcularMovimiento(ObjetosMoviles objeto) {
		objeto.abajo();
	}

}
