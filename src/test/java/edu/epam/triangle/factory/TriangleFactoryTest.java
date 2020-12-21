package edu.epam.triangle.factory;

import edu.epam.triangle.entity.Point;
import edu.epam.triangle.entity.Triangle;
import edu.epam.triangle.exception.ShapeFactoryException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TriangleFactoryTest {

    @Test
    public void createShapeTest() throws ShapeFactoryException {
        TriangleFactory triangleFactory = new TriangleFactory();
        Point p1 = new Point(1,3);
        Point p2 = new Point(2,-5);
        Point p3 = new Point(-8,4);
        Triangle actual = triangleFactory.createShape(p1,p2,p3);
        Triangle expected = new Triangle(p1,p2,p3);
        Assert.assertEquals(actual,expected);
    }

    @Test(expectedExceptions = ShapeFactoryException.class)
    public void createShapeErrorTest() throws ShapeFactoryException {
        TriangleFactory triangleFactory = new TriangleFactory();
        Point p1 = new Point(1,1);
        Point p2 = new Point(2,2);
        Point p3 = new Point(3,3);
        Triangle triangle = triangleFactory.createShape(p1,p2,p3);
    }
}
