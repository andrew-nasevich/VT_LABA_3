package app.servlets;

import app.Hotel.Room;
import app.Parsers.StAX;
import app.XMLVerifier.XMLVerifier;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

@WebServlet("/controller")
public class ListServlet extends HttpServlet {

    private static final int PAGE_SIZE = 3;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IOException {

        String carsXSD =  "D:\\УНИВЕР\\3 курс\\WT3\\java\\src\\data\\rooms.xsd";
        String carsXML =  "D:\\УНИВЕР\\3 курс\\WT3\\java\\src\\data\\rooms.xml";

        XMLVerifier xmlVerifier = new XMLVerifier();
        if (!xmlVerifier.validate(new File(carsXML), new File(carsXSD))){
            System.out.println("Invalid format rooms.xml");
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
        ArrayList<Room> rooms = saxp.getResult();*/
        /********************************************************/



        /************************  DOM parser   *****************/
       /* DOM dom = new DOM();
        ArrayList<Room> rooms = null;
        try {
            rooms = dom.getResult(carsXML);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }*/
        /********************************************************/



        /************************  StAX parser   *****************/
        ArrayList<Room> rooms = null;
        try {
            StAX StAX = new StAX(Files.newInputStream(Paths.get(carsXML)));
            rooms = StAX.getResult();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        /********************************************************/


        int index = Integer.parseInt(req.getParameter("pageIndex") == null ? "1" : req.getParameter("pageIndex"));

        if (rooms != null){
            req.setAttribute("rooms", rooms.subList((index - 1) * PAGE_SIZE, Math.min(index * PAGE_SIZE, rooms.size())));
            req.setAttribute("pageSize", PAGE_SIZE);
            int pageCount = rooms.size() / PAGE_SIZE;
            int mod = (rooms.size() % PAGE_SIZE) == 0 ? 0 : 1;
            req.setAttribute("pageCount", pageCount + mod);
            req.setAttribute("pageIndex", index);
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/list.jsp");
        requestDispatcher.forward(req, resp);
    }
}
