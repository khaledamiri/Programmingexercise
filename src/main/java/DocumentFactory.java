import java.util.HashMap;
import java.util.Map;

public class DocumentFactory {

    Map<String, DocumentType> DOCUMENT_FACTORY_MAP = new HashMap<>();

    public DocumentFactory() {
        DOCUMENT_FACTORY_MAP.put(Constants.TXT, new TEXTDocumentType());
        DOCUMENT_FACTORY_MAP.put(Constants.XML, new XMLDocumentType());
    }

    public DocumentType getDocument(String type) {
        if (DOCUMENT_FACTORY_MAP.containsKey(type)) {
            return DOCUMENT_FACTORY_MAP.get(type);
        }
        throw new UnsupportedOperationException();
    }

}
