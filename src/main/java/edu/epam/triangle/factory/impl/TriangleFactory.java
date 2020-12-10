package edu.epam.triangle.factory.impl;

import edu.epam.triangle.entity.Point;
import edu.epam.triangle.entity.impl.Triangle;
import edu.epam.triangle.factory.ShapeFactory;

public class TriangleFactory extends ShapeFactory {

    @Override
    public Triangle createShape(Point...p) {
        return new Triangle(p[0],p[1],p[2]);
    }
}
