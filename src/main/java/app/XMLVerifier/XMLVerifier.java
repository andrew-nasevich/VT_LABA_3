package app.XMLVerifier;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import java.io.File;

/**
 * The type Xml verifier.
 */
public class XMLVerifier {

    //private static final Logger log = Logger.getLogger(XMLVerifier.class);
    /**
     * Validate boolean.
     *
     * @param xml the xml
     * @param xsd the xsd
     * @return the boolean
     */
    public boolean validate(File xml, File xsd)
    {
        //log.info("Validating XML");
        try {
            SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI)
                    .newSchema(xsd)
                    .newValidator()
                    .validate(new StreamSource(xml));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //log.error("Validating error : " + e.getMessage());
            return false;
        }
        //log.info("XML validated");
        return true;
    }
}
