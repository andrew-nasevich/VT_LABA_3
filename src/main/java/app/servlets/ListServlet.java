package app.servlets;

import app.AutoBase.Vehicle;
import app.Parsers.DOM;
import app.Parsers.SAX;
import app.Parsers.StAX;
import app.XMLVerifier.XMLVerifier;
import org.xml.sax.SAXException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

@WebServlet("/controller")
public class ListServlet extends HttpServlet {

    private static final int PAGE_SIZE = 2;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IOException {

       // String carsXSD =  "C:\\5сем\\java\\src\\data\\cars.xsd";
       // String carsXML =  "C:\\5сем\\java\\src\\data\\cars.xml";
        String carsXSD =  "C:\\JavaProjects\\java\\src\\data\\cars.xsd";
        String carsXML =  "C:\\JavaProjects\\java\\src\\data\\cars.xml";

        XMLVerifier xmlVerifier = new XMLVerifier();
        if (!xmlVerifier.validate(new File(carsXML), new File(carsXSD))){
            System.out.println("Invalid format cars.xml");
            System.exit(0);
        }

        /************************  SAX parser   *****************/
        /*SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = null;
        try {
            parser = factory.newSAXParser();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        SAX saxp = new SAX();

        try {
            parser.parse(new File(carsXML), saxp);
        } catch (SAXException e) {
            e.printStackTrace();
        }
        ArrayList<Vehicle> vehicles = saxp.getResult();*/
        /********************************************************/



        /************************  DOM parser   *****************/
       /* DOM dom = new DOM();
        ArrayList<Vehicle> vehicles = null;
        try {
            vehicles = dom.getResult(carsXML);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }*/
        /********************************************************/



        /************************  StAX parser   *****************/
        ArrayList<Vehicle> vehicles = null;
        try {
            StAX StAX = new StAX(Files.newInputStream(Paths.get(carsXML)));
            vehicles = StAX.getResult();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        /********************************************************/


        int index = Integer.parseInt(req.getParameter("pageIndex") == null ? "1" : req.getParameter("pageIndex"));

        if (vehicles != null){
            req.setAttribute("vehicles", vehicles.subList((index - 1) * PAGE_SIZE, Math.min(index * PAGE_SIZE, vehicles.size())));
            req.setAttribute("pageSize", PAGE_SIZE);
            int pageCount = vehicles.size() / PAGE_SIZE;
            int mod = (vehicles.size() % PAGE_SIZE) == 0 ? 0 : 1;
            req.setAttribute("pageCount", pageCount + mod);
            req.setAttribute("pageIndex", index);
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/list.jsp");
        requestDispatcher.forward(req, resp);
    }
}
