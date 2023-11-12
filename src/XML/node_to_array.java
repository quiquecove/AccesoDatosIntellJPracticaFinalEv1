package XML;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class node_to_array {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("PersonaSerie.xml");
            NodeList personList = doc.getElementsByTagName("persona");
            List<String> listNombres = new ArrayList<>();
            List<String> listSeries = new ArrayList<>();

            for (int i = 0; i < personList.getLength(); i++) {
                Node p = personList.item(i);
                if (p.getNodeType() == Node.ELEMENT_NODE) {
                    Element persona = (Element) p;
                    NodeList nameList = persona.getChildNodes();
                    for (int j = 0; j < nameList.getLength(); j++) {
                        Node n = nameList.item(j);
                        if (n.getNodeType() == Node.ELEMENT_NODE && n.getNodeName().equals("nombre")) {
                          
                                System.out.println("Persona: " + n.getTextContent());
                                listNombres.add(n.getTextContent());
                        }
                        else if (n.getNodeType() == Node.ELEMENT_NODE && n.getNodeName().equals("serie_favorita")) {
                            System.out.println("Serie Favorita: " + n.getTextContent());
                            listSeries.add(n.getTextContent());
                        }
                    }
                }
            }

            System.out.println();
            System.out.println("Eso es todo");
            System.out.println();
            for (int k = 0; k < listNombres.size(); k++) {
                System.out.print(listNombres.get(k).toString()+" ");
                System.out.print(listSeries.get(k).toString()+" |");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
