package Vistas;

import java.awt.Color;
import java.awt.Graphics;

import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.ObjetoDeTexto;
import ar.uba.fi.algo3.titiritero.vista.TextoDinamico;


public class VistaPuntos extends TextoDinamico {
	
	public VistaPuntos(ObjetoDeTexto esc) {
		super(esc);
		this.setColor(Color.BLACK);
		this.setFuente(esc.getTexto(), 25);
	}
	
	public void dibujar(SuperficieDeDibujo superfice) {
		Graphics grafico = (Graphics)superfice.getBuffer();
		grafico.setColor(this.getColor());
		grafico.setFont(this.fuente);
		grafico.drawString(getTexto(), 20, 25);
	}

	

}
