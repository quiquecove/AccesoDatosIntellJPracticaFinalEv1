package ActividadFinalEv1;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class DOMCreacion {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // Crear un nuevo documento XML
            Document doc = docBuilder.newDocument();

            // Crear el elemento raíz
            Element rootElement = doc.createElement("lista_paises");
            doc.appendChild(rootElement);

            // Arrays con información de los países
            String[] nombres = {"Argentina","Belice", "El Salvador", "Guatemala","Honduras","México","Panamá","Costa Rica"};
            String[] presidentes = {"Milei", "Froyla Tzalam", "Nayib Bukele","Alejandro Giammattei","Xiomara Castro","Daniel Ortega","Andres Manuel Lopez Obrador","Laurentino Cortizo","Rodrigo Chaves"};
            int[] pibValues = {149259, 1987, 74818,185473,85625,47770,2890685,128500,129950};
            double[] giniValues = {0, 53.3, 38.8,48.3,48.2,46.2,45.4,50.9,47.2};
            String[] region={"Sur America","Centro América","Centro América","Centro América","Centro América","Centro América","Centro América","Centro América","Centro América"};

            // Crear una instancia de ListaPaises
            ListaPaises listaPaises = new ListaPaises();

            // Añadir países al documento usando un bucle
            for (int i = 0; i < nombres.length; i++) {
                // Crear un objeto PaisSerializable
                PaisSerializable pais = new PaisSerializable(region[i], nombres[i], presidentes[i], String.valueOf(pibValues[i]), String.valueOf(giniValues[i]));

                // Agregar el país a la lista
                listaPaises.addPais(pais);

                // Crear elementos XML y agregarlos al documento
                Element paisElement = doc.createElement("pais");
                paisElement.setAttribute("region", region[i]);

                Element nombre = doc.createElement("nombre_pais");
                nombre.appendChild(doc.createTextNode(nombres[i]));
                paisElement.appendChild(nombre);

                Element presidente = doc.createElement("presidente");
                presidente.appendChild(doc.createTextNode(presidentes[i]));
                paisElement.appendChild(presidente);

                Element pib = doc.createElement("pib");
                pib.appendChild(doc.createTextNode(String.valueOf(pibValues[i])));
                paisElement.appendChild(pib);

                Element gini = doc.createElement("gini");
                gini.appendChild(doc.createTextNode(String.valueOf(giniValues[i])));
                paisElement.appendChild(gini);

                rootElement.appendChild(paisElement);
            }

            // Guardar el contenido del documento en un archivo XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult("Paises.xml");

            // Escribir el contenido en el archivo XML
            transformer.transform(source, result);

            System.out.println("Archivo XML creado con éxito.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
