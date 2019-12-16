package app.Parsers;

import app.bean.Client;
import app.Hotel.ViewType;
import jdk.internal.ref.Cleaner;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DOM {

    private ArrayList<Client> clients = new ArrayList<>();

    public ArrayList<Client> getResult(String XMLPath) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(XMLPath));

        NodeList vehicleElements = document.getDocumentElement().getElementsByTagName("client");

        for (int i = 0; i < vehicleElements.getLength(); i++) {

            Node nNode =vehicleElements.item(i);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                Client client = new Client();


                client.setId(Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent()));
                client.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
                client.setBirthday(eElement.getElementsByTagName("birthday").item(0).getTextContent());
                client.setMedicalHistory(eElement.getElementsByTagName("medicalHistory").item(0).getTextContent());
                clients.add(client);
            }
        }

        return clients;
    }
}
