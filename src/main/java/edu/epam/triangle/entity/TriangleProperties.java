package edu.epam.triangle.entity;

public class TriangleProperties {
    private double area;
    private double perimeter;

    public TriangleProperties(double area, double perimeter) {
        this.area = area;
        this.perimeter = perimeter;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TriangleProperties that = (TriangleProperties) o;
        return Double.compare(that.area, area) == 0 && Double.compare(that.perimeter, perimeter) == 0;
    }

    @Override
    public int hashCode() {
        int hash = Double.hashCode(area);
        hash = hash * 31 + Double.hashCode(perimeter);
        return hash;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TriangleProperties{");
        sb.append("area=").append(area);
        sb.append(", perimeter=").append(perimeter);
        sb.append('}');
        return sb.toString();
    }
}
