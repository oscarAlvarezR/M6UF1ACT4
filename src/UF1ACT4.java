import java.io.File;
import java.io.ObjectInputStream.GetField;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class UF1ACT4 {

	public static void main(String[] args) {

		try {
			File archivo = new File("alumnes.xml");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
			Document document = documentBuilder.parse(archivo);
			document.getDocumentElement().normalize();
			System.out.println("Elemento raiz:" + document.getDocumentElement().getNodeName());
			System.out.println();
			NodeList listaAlumnos = document.getElementsByTagName("alumne");

			for (int i = 0; i < listaAlumnos.getLength(); i++) {
				  Node node = listaAlumnos.item(i);

				  if (node.getNodeType() == Node.ELEMENT_NODE) {
				    Element eElement = (Element) node;

				    if(eElement.hasChildNodes()) {
				      NodeList nl = node.getChildNodes();
				      System.out.println(eElement.getNodeName() + " id: " + eElement.getAttribute("id"));
				      for(int j=0; j<nl.getLength(); j++) {
				        Node nd = nl.item(j);
				        String nodeName = nd.getNodeName();
				        if (!nodeName.equals("#text")){
					        System.out.println(nodeName + ": " + nd.getTextContent());
				        }
				        
				      }
				      System.out.println();
				    }
				  }
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
