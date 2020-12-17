package edu.epam.triangle.specification.impl;

import edu.epam.triangle.entity.Point;
import edu.epam.triangle.entity.Triangle;
import edu.epam.triangle.specification.Specification;

public class PointThirdQuadrantSpecification implements Specification<Triangle> {

    @Override
    public boolean specify(Triangle triangle) {
        Point a = triangle.getA();
        Point b = triangle.getB();
        Point c = triangle.getC();
        boolean result  = (a.getX() < 0 && a.getY() < 0)
                && (b.getX() < 0 && b.getY() < 0)
                && (c.getX() < 0 && c.getY() < 0);
        return result;
    }
}
