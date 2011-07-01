package ManejoXml;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class ParserNivelesXml
{
	private byte nivelActual;
	private File archivoActual;
	private Document documentoActual;
	private boolean ultimoNivel;

	public ParserNivelesXml()
	{
		this.setNivelYArchivo((byte) 1);
	}

	public ParserNivelesXml(byte nivelInicial)
	{
		this.setNivelYArchivo(nivelInicial);
	}
	
	public boolean getUltimoNivel()
	{
		return this.ultimoNivel;
	}

	private void setNivelYArchivo(byte nivel)
	{
		this.ultimoNivel = false;
		this.nivelActual = nivel;
		String currentPath = System.getProperty("user.dir") + "/src/ManejoXml/";
		this.archivoActual = new File(currentPath + "Nivel" + nivel + ".xml");
		if (!archivoActual.exists())
		{
			this.archivoActual = new File(currentPath + "NivelFinal.xml");
			this.ultimoNivel = true;
		}

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

	private short getCantAviones(String name)
	{
		List<Node> nodes = this.documentoActual.selectNodes("//cantidades/cantidad");
		for (Node node : nodes)
		{
			String tipoAvion = node.valueOf("@name");
			if (tipoAvion.startsWith(name))
			{
				return (short) Integer.parseInt(node.valueOf("@value"));
			}
		}
		return 0;
	}

	public short getCantCazas()
	{
		return this.getCantAviones("cazas");
	}

	public short getCantBombarderos()
	{
		return this.getCantAviones("bombarderos");
	}

	public short getCantExploradores()
	{
		return this.getCantAviones("exploradores");
	}

	public short getCantAvionetas()
	{
		return this.getCantAviones("avionetas");
	}

	public short getCantHelicopteros()
	{
		return this.getCantAviones("helicoptero");
	}

	public short getCantAvionCivil()
	{
		return this.getCantAviones("avioncivil");
	}

	public short getVidaGuia()
	{
		return this.getCantAviones("vidaguia");
	}

}
