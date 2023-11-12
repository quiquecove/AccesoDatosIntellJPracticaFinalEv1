package XML;

import java.io.IOException;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class SAXimplementation extends DefaultHandler {
          
            	public void startDocument() throws SAXException {
            		super.startDocument();
            		System.out.println("Inicio del documento XML");
            	}

            	public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
            		super.startElement(uri, localName, qName, attributes);
            		System.out.println("<" + localName + ">");
            	}

            	public void characters(char[] ch, int start, int lenght) throws SAXException {
            		super.characters(ch, start, lenght);
            		String texto = new String(ch, start, lenght);
            		texto = texto.replace("\n", "").trim();
            		if (texto.length() > 0) {
            			System.out.println("\t" + texto);
            		}
            	}

            	public void EndElement(String uri, String localname, String qName) throws SAXException {
            		super.endElement(uri, localname, qName);
            		System.out.println("<" + localname + ">");
            	}

            	public void EndDocument() throws SAXException {
            		super.endDocument();
            		System.out.println("fin del documento");
            	}
            	
            
            
	}
             
           
