package XML;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class leerXML {

	public static void main(String[] args) throws Exception {

		
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder db =factory.newDocumentBuilder();
		Document document =db.parse(new File("DomTest.xml"));
		Node raiz=document.getFirstChild();
		
		raiz.getNodeName();
		NodeList nodos =raiz.getChildNodes();
		
//		Node nodo=nodos.item(i);
			
		
		
		
	}

}
