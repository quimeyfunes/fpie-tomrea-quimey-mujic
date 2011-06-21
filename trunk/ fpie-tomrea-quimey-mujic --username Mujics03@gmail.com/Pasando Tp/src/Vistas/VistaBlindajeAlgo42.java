package Vistas;

import java.awt.Graphics;

import ar.uba.fi.algo3.titiritero.DibujableExtra;
import ar.uba.fi.algo3.titiritero.Monitoreable;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Imagen;
import Excepciones.GameOverException;

public class VistaBlindajeAlgo42 extends Imagen implements DibujableExtra{
	
	private int CoordenadaX=20;
	private int CoordenadaY=400;
	private double VidaIni;
	
	public VistaBlindajeAlgo42(){
		
	}

	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
		Graphics grafico = (Graphics)superficeDeDibujo.getBuffer();
		
		double vida = this.monitoreable.getVida();
		
		double relacion = vida/this.VidaIni;
		
		if(relacion >= 0.95){
			setNombreArchivoImagen("vida.jpg");
			grafico.drawImage(this.imagen, CoordenadaX, CoordenadaY, null);
		}else 
			if(relacion<0.95 && relacion>=0.85){
				setNombreArchivoImagen("vida90.jpg");
				grafico.drawImage(this.imagen, CoordenadaX, CoordenadaY, null);
			}else 
				if(relacion<0.85 && relacion>=0.75){
					setNombreArchivoImagen("vida80.jpg");
					grafico.drawImage(this.imagen, CoordenadaX, CoordenadaY, null);
				}else
					if(relacion<0.75 && relacion>=0.65){
						setNombreArchivoImagen("vida70.jpg");
						grafico.drawImage(this.imagen, CoordenadaX, CoordenadaY, null);
					}else
						if(relacion<0.65 && relacion>=0.55){
							setNombreArchivoImagen("vida60.jpg");
							grafico.drawImage(this.imagen, CoordenadaX, CoordenadaY, null);
						}else
							if(relacion<0.55 && relacion>=0.45){
								setNombreArchivoImagen("vida50.jpg");
								grafico.drawImage(this.imagen, CoordenadaX, CoordenadaY, null);
							}else
								if(relacion<0.45 && relacion>=0.35){
									setNombreArchivoImagen("vida40.jpg");
									grafico.drawImage(this.imagen, CoordenadaX, CoordenadaY, null);
								}else
									if(relacion<0.35 && relacion>0.25){
										setNombreArchivoImagen("vida30.jpg");
										grafico.drawImage(this.imagen, CoordenadaX, CoordenadaY, null);
									}else
										if(relacion<0.25 && relacion>=0.15){
											setNombreArchivoImagen("vida20.jpg");
											grafico.drawImage(this.imagen, CoordenadaX, CoordenadaY, null);
										}else
											if(relacion<0.15 && relacion>0.5){
												setNombreArchivoImagen("vida10.jpg");
												grafico.drawImage(this.imagen, CoordenadaX, CoordenadaY, null);
											}else if(relacion<0.5 && relacion>0){
												setNombreArchivoImagen("vida5.jpg");
												grafico.drawImage(this.imagen, CoordenadaX, CoordenadaY, null);
											}
		
	 if(!(this.monitoreable.EstaVivo()) ){
			throw new GameOverException();
	 }
	}
	    
	
	public void setMonitoreable(Monitoreable monitoreable) {
		this.monitoreable = monitoreable;
		this.VidaIni=monitoreable.getVida();
	}

	public Monitoreable getMonitoreable() {
		return monitoreable;
	}


    private Monitoreable monitoreable;

	@Override
	public boolean Borrar() {
		return false;
	}

}
