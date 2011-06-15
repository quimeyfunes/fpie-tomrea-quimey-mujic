package ManejoXml;

import java.io.File;

public class ParserNivelesXml
{
	private byte nivelActual;
	private File archivoActual;
	
	public ParserNivelesXml()
	{
		this.setNivelYArchivo((byte) 1);
	}
	
	public ParserNivelesXml(byte nivelInicial)
	{
		this.setNivelYArchivo(nivelInicial);
	}
	
	private void setNivelYArchivo(byte nivel)
	{
		this.nivelActual = nivel;	
		this.archivoActual = new File("Nivel");
		if(archivoActual == null)
			this.archivoActual = new File("NivelFinal.xml");
	}
	
	public void pasarNivel()
	{
		this.nivelActual++;
		
	}

}
