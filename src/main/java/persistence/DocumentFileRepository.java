package persistence;

import documents.DocumentType;
import logging.ConsoleLogger;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DocumentFileRepository {

    private DocumentType documentType;
    ConsoleLogger consoleLogger = new ConsoleLogger();

    public DocumentFileRepository(DocumentType documentType) {
        this.documentType = documentType;
    }

    public List<String> findAll(String type) {
        List<String> documents = new ArrayList<>();
        String path = Paths.get("test-input." + type).toString();

        try (Scanner scanner = new Scanner(new File(path))) {
            // Process content
            while (scanner.hasNextLine()) {
                documents.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return documents;
    }


    public void save(String fileOutputName, String type, String line, String search, String replace) throws IOException {
        documentType.documentTextPhrasesExceed100Character(line);
        line = documentType.replaceTextPhrasesInDocument(line, search, replace);

        try (PrintWriter textOutFile = new PrintWriter(new FileOutputStream(fileOutputName + type, true))) {
            textOutFile.println(line);
            consoleLogger.writeConsole(line);
        }
    }
}
