package edu.epam.triangle.reader;

import edu.epam.triangle.exception.TriangleReaderException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TriangleReader {
    private static final Logger logger = LogManager.getLogger(TriangleReader.class);

    public List<String> readFromFile(String path) throws TriangleReaderException {
        List<String> list = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            list = stream.collect(Collectors.toList());
        } catch (IOException e) {
            logger.error("an error occurred while reading the file : {} ",e.getMessage());
            throw new TriangleReaderException("an error occurred while reading the file : " + e);
        }
        return list;
    }
}
