import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
public class XmlProgram {
        public static void main(String arg[]) throws ParserConfigurationException, SAXException, IOException {
            XmlSettings xmlSettings = new XmlSettings();
            System.out.println("url: " + xmlSettings.getUrl());
            System.out.println("Browser: " + xmlSettings.getBrowser());
        }
    }

