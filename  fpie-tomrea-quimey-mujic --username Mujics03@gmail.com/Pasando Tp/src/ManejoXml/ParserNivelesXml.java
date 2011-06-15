package ManejoXml;

import java.io.File;
import java.util.List;

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

		this.documentoActual = this.getDocument();
	}

	public Document getDocument()
	{
		Document document = null;
		SAXReader reader = new SAXReader();
		try
		{
			document = reader.read(this.archivoActual);
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
	
	private byte getCantAviones(String name)
	{
		List<Node> nodes = this.documentoActual.selectNodes("//cantidades/cantidad");
		for (Node node : nodes)
		{
			String tipoAvion = node.valueOf("@name");
			if (tipoAvion.startsWith(name) )
			{
				return (byte) Integer.parseInt(node.valueOf("@value"));
			}
		}
		return 0;
	}

	public byte getCantCazas()
	{
		return this.getCantAviones("cazas");
	}
	
	public byte getCantBombarderos()
	{
		return this.getCantAviones("bombarderos");
	}
	
	public byte getCantExploradores()
	{
		return this.getCantAviones("exploradores");
	}
	
	public byte getCantAvionetas()
	{
		return this.getCantAviones("avionetas");
	}
	
	public byte getCantHelicopteros()
	{
		return this.getCantAviones("helicoptero");
	}
	
	public byte getCantAvionCivil()
	{
		return this.getCantAviones("avioncivil");
	}

}
