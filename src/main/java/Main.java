import app.AutoBase.Vehicle;
import app.Parsers.SAX;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {


    public Main() throws ParserConfigurationException, SAXException {
    }

    private static boolean validateXMLByXSD(File xml, File xsd)
    {
        try {
            SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI)
                    .newSchema(xsd)
                    .newValidator()
                    .validate(new StreamSource(xml));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {


        String carsXSD =  new File("").getAbsolutePath()+"\\src\\data\\cars.xsd";
        String carsXML =  new File("").getAbsolutePath()+"\\src\\data\\cars.xml";
        if (!validateXMLByXSD(new File(carsXML), new File(carsXSD))){
            System.out.println("Invalid format cars.xml");
            System.exit(0);
        }

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        SAX saxp = new SAX();

        parser.parse(new File(carsXML), saxp);

        ArrayList<Vehicle> vehicles = saxp.getResult();

        for (Vehicle v :
             vehicles) {
            System.out.println(v);
        }
    }
}