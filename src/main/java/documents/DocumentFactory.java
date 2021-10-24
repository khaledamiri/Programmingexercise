package documents;

import utils.Constants;

import java.util.HashMap;
import java.util.Map;

public class DocumentFactory {

    Map<String, DocumentType> DOCUMENT_FACTORY_MAP = new HashMap<>();

    public DocumentFactory() {
        DOCUMENT_FACTORY_MAP.put(Constants.TXT, new TEXTDocumentTypeImpl());
        DOCUMENT_FACTORY_MAP.put(Constants.XML, new XMLDocumentTypeImpl());
    }

    public DocumentType getDocument(String type) {
        if (DOCUMENT_FACTORY_MAP.containsKey(type)) {
            return DOCUMENT_FACTORY_MAP.get(type);
        }
        throw new RuntimeException("Invalid document type");
    }

}
