package XML;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class xml1 {

	public static void main(String[] args) throws Exception {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		DocumentBuilder builder = factory.newDocumentBuilder();

		DOMImplementation implementation = builder.getDOMImplementation();

		Document document = implementation.createDocument(null, "PersonasSeries", null);

		document.setXmlVersion("1.0");

		Element persona1 = document.createElement("Persona");

		document.getDocumentElement().appendChild(persona1);

		Element nombre = document.createElement("nombre");
		nombre.setTextContent("Quique");
		persona1.appendChild(nombre);

		Element serieFav = document.createElement("serie_favorita");
		serieFav.setTextContent("Bojack Horseman");
		persona1.appendChild(serieFav);
		////////////////////////////////////////////////////////////
		Element persona2 = document.createElement("Persona");

		document.getDocumentElement().appendChild(persona2);

		Element nombre2 = document.createElement("nombre");
		nombre2.setTextContent("Fernando");
		persona2.appendChild(nombre2);

		Element serieFav2 = document.createElement("serie_favorita");
		serieFav2.setTextContent("Bob Esponja");
		persona2.appendChild(serieFav2);
		/////////////////////////////////////////////////////
		Element persona3 = document.createElement("Persona");

		document.getDocumentElement().appendChild(persona3);

		Element nombre3 = document.createElement("nombre");
		nombre3.setTextContent("Edu");
		persona3.appendChild(nombre3);

		Element serieFav3 = document.createElement("serie_favorita");
		serieFav3.setTextContent("Dora la Exploradora");
		persona3.appendChild(serieFav3);
		////////////////////////////////////////////////////////
		Element persona4 = document.createElement("Persona");

		document.getDocumentElement().appendChild(persona4);

		Element nombre4 = document.createElement("nombre");
		nombre4.setTextContent("Dani M");
		persona4.appendChild(nombre4);

		Element serieFav4 = document.createElement("serie_favorita");
		serieFav4.setTextContent("Pocoyo");
		persona4.appendChild(serieFav4);
		/////////////////////////////
		Element persona5 = document.createElement("Persona");

		document.getDocumentElement().appendChild(persona5);

		Element nombre5 = document.createElement("nombre");
		nombre5.setTextContent("Dichao");
		persona5.appendChild(nombre5);

		Element serieFav5 = document.createElement("serie_favorita");
		serieFav5.setTextContent("Mister Robot");
		persona5.appendChild(serieFav5);
		////////////////////////////////////////////////
		Element persona6 = document.createElement("Persona");

		document.getDocumentElement().appendChild(persona6);

		Element nombre6 = document.createElement("nombre");
		nombre6.setTextContent("Angel");
		persona6.appendChild(nombre6);

		Element serieFav6 = document.createElement("serie_favorita");
		serieFav6.setTextContent("Sense8");
		persona6.appendChild(serieFav6);
		
		//////////////////////////
//		 Element personasSeries = document.createElement("PersonasSeries");
//         document.appendChild(personasSeries);

//         // Arreglos de nombres y series
//         String[] nombres = {"Willy", "Dani Guevara", "Mario", "Noah", "Dani Calvo", "Emilio"};
//         String[] series = {"Naruto", "Naruto", "La que avecina", "skins", "Top Boy", "Sense8"};
//
//         // Crear personas y agregar nombres y series favoritas
//         for (int i = 0; i < nombres.length; i++) {
//             Element persona = document.createElement("persona");
//             personasSeries.appendChild(persona);
//
//             Element nombre = document.createElement("nombre");
//             Text text = document.createTextNode(nombres[i]);
//             nombre.appendChild(text);
//             persona.appendChild(nombre);
//
//             Element serieFav = document.createElement("serie_favorita");
//             Text text2 = document.createTextNode(series[i]);
//             serieFav.appendChild(text2);
//             persona.appendChild(serieFav);
//         }
//		//////////////////////

		Source source = new DOMSource(document);

		StreamResult result = new StreamResult(new File("DomTest.xml"));

		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty(OutputKeys.METHOD, "xml");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
		transformer.transform(source, result);

		Result console = new StreamResult(System.out);
		transformer.transform(source, console);

	}
}
