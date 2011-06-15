package Pruebas;

import org.junit.Assert;
import org.junit.Test;
import ManejoXml.ParserNivelesXml;

public class XmlTest
{

	private ParserNivelesXml parser;


	@Test
	public void testXml()
	{
		parser = new ParserNivelesXml();
		Assert.assertTrue( parser.getCantCazas() == 4);
		Assert.assertTrue( parser.getCantExploradores() == 6);
		Assert.assertTrue( parser.getCantAvionetas() == 4);
		Assert.assertTrue( parser.getCantBombarderos() == 3);
		
		parser.pasarNivel();
		Assert.assertTrue( parser.getCantCazas() == 5);
		Assert.assertTrue( parser.getCantExploradores() == 6);
		Assert.assertTrue( parser.getCantAvionetas() == 5);
		Assert.assertTrue( parser.getCantBombarderos() == 4);
		
		parser.pasarNivel();
		Assert.assertTrue( parser.getCantCazas() == 6);
		Assert.assertTrue( parser.getCantExploradores() == 7);
		Assert.assertTrue( parser.getCantAvionetas() == 7);
		Assert.assertTrue( parser.getCantBombarderos() == 5);
		
	}
}
