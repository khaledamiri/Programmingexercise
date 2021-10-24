package documents;

public interface DocumentType {

    void documentTextPhrasesExceed100Character(String item);

    String replaceTextPhrasesInDocument(String lineOfInput, String search, String replace);

}
