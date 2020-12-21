package edu.epam.triangle.factory;

import edu.epam.triangle.entity.Point;
import edu.epam.triangle.entity.AbstractShape;
import edu.epam.triangle.exception.ShapeFactoryException;

public abstract class ShapeFactory {
    public abstract AbstractShape createShape(Point...points) throws ShapeFactoryException;
}
