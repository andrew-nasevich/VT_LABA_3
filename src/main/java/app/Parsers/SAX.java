package app.Parsers;


import app.bean.Client;
import app.Hotel.ViewType;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

import java.util.*;

public class SAX extends DefaultHandler{

    private Client client;
    private String thisElement = "";
    private ArrayList<Client> clients = new ArrayList<Client>();

    public ArrayList<Client> getResult(){  return clients;  }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start parse XML...");
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        thisElement = qName;

        if (qName.equals("client")){
            client = new Client();
        }
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        thisElement = "";
        if (qName.equals("client")){
            clients.add(client);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (thisElement.equals("id")) {
            client.setId(Integer.parseInt((new String(ch, start, length))));
        }
        if (thisElement.equals("name")) {
            client.setName(new String(ch, start, length));
        }
        if (thisElement.equals("birthday")) {
            client.setBirthday(new String(ch, start, length));
        }
        if (thisElement.equals("medicalHistory")) {
            client.setMedicalHistory(new String(ch, start, length));
        }
    }

    @Override
    public void endDocument() {
        System.out.println("Stop parse XML...");
    }
}