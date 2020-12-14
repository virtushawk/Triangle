package edu.epam.triangle.factory.impl;

import edu.epam.triangle.entity.Point;
import edu.epam.triangle.entity.impl.Triangle;
import edu.epam.triangle.exception.ShapeFactoryException;
import edu.epam.triangle.factory.ShapeFactory;
import edu.epam.triangle.validator.TriangleValidator;

public class TriangleFactory extends ShapeFactory {

    @Override
    public Triangle createShape(Point...points) throws ShapeFactoryException {
        TriangleValidator triangleValidator = new TriangleValidator();
        if(!triangleValidator.isTriangle(points[0],points[1],points[2])){
            throw new ShapeFactoryException();
        }
        return new Triangle(points[0],points[1],points[2]);
    }
}
