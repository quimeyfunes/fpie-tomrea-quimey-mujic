package ManejoXml;

import java.io.File;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.dom4j.Node;

public class ParserNivelesXml
{
	private byte nivelActual;
	private File archivoActual;
	private Document documentoActual;

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
		String currentPath = System.getProperty("user.dir") + "/src/ManejoXml/";
		this.archivoActual = new File(currentPath + "Nivel" + nivel + ".xml");
		if (!archivoActual.exists())
			this.archivoActual = new File(currentPath + "NivelFinal.xml");

		this.documentoActual = this.getDocument(archivoActual.getPath());
	}

	public Document getDocument(String xmlFileName)
	{
		Document document = null;
		SAXReader reader = new SAXReader();
		try
		{
			document = reader.read(xmlFileName);
		}
		catch (DocumentException e)
		{
			e.printStackTrace();
		}
		return document;
	}

	public void pasarNivel()
	{
		this.nivelActual++;
		this.setNivelYArchivo(this.nivelActual);
	}

	public File getFile()
	{
		return this.archivoActual;
	}

}
