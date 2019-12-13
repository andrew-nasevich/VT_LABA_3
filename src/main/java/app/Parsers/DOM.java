package app.Parsers;

import app.Hotel.Room;
import app.Hotel.ViewType;
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

    private ArrayList<Room> rooms = new ArrayList<>();

    public ArrayList<Room> getResult(String XMLPath) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(XMLPath));

        NodeList vehicleElements = document.getDocumentElement().getElementsByTagName("room");

        for (int i = 0; i < vehicleElements.getLength(); i++) {

            Node nNode =vehicleElements.item(i);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                Room room = new Room();

                room.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
                room.setSurname(eElement.getElementsByTagName("surname").item(0).getTextContent());
                room.setPrice(Double.parseDouble(eElement.getElementsByTagName("price").item(0).getTextContent()));
                room.setSale(Double.parseDouble(eElement.getElementsByTagName("sale").item(0).getTextContent()));
                room.setNumber(Integer.parseInt(eElement.getElementsByTagName("number").item(0).getTextContent()));
                room.setCountOfRoom(Integer.parseInt(eElement.getElementsByTagName("countOfRoom").item(0).getTextContent()));
                rooms.add(room);
            }
        }

        return rooms;
    }
}
