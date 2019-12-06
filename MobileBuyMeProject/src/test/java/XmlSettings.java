import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XmlSettings {
        private String url;
        private String browser;
        private final String FILE_NAME = "settings.xml";
        XmlSettings() throws IOException, SAXException, ParserConfigurationException {
            readSettings();
        }
        public void readSettings() {
            try {
                //get the file handle (the file name is set above).  the file will be read from the folder you started the program.
                File file = new File(FILE_NAME);
                //construct the XML document.
                DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
                //read and parse the file.
                Document settingsDocument = documentBuilder.parse(file);
                //get values from the file and assign them to variables.
                url = settingsDocument.getElementsByTagName("url").item(0).getTextContent();
                browser = settingsDocument.getElementsByTagName("browser").item(0).getTextContent();
                //catch all mandatory exceptions.
            } catch (IOException iex) {
                System.out.println(iex);
            } catch (SAXException rex) {
                System.out.println(rex);
            } catch (ParserConfigurationException pex) {
                System.out.println(pex);
            }
        }
        public String getUrl() {
            return url;
        }
        public String getBrowser() {
            return browser;
        }
    }

