package ControladorInterfaz;

import java.awt.*;

public class PanelFondo extends Frame{
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Image img;

  public PanelFondo(String hola){
  super(hola);
  MediaTracker mt = new MediaTracker(this);
  img = Toolkit.getDefaultToolkit().getImage("fondojuego.jpg");
  mt.addImage(img,0);
  setSize(400,400);
  setVisible(true);
  }
  
  public void paint(Graphics g){
  if(img != null)
  g.drawImage(img, 100, 100, this);
  else
  g.clearRect(0, 0, getSize().width, getSize().height);
  }
}
