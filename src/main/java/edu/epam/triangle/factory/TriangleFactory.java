package edu.epam.triangle.factory;

import edu.epam.triangle.entity.Point;
import edu.epam.triangle.entity.Triangle;
import edu.epam.triangle.exception.ShapeFactoryException;
import edu.epam.triangle.validator.TriangleValidator;

public class TriangleFactory extends ShapeFactory {

    @Override
    public Triangle createShape(Point...points) throws ShapeFactoryException {
        TriangleValidator triangleValidator = new TriangleValidator();
        if(!triangleValidator.isTriangle(points[0],points[1],points[2])){
            throw new ShapeFactoryException();
        }
        Triangle triangle = new Triangle(points[0],points[1],points[2]);
        return triangle;
    }
}
