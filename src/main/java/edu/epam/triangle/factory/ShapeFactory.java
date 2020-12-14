package edu.epam.triangle.factory;

import edu.epam.triangle.entity.Point;
import edu.epam.triangle.entity.Shape;

public abstract class ShapeFactory {


    public abstract Shape createShape(Point...p);
}
