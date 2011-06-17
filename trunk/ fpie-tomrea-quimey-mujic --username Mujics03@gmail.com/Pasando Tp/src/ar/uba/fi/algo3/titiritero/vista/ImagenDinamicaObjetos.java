package ar.uba.fi.algo3.titiritero.vista;
import java.awt.Graphics;

import ar.uba.fi.algo3.titiritero.DibujableExtra;
import ar.uba.fi.algo3.titiritero.Monitoreable;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;

public class ImagenDinamicaObjetos extends Imagen implements DibujableExtra{
	
    private Monitoreable mon;
	
		
		public ImagenDinamicaObjetos(){		
		}

		public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
			Graphics grafico = (Graphics)superficeDeDibujo.getBuffer();
			boolean EstaVivo = this.mon.EstaVivo();
			if( EstaVivo ){
				grafico.drawImage(this.imagen, this.mon.getX(), this.mon.getY(), null);
			} else 
				this.imagen=null;
				grafico.drawImage(this.imagen, this.mon.getX(), this.mon.getY(), null);
			}
		
		public Monitoreable getMonitoreable(){
			return this.mon;
		}
		
		public void setMonitoreable(Monitoreable objMon){
			this.mon=objMon;
		}
		
			
		




}


