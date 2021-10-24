package documents;

import errors.ExceedLineNumberException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import utils.Constants;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class XMLDocumentTypeImpl implements XMLDocumentType, DocumentType {

    public XMLDocumentTypeImpl() {
    }

    public boolean wellFormedDocument(String xmlFileName) throws ParserConfigurationException, SAXException, IOException {
        try {
            DocumentBuilderFactory dBF = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dBF.newDocumentBuilder();
            InputSource is = new InputSource(xmlFileName);
            builder.parse(is);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public void documentTextPhrasesExceed100Character(String item) {
        // each text before < and between ""
        if (item.length() > Constants.EXCEEDNUMBER) {
            throw new ExceedLineNumberException(String.format("Exceed %o Number of line", Constants.EXCEEDNUMBER));
        }
    }

    public String replaceTextPhrasesInDocument(String lineOfInput, String search, String replace) {
        //each text between < and >  or between "" not exceed 100 characters
        return lineOfInput.replaceAll(search, replace);
    }

}
