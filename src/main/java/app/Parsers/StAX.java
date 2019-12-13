package app.Parsers;

import app.Hotel.Room;
import app.Hotel.ViewType;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.InputStream;
import java.util.ArrayList;

public class StAX implements AutoCloseable {
    private static final XMLInputFactory FACTORY = XMLInputFactory.newInstance();

    private final XMLStreamReader reader;

    private ArrayList<Room> rooms = new ArrayList<>();

    public ArrayList<Room> getResult() throws XMLStreamException {

        while (reader.hasNext()) {       // while not end of XML
            int event = reader.next();   // read next event
            if (event == XMLEvent.START_ELEMENT &&
                    "room".equals(reader.getLocalName())) {
                Room room = new Room();

                doUntil(XMLEvent.START_ELEMENT, "name");
                room.setName(reader.getElementText());

                doUntil(XMLEvent.START_ELEMENT, "surname");
                room.setSurname(reader.getElementText());

                doUntil(XMLEvent.START_ELEMENT, "price");
                room.setPrice(Double.parseDouble(reader.getElementText()));

                doUntil(XMLEvent.START_ELEMENT, "sale");
                room.setSale(Double.parseDouble(reader.getElementText()));

                doUntil(XMLEvent.START_ELEMENT, "number");
                room.setNumber(Integer.parseInt(reader.getElementText()));

                doUntil(XMLEvent.START_ELEMENT, "countOfRoom");
                room.setCountOfRoom(Integer.parseInt(reader.getElementText()));


                rooms.add(room);
            }
        }

        return rooms;
    }

    public StAX(InputStream is) throws XMLStreamException {
        reader = FACTORY.createXMLStreamReader(is);
    }


    public XMLStreamReader getReader() {
        return reader;
    }

    private boolean doUntil(int stopEvent, String value) throws XMLStreamException {
        while (reader.hasNext()) {
            int event = reader.next();
            if (event == stopEvent && value.equals(reader.getLocalName())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void close() {
        if (reader != null) {
            try {
                reader.close();
            } catch (XMLStreamException e) { // empty
            }
        }
    }
}