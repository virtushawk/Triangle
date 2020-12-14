package edu.epam.triangle.validator;

import edu.epam.triangle.entity.Point;

public class TriangleValidator {

    public boolean isTriangle(Point p1,Point p2,Point p3) {
        boolean flag = true;
        double x1 = p1.getX();
        double y1 = p1.getY();
        double x2 = p2.getX();
        double y2 = p2.getY();
        double x3 = p3.getX();
        double y3 = p3.getY();
        double result = 1.0/2 * Math.abs((x1 - x3) * (y2-y3) - (x2-x3) * (y1 - y3));
        if(result == 0) {
            flag = false;
        }
        return flag;
    }
}
