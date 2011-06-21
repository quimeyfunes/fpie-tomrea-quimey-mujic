package Vistas;
import java.awt.Graphics;

import ar.uba.fi.algo3.titiritero.DibujableExtra;
import ar.uba.fi.algo3.titiritero.Monitoreable;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class ImagenDinamicaObjetos extends Imagen implements DibujableExtra{
	
    private Monitoreable mon;
    private int efecto=0;
    private boolean bandera;
	
		
		public ImagenDinamicaObjetos(){		
		}

		public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
			Graphics grafico = (Graphics)superficeDeDibujo.getBuffer();
			boolean EstaVivo = this.mon.EstaVivo();
			
			if( EstaVivo ){
				grafico.drawImage(this.imagen, this.mon.getX(), this.mon.getY(), null);
			} 
			else {	
				if(efecto<5){
					efecto=efecto+1;
					this.setNombreArchivoImagen("fuego.png");
					grafico.drawImage(this.imagen, this.mon.getX(), this.mon.getY(), null);
					}
				else{
					this.imagen=null;
					this.bandera=true;
					}
			}
		}
		
		
		
		
		public Monitoreable getMonitoreable(){
			return this.mon;
		}
		
		public void setMonitoreable(Monitoreable objMon){
			this.mon=objMon;
		}

		@Override
		public boolean Borrar() {
			return this.bandera;
		}
		
			
		




}


