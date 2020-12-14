package edu.epam.triangle.factory.impl;

import edu.epam.triangle.entity.Point;
import edu.epam.triangle.entity.impl.Triangle;
import edu.epam.triangle.factory.ShapeFactory;

public class TriangleFactory extends ShapeFactory {

    @Override
    public Triangle createShape(Point...points) {
        return new Triangle(points[0],points[1],points[2]);
    }
}
