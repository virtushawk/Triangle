package edu.epam.triangle.specification.impl;

import edu.epam.triangle.entity.Point;
import edu.epam.triangle.entity.Triangle;
import edu.epam.triangle.specification.Specification;

public class PointAIntervalSpecification implements Specification<Triangle> {
    private Point pointFrom;
    private Point pointTo;

    public PointAIntervalSpecification(Point pointFrom,Point pointTo) {
        this.pointFrom = pointFrom;
        this.pointTo = pointTo;
    }

    @Override
    public boolean specify(Triangle triangle) {
        Point point = triangle.getA();
        boolean result = (point.getX() >= pointFrom.getX() && point.getX() <= pointTo.getX())
                && (point.getY() >= pointFrom.getY() && point.getY() <= pointTo.getY());
        return result;
    }
}
