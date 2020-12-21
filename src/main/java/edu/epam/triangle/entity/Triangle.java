package edu.epam.triangle.entity;

import edu.epam.triangle.observer.Observable;
import edu.epam.triangle.observer.Observer;
import edu.epam.triangle.observer.impl.TriangleObserver;

public class Triangle extends AbstractShape implements Observable<TriangleObserver> {
    private Point a;
    private Point b;
    private Point c;
    private Observer<Triangle> observer;

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
        notifyObserver();
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        this.b = b;
        notifyObserver();
    }

    public Point getC() {
        return c;
    }

    public void setC(Point c) {
        this.c = c;
        notifyObserver();
    }

    @Override
    public void attach(TriangleObserver observer) {
        this.observer = observer;
    }

    @Override
    public void detach(TriangleObserver observer) {
        this.observer = null;
    }

    @Override
    public void notifyObserver() {
        if(observer != null) {
            observer.performedArea(this);
            observer.performedPerimeter(this);
        }
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Triangle{");
        sb.append("a=").append(a);
        sb.append(", b=").append(b);
        sb.append(", c=").append(c);
        sb.append(", id=").append(getId());
        sb.append('}');
        return sb.toString();
    }

}
