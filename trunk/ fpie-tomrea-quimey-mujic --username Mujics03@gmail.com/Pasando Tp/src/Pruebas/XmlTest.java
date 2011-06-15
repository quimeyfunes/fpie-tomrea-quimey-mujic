package Pruebas;

import org.junit.Assert;
import org.junit.Test;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import ManejoXml.ParserNivelesXml;

public class XmlTest
{

	private ParserNivelesXml parser;


	@Test
	public void testBlindaje()
	{
		parser = new ParserNivelesXml();
		Assert.assertTrue(parser.getFile().exists());
		parser.getDocument(parser.getFile().getPath());
	}
}
