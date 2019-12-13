package app.Parsers;

import app.Hotel.Room;
import app.Hotel.ViewType;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

import java.util.*;

public class SAX extends DefaultHandler{

    private Room room;
    private String thisElement = "";
    private ArrayList<Room> rooms = new ArrayList<Room>();

    public ArrayList<Room> getResult(){  return rooms;  }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start parse XML...");
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        thisElement = qName;

        if (qName.equals("room")){
            room = new Room();
        }
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        thisElement = "";
        if (qName.equals("room")){
            rooms.add(room);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (thisElement.equals("name")) {
            room.setName(new String(ch, start, length));
        }
        if (thisElement.equals("surname")) {
            room.setSurname(new String(ch, start, length));
        }
        if (thisElement.equals("price")) {
            room.setPrice(Double.parseDouble(new String(ch, start, length)));
        }
        if (thisElement.equals("sale")) {
            room.setSale(Double.parseDouble(new String(ch, start, length)));
        }
        if (thisElement.equals("number")) {
            room.setNumber(Integer.parseInt(new String(ch, start, length)));
        }
        if (thisElement.equals("countOfRoom")) {
            room.setCountOfRoom(Integer.parseInt(new String(ch, start, length)));
        }
    }

    @Override
    public void endDocument() {
        System.out.println("Stop parse XML...");
    }
}