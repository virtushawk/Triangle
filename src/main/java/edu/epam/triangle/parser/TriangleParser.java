package edu.epam.triangle.parser;

import edu.epam.triangle.entity.Point;
import edu.epam.triangle.entity.impl.Triangle;
import edu.epam.triangle.exception.ShapeFactoryException;
import edu.epam.triangle.factory.impl.TriangleFactory;
import edu.epam.triangle.validator.InputValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TriangleParser {
    private static final Logger logger = LogManager.getLogger(TriangleParser.class);
    private static final String SPLIT_BY = "\\s+";

    public List<Triangle> parseTriangle(List<String> list) {
        List<Triangle> triangles = new ArrayList<>();
        InputValidator inputValidator = new InputValidator();
        for (String line: list) {
            if(inputValidator.validateInput(line)){
                String [] data = line.split(SPLIT_BY);
                Point p1 = new Point(Double.parseDouble(data[0]),Double.parseDouble(data[1]));
                Point p2 = new Point(Double.parseDouble(data[2]),Double.parseDouble(data[3]));
                Point p3 = new Point(Double.parseDouble(data[4]),Double.parseDouble(data[5]));
                TriangleFactory triangleFactory = new TriangleFactory();
                Triangle triangle = null;
                try {
                    triangle = triangleFactory.createShape(p1,p2,p3);
                    triangles.add(triangle);
                } catch (ShapeFactoryException e) {
                    logger.error("{},{} and {} cannot be triangle",p1,p2,p3);
                }
            }
        }
        return triangles;
    }
}
