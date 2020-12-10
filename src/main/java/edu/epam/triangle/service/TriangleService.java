package edu.epam.triangle.service;

import edu.epam.triangle.entity.Point;
import edu.epam.triangle.entity.impl.Triangle;

public interface TriangleService {
    double area(Triangle triangle);
    double perimeter(Triangle triangle);
    double sideLength(Point p1, Point p2);
    boolean isTriangle(Triangle triangle);
    boolean isRightTriangle(Triangle triangle);
    boolean isIsoscelesTriangle(Triangle triangle);
    boolean isEquilateralTriangle(Triangle triangle);
}
