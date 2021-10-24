package documents;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public interface TXTDocumentType {

    boolean isRegularFile(String xmlFileName) throws ParserConfigurationException, SAXException, IOException;

}
