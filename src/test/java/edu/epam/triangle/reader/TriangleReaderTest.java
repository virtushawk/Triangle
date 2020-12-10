package edu.epam.triangle.reader;

import edu.epam.triangle.entity.Point;
import edu.epam.triangle.entity.impl.Triangle;
import edu.epam.triangle.factory.impl.TriangleFactory;
import edu.epam.triangle.parser.TriangleParser;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TriangleReaderTest {

    public final static String PATH = "file/test.txt";

    @Test
    public void readFromFile(){
        TriangleReader triangleReader = new TriangleReader();
        TriangleParser triangleParser = new TriangleParser();
        TriangleFactory triangleFactory = new TriangleFactory();
        Triangle expected = new Triangle(new Point(1,1),new Point(2,2), new Point(3,3));
        List<String> data = triangleReader.readFromFile(PATH);
        List<Point> points = triangleParser.parseTriangle(data);
        Point p1 = points.get(0);
        Point p2 = points.get(1);
        Point p3 = points.get(2);
        Triangle actual = triangleFactory.createShape(p1,p2,p3);
        Assert.assertEquals(actual,expected);
    }
}
