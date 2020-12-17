package edu.epam.triangle.parser;

import edu.epam.triangle.entity.Point;
import edu.epam.triangle.validator.InputValidator;

import java.util.ArrayList;
import java.util.List;

public class TriangleParser {
    private static final String SPLIT_BY = "\\s+";

    public List<Point> parseTriangle(List<String> list) {
        List<Point> points = new ArrayList<>();
        InputValidator inputValidator = new InputValidator();
        for (String line: list) {
            if(inputValidator.validateInput(line)){
                String [] data = line.split(SPLIT_BY);
                Point p1 = new Point(Double.parseDouble(data[0]),Double.parseDouble(data[1]));
                Point p2 = new Point(Double.parseDouble(data[2]),Double.parseDouble(data[3]));
                Point p3 = new Point(Double.parseDouble(data[4]),Double.parseDouble(data[5]));
                points.add(p1);
                points.add(p2);
                points.add(p3);

            }
        }
        return points;
    }
}
