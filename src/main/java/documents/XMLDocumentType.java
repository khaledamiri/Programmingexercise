package documents;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public interface XMLDocumentType {

    boolean wellFormedDocument(String xmlFileName) throws ParserConfigurationException, SAXException, IOException;
}
