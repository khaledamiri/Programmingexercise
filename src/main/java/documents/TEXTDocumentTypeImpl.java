package documents;

import errors.ExceedLineNumberException;
import utils.Constants;

import java.nio.file.Files;
import java.nio.file.Paths;

public class TEXTDocumentTypeImpl implements TXTDocumentType, DocumentType {

    public TEXTDocumentTypeImpl() {
    }

    public boolean isRegularFile(String fileName) {
        return Files.isRegularFile(Paths.get(fileName));
    }

    public void documentTextPhrasesExceed100Character(String item) {
        if (item.length() > Constants.EXCEEDNUMBER) {
            throw new ExceedLineNumberException(String.format("Exceed %o Number of line", Constants.EXCEEDNUMBER));
        }
    }

    public String replaceTextPhrasesInDocument(String lineOfInput, String search, String replace) {
        return lineOfInput.replaceAll(search, replace);
    }


}
