package main;

import documents.*;
import errors.FileFormatException;
import logging.ConsoleLogger;
import org.xml.sax.SAXException;
import persistence.DocumentFileRepository;
import utils.Constants;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Programmingexercise {

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {

        // Create dependencies
        ConsoleLogger consoleLogger = new ConsoleLogger();
        TEXTDocumentTypeImpl textDocumentType = new TEXTDocumentTypeImpl();
        DocumentFileRepository documentFileRepository = new DocumentFileRepository(textDocumentType);

        String fileName = "test-input.";
        String fileOutputName = "test-output.";
        String type = args[0];
        String search = args[1];
        String replace = args[2];
        Scanner scanner = new Scanner(System.in);

        DocumentType documentFactory = new DocumentFactory().getDocument(type);
        boolean isGood;
        if (type.equals(Constants.TXT)) {
            isGood = ((TXTDocumentType) documentFactory).isRegularFile(fileName + type);
        } else {
            isGood = ((XMLDocumentType) documentFactory).wellFormedDocument(fileName + type);
        }

        if (isGood) {
            consoleLogger.writeInfo("Good file");
            List<String> all = documentFileRepository.findAll(type);
            all.forEach(item -> {
                try {
                    documentFileRepository.save(fileOutputName,type, item, search, replace);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            });
        } else {
            consoleLogger.writeError("File is not good", new FileFormatException("File is not good"));
        }
    }

}
