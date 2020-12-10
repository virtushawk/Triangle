package edu.epam.triangle.entity.impl;

import edu.epam.triangle.entity.Point;
import edu.epam.triangle.entity.Shape;
import edu.epam.triangle.util.IdGenerator;

public class Triangle extends Shape {
    private Point a;
    private Point b;
    private Point c;
    private long id = IdGenerator.generateId();

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Point getA() {
        return a;
    }

    public void setA(Point a) {
        this.a = a;
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        this.b = b;
    }

    public Point getC() {
        return c;
    }

    public void setC(Point c) {
        this.c = c;
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return a.equals(triangle.a) && b.equals(triangle.b) && c.equals(triangle.c);
    }

    @Override
    public int hashCode() {
        int hash = ((a == null) ? 0 : a.hashCode());
        hash = hash * 31 + ((b == null) ? 0 : b.hashCode());
        hash = hash * 31 + ((c == null) ? 0 : c.hashCode());
        return hash;
    }
}
