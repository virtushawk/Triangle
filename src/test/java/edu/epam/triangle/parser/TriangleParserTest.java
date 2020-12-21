package edu.epam.triangle.parser;

import edu.epam.triangle.entity.Point;
import edu.epam.triangle.exception.TriangleParserException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TriangleParserTest {

    @Test
    public void parseTriangleTest() throws TriangleParserException {
        String line = "1 3 2 -5 -8 4";
        TriangleParser triangleParser = new TriangleParser();
        List<Point> actual = triangleParser.parseTriangle(line);
        List<Point> expected = new ArrayList<>();
        expected.add(new Point(1,3));
        expected.add(new Point(2,-5));
        expected.add(new Point(-8,4));
        Assert.assertEquals(actual,expected);
    }

    @Test(expectedExceptions = TriangleParserException.class)
    public void parseTriangleInvalidLineTest() throws TriangleParserException {
        String line = "1a 1 2 2 3 3.0";
        TriangleParser triangleParser = new TriangleParser();
        List<Point> points = triangleParser.parseTriangle(line);
        boolean actual = points.isEmpty();
        Assert.assertTrue(actual);
    }

}
