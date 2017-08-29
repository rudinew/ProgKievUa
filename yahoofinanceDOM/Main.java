import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Main {

    public static void main(String[] args) throws Exception {

        String request = "http://query.yahooapis.com/v1/public/yql?format=xml&q=select%20*%20from%20" +
                "yahoo.finance.xchange%20where%20pair%20in%20(\"USDEUR\",%20\"USDUAH\")&env=store://datatables.org/alltableswithkeys";

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        Document document = documentBuilder.parse(request);
        Element root = document.getDocumentElement();

        NodeList nodeList = root.getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;

                /*System.out.println("id: " + element.getElementsByTagName("id").item(0)
                        .getChildNodes().item(0).getNodeValue());*/

                System.out.println("Name: " + element.getElementsByTagName("Name").item(i)
                        .getChildNodes().item(i).getNodeValue());

                System.out.println("Rate: " + element.getElementsByTagName("Rate").item(i)
                        .getChildNodes().item(i).getNodeValue());

                System.out.println("Date: " + element.getElementsByTagName("Date").item(i)
                        .getChildNodes().item(i).getNodeValue());

                System.out.println("Time: " + element.getElementsByTagName("Time").item(i)
                        .getChildNodes().item(i).getNodeValue());

                System.out.println("Ask: " + element.getElementsByTagName("Ask").item(i)
                        .getChildNodes().item(i).getNodeValue());

                System.out.println("Bid: " + element.getElementsByTagName("Bid").item(i)
                        .getChildNodes().item(i).getNodeValue());
                System.out.println("----------------------");
            }
        }
    }
}
