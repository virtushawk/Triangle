package edu.epam.triangle.validator;

import edu.epam.triangle.entity.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TriangleValidatorTest {

    @Test
    public void isTriangleTrueTest() {
        Point point1 = new Point(1,3);
        Point point2 = new Point(2,-5);
        Point point3 = new Point(-8,4);
        TriangleValidator triangleValidator = new TriangleValidator();
        boolean actual = triangleValidator.isTriangle(point1,point2,point3);
        Assert.assertTrue(actual);
    }

    @Test
    public void isTriangleFalseTest() {
        Point point1 = new Point(1,1);
        Point point2 = new Point(2,2);
        Point point3 = new Point(3,3);
        TriangleValidator triangleValidator = new TriangleValidator();
        boolean actual = triangleValidator.isTriangle(point1,point2,point3);
        Assert.assertFalse(actual);
    }
}
