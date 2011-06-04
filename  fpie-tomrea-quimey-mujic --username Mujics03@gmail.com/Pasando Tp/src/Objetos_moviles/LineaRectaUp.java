package Objetos_moviles;

public class LineaRectaUp extends EstrategiaDeVuelo{

	@Override
	public void CalcularMovimiento(ObjetosMoviles objeto) {
		objeto.arriba();
	}
	

}
