package edu.htwk.fdit.prog2.uebung5.persistence;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LogReader {

    private LogReader() {}

    public static String readFile() throws FileNotFoundException {
        return readFile(
                Paths.get(Paths.get("").toAbsolutePath()+ "/programming2/src/edu/htwk/fdit/prog2/uebung5/persistence/log.txt")
        );
    }

    public static String readFile(Path pathToFile) throws FileNotFoundException {

        if(!Files.exists(pathToFile)) {
            throw new FileNotFoundException("File not found at: " + pathToFile.toAbsolutePath());
        }

        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(pathToFile)) {
            content.append(reader.lines().toList());
        } catch(IOException ex) {
            ex.printStackTrace();
        }
        return content.toString();
    }

}
