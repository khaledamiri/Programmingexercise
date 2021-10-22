import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public abstract class DocumentType {

    abstract void documentTextPhrasesExceed100Character(String item);

    abstract String replaceTextPhrasesInDocument(String lineOfInput, String search, String replace);

    public abstract boolean goodFile(String xmlFileName) throws ParserConfigurationException, SAXException, IOException;
}
