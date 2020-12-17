package edu.epam.triangle.service.impl;

import edu.epam.triangle.entity.Point;
import edu.epam.triangle.entity.Triangle;
import edu.epam.triangle.service.TriangleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleServiceImpl implements TriangleService {
    private static final Logger logger = LogManager.getLogger(TriangleServiceImpl.class);
    private static final TriangleServiceImpl instance = new TriangleServiceImpl();

    private TriangleServiceImpl() {}

    public static TriangleServiceImpl getInstance(){
        return instance;
    }

    @Override
    public double area(Triangle triangle) {
        double x1 = triangle.getA().getX();
        double y1 = triangle.getA().getY();
        double x2 = triangle.getB().getX();
        double y2 = triangle.getB().getY();
        double x3 = triangle.getC().getX();
        double y3 = triangle.getC().getY();
        double result = 1.0 / 2 * Math.abs((x1 - x3) * (y2 - y3) - (x2 - x3) * (y1 - y3));
        logger.info("area of {} is {}",triangle,result);
        return result;
    }

    @Override
    public double perimeter(Triangle triangle) {
        Point a = triangle.getA();
        Point b = triangle.getB();
        Point c = triangle.getC();
        double ab = sideLength(a,b);
        double ac = sideLength(a,c);
        double bc = sideLength(b,c);
        double result = ab + ac + bc;
        logger.info("Perimeter of {} is {}",triangle,result);
        return result;
    }

    @Override
    public double sideLength(Point p1, Point p2) {
        double x1 = p1.getX();
        double y1 = p1.getY();
        double x2 = p2.getX();
        double y2 = p2.getY();
        double result = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        logger.info("Side length of {} and {} is {}",p1,p2,result);
        return result;
    }

    @Override
    public boolean isTriangle(Triangle triangle) {
        boolean flag = true;
        double x1 = triangle.getA().getX();
        double y1 = triangle.getA().getY();
        double x2 = triangle.getB().getX();
        double y2 = triangle.getB().getY();
        double x3 = triangle.getC().getX();
        double y3 = triangle.getC().getY();
        double result = 1.0/2 * Math.abs((x1 - x3) * (y2-y3) - (x2-x3) * (y1 - y3));
        if(result == 0) {
            flag = false;
        }
        logger.info("Is {} triangle : {}",triangle,flag);
        return flag;
    }

    @Override
    public boolean isRightTriangle(Triangle triangle) {
        boolean flag = false;
        Point a = triangle.getA();
        Point b = triangle.getB();
        Point c = triangle.getC();
        double ab = sideLength(a,b);
        double ac = sideLength(a,c);
        double bc = sideLength(b,c);
        if((ab == Math.hypot(ac,bc)) || (ac == Math.hypot(ab,bc)) || (bc == Math.hypot(ab,ac))) {
            flag = true;
        }
        logger.info("Is {} right : {} ",triangle,flag);
        return flag;
    }

    @Override
    public boolean isIsoscelesTriangle(Triangle triangle) {
        boolean flag = false;
        Point a = triangle.getA();
        Point b = triangle.getB();
        Point c = triangle.getC();
        double ab = sideLength(a,b);
        double ac = sideLength(a,c);
        double bc = sideLength(b,c);
        if((ab == ac) || (ab == bc) || (ac == bc)){
            flag = true;
        }
        logger.info("Is {} isosceles : {}",triangle,flag);
        return flag;
    }

    @Override
    public boolean isEquilateralTriangle(Triangle triangle) {
        boolean flag = false;
        Point a = triangle.getA();
        Point b = triangle.getB();
        Point c = triangle.getC();
        double ab = sideLength(a,b);
        double ac = sideLength(a,c);
        double bc = sideLength(b,c);
        if((ab == ac) && (ab == bc) && (ac == bc)){
            flag = true;
        }
        logger.info("Is {} equilateral : {}",triangle,flag);
        return flag;
    }
}
