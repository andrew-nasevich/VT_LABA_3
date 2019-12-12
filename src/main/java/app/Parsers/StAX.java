package app.Parsers;

import app.AutoBase.FuelType;
import app.AutoBase.Vehicle;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.InputStream;
import java.util.ArrayList;

public class StAX implements AutoCloseable {
    private static final XMLInputFactory FACTORY = XMLInputFactory.newInstance();

    private final XMLStreamReader reader;

    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    public ArrayList<Vehicle> getResult() throws XMLStreamException {

        while (reader.hasNext()) {       // while not end of XML
            int event = reader.next();   // read next event
            if (event == XMLEvent.START_ELEMENT &&
                    "vehicle".equals(reader.getLocalName())) {
                Vehicle vehicle = new Vehicle();

                doUntil(XMLEvent.START_ELEMENT, "make");
                vehicle.setMake(reader.getElementText());

                doUntil(XMLEvent.START_ELEMENT, "model");
                vehicle.setModel(reader.getElementText());

                doUntil(XMLEvent.START_ELEMENT, "price");
                vehicle.setPrice(Double.parseDouble(reader.getElementText()));

                doUntil(XMLEvent.START_ELEMENT, "fuelConsumption");
                vehicle.setFuelConsumption(Double.parseDouble(reader.getElementText()));

                doUntil(XMLEvent.START_ELEMENT, "power");
                vehicle.setPower(Integer.parseInt(reader.getElementText()));

                doUntil(XMLEvent.START_ELEMENT, "year");
                vehicle.setYear(Integer.parseInt(reader.getElementText()));

                doUntil(XMLEvent.START_ELEMENT, "fuelType");
                vehicle.setFuelType(FuelType.valueOf(reader.getElementText()));

                vehicles.add(vehicle);
            }
        }

        return vehicles;
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