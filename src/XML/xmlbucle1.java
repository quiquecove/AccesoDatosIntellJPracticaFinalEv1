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

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class xmlbucle1 {
    public static void main(String[] args) throws Exception {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        Element personasSeries = document.createElement("PersonasSeries");
        document.appendChild(personasSeries);

        // Arreglos de nombres y series
        String[] nombres = { "Quique", "Fer", "Angel", "Edu", "Dichao", "Dany M" };
        String[] series = { "Bojack", "Bob Esponja", "Sense8", "Dora la Explorer", "Mister Robot", "Pocoyo" };

        // Crear personas y agregar nombres y series favoritas
        for (int i = 0; i < nombres.length; i++) {
            Element persona = document.createElement("persona");
            personasSeries.appendChild(persona);

            Element nombre = document.createElement("nombre");
            Text text = document.createTextNode(nombres[i]);
            nombre.appendChild(text);
            persona.appendChild(nombre);

            Element serieFav = document.createElement("serie_favorita");
            Text text2 = document.createTextNode(series[i]);
            serieFav.appendChild(text2);
            persona.appendChild(serieFav);
        }

        Source source = new DOMSource(document);

        StreamResult result = new StreamResult(new File("PersonaSerie.xml"));

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        transformer.transform(source, result);

        Result console = new StreamResult(System.out);
        transformer.transform(source, console);
    }
}
