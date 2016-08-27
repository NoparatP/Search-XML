package searchdom;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class SearchDom {

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory
                    = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            String dir = "Christopher Nolan";
            NodeList nList = doc.getElementsByTagName("film");
            System.out.println("Search Director : " + dir);
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);  
                Element eElement = (Element) nNode;
                if (dir.equals(eElement.getElementsByTagName("director").item(0).getTextContent())) {
                    System.out.println("title : "
                            + eElement
                            .getElementsByTagName("title")
                            .item(0)
                            .getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
