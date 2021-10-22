import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Logger;

public class Programmingexercise {

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {

        Logger logger = Logger.getLogger(Programmingexercise.class.getName());

        String fileName = "test-input.";
        String fileOutputName = "test-output.";
        String type = args[0];
        String search = args[1];
        String replace = args[2];
        Scanner scanner = new Scanner(System.in);

        DocumentType documentFactory = new DocumentFactory().getDocument(type);

        boolean isGood = documentFactory.goodFile(fileName + type);
        if (isGood) {
            logger.info("Good file");
            try (PrintWriter textOutFile = new PrintWriter(new FileOutputStream(fileOutputName + type))) {
                while (scanner.hasNext()) {
                    String lineOfInput = scanner.nextLine();
                    documentFactory.documentTextPhrasesExceed100Character(lineOfInput);
                    lineOfInput = documentFactory.replaceTextPhrasesInDocument(lineOfInput, search, replace);
                    textOutFile.println(lineOfInput);
                    System.out.println(lineOfInput);
                }
            } finally {
                new FileOutputStream(fileOutputName + type).close();
            }
        } else {
            logger.warning("File is not good");
            throw new FileFormatException("File is not good");
        }
    }

}
