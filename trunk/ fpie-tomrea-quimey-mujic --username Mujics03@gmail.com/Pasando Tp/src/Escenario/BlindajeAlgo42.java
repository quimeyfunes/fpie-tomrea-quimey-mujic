package Escenario;

import Objetos_moviles.Algo42;
import ar.uba.fi.algo3.titiritero.Monitoreable;
import ar.uba.fi.algo3.titiritero.Posicionable;



public class BlindajeAlgo42 implements Posicionable, Monitoreable{

	
	private Algo42 referenciaAlgo42;
	
	public BlindajeAlgo42(Algo42 algo){
		this.referenciaAlgo42 = algo;
	}
	
	@Override
	public int getX() {

		return 20;
	}

	@Override
	public int getY() {
		return 400;
	}

	public void setReferenciaAlgo42(Algo42 referenciaAlgo42) {
		this.referenciaAlgo42 = referenciaAlgo42;
	}

	public Algo42 getReferenciaAlgo42() {
		return referenciaAlgo42;
	}

	@Override
	public short getBlindajeReferencia() {
		return referenciaAlgo42.getVida();
	}

	@Override
	public boolean EstaVivo() {
		return true;
	}
	
}