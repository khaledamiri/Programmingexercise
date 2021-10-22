import java.nio.file.Files;
import java.nio.file.Paths;

public class TEXTDocumentType extends DocumentType {

    public TEXTDocumentType() {
    }

    public void documentTextPhrasesExceed100Character(String item) {
        if (item.length() > Constants.EXCEEDNUMBER) {
            throw new ExceedLineNumberException(String.format("Exceed %o Number of line", Constants.EXCEEDNUMBER));
        }
    }

    public String replaceTextPhrasesInDocument(String lineOfInput, String search, String replace) {
        return lineOfInput.replaceAll(search, replace);
    }

    public boolean goodFile(String fileName) {
        return Files.isRegularFile(Paths.get(fileName));
    }
}
