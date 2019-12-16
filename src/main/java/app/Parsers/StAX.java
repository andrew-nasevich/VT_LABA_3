package app.Parsers;

import app.bean.Client;
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

    private ArrayList<Client> clients = new ArrayList<>();

    public ArrayList<Client> getResult() throws XMLStreamException {

        while (reader.hasNext()) {       // while not end of XML
            int event = reader.next();   // read next event
            if (event == XMLEvent.START_ELEMENT &&
                    "client".equals(reader.getLocalName())) {
                Client client = new Client();

                doUntil(XMLEvent.START_ELEMENT, "id");
                client.setId(Integer.parseInt(reader.getElementText()));

                doUntil(XMLEvent.START_ELEMENT, "name");
                client.setName(reader.getElementText());

                doUntil(XMLEvent.START_ELEMENT, "birthday");
                client.setBirthday(reader.getElementText());

                doUntil(XMLEvent.START_ELEMENT, "medicalHistory");
                client.setMedicalHistory(reader.getElementText());

                clients.add(client);
            }
        }

        return clients;
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