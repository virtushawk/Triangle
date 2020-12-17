package edu.epam.triangle.service;

import edu.epam.triangle.entity.Point;
import edu.epam.triangle.entity.Triangle;
import edu.epam.triangle.service.impl.TriangleServiceImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TriangleServiceTest {

    @Test
    public void areaTest() {
        Triangle triangle = new Triangle(new Point(1,3),new Point(2,-5),new Point(-8,4));
        TriangleService triangleService = TriangleServiceImpl.getInstance();
        double actual = triangleService.area(triangle);
        double expected = 35.5;
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void perimeterTest() {
        Triangle triangle = new Triangle(new Point(-2,2),new Point(3,2),new Point(-1,0));
        TriangleService triangleService = TriangleServiceImpl.getInstance();
        double actual = triangleService.perimeter(triangle);
        double expected = 5 + 3 * Math.sqrt(5);
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void isTriangleTrueTest() {
        Triangle triangle = new Triangle(new Point(1,3),new Point(2,-5),new Point(-8,4));
        TriangleService triangleService = TriangleServiceImpl.getInstance();
        boolean actual = triangleService.isTriangle(triangle);
        Assert.assertTrue(actual);
    }

    @Test
    public void isTriangleFalseTest() {
        Triangle triangle = new Triangle(new Point(1,1),new Point(2,2),new Point(3,3));
        TriangleService triangleService = TriangleServiceImpl.getInstance();
        boolean actual = triangleService.isTriangle(triangle);
        Assert.assertFalse(actual);
    }

    @Test
    public void isRightTriangleTrueTest() {
        Triangle triangle = new Triangle(new Point(0,0),new Point(0,3),new Point(2,0));
        TriangleService triangleService = TriangleServiceImpl.getInstance();
        boolean actual = triangleService.isRightTriangle(triangle);
        Assert.assertTrue(actual);
    }

    @Test
    public void isRightTriangleFalseTest() {
        Triangle triangle = new Triangle(new Point(1,3),new Point(2,-5),new Point(-8,4));
        TriangleService triangleService = TriangleServiceImpl.getInstance();
        boolean actual = triangleService.isRightTriangle(triangle);
        Assert.assertFalse(actual);
    }

    @Test
    public void isIsoscelesTriangleTrueTest() {
        Triangle triangle = new Triangle(new Point(0,0),new Point(1,1),new Point(0,2));
        TriangleService triangleService = TriangleServiceImpl.getInstance();
        boolean actual = triangleService.isIsoscelesTriangle(triangle);
        Assert.assertTrue(actual);
    }

    @Test
    public void isIsoscelesTriangleFalseTest() {
        Triangle triangle = new Triangle(new Point(1,3),new Point(2,-5),new Point(-8,4));
        TriangleService triangleService = TriangleServiceImpl.getInstance();
        boolean actual = triangleService.isIsoscelesTriangle(triangle);
        Assert.assertFalse(actual);
    }

    @Test
    public void isEquilateralTriangleTrueTest() {
        Triangle triangle = new Triangle(new Point(2,-3),new Point(-2,3),new Point(3*Math.sqrt(3),
                2*Math.sqrt(3)));
        TriangleService triangleService = TriangleServiceImpl.getInstance();
        boolean actual = triangleService.isEquilateralTriangle(triangle);
        Assert.assertTrue(actual);
    }

    @Test
    public void isEquilateralTriangleFalseTest() {
        Triangle triangle = new Triangle(new Point(1,3),new Point(2,-5),new Point(-8,4));
        TriangleService triangleService = TriangleServiceImpl.getInstance();
        boolean actual = triangleService.isEquilateralTriangle(triangle);
        Assert.assertFalse(actual);


    }


}
