package edu.epam.triangle.parser;

import edu.epam.triangle.entity.Point;
import edu.epam.triangle.exception.TriangleParserException;
import edu.epam.triangle.validator.InputValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TriangleParser {
    private static final Logger logger = LogManager.getLogger(TriangleParser.class);
    private static final String DELIMITER = "\\s+";

    public List<Point> parseTriangle(String line) throws TriangleParserException {
        InputValidator inputValidator = new InputValidator();
        if(!inputValidator.validateInput(line)) {
            logger.info("invalid line : {} ",line);
            throw new TriangleParserException("invalid line : " + line);
        }
        List<Point> points = new ArrayList<>();
        String [] data = line.split(DELIMITER);
        Point point1 = new Point(Double.parseDouble(data[0]),Double.parseDouble(data[1]));
        Point point2 = new Point(Double.parseDouble(data[2]),Double.parseDouble(data[3]));
        Point point3 = new Point(Double.parseDouble(data[4]),Double.parseDouble(data[5]));
        points.add(point1);
        points.add(point2);
        points.add(point3);
        return points;
    }
}
