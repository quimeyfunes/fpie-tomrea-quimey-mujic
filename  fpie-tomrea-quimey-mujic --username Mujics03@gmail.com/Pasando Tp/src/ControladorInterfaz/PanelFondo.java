package ControladorInterfaz;

import java.awt.*;

import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;

public class PanelFondo extends Frame implements SuperficieDeDibujo{
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Image imagenFondo;

  public PanelFondo(String hola){
  super(hola);
  imagenFondo = Toolkit.getDefaultToolkit().getImage("fondomenu.jpg");
  MediaTracker mt = new MediaTracker(this);
  mt.addImage(imagenFondo,0);
  try {
	mt.waitForID(0);
} catch (InterruptedException e) {
	e.printStackTrace();
}
  }
  
  public void paint(Graphics g){
  if(imagenFondo != null)
  g.drawImage(imagenFondo, 100, 100, this);
  else
  g.clearRect(0, 0, getSize().width, getSize().height);
  }

@Override
public void limpiar() {
	if(this.imagenFondo == null)
		this.imagenFondo = this.createImage(getSize().width, getSize().height);
	Graphics superficieParaDibujar =  this.imagenFondo.getGraphics();
	superficieParaDibujar.setColor(Color.WHITE);// 
	superficieParaDibujar.fillRect(0, 0, this.getSize().width, this.getSize().height);		
}


@Override
public void actualizar() {
		this.repaint();
}

@Override
public Object getBuffer() {
		return this.imagenFondo.getGraphics();
		}
}
