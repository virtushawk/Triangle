package edu.epam.triangle.specification.impl;

import edu.epam.triangle.entity.TriangleProperties;
import edu.epam.triangle.entity.Triangle;
import edu.epam.triangle.specification.Specification;
import edu.epam.triangle.warehouse.TriangleWarehouse;

public class AreaIntervalSpecification implements Specification<Triangle> {
    private double areaFrom;
    private double areaTo;

    public AreaIntervalSpecification(double areaFrom, double areaTo){
        this.areaFrom = areaFrom;
        this.areaTo = areaTo;
    }

    @Override
    public boolean specify(Triangle triangle) {
        TriangleWarehouse warehouse = TriangleWarehouse.getInstance();
        long id = triangle.getId();
        TriangleProperties properties =  warehouse.get(id);
        double area = properties.getArea();
        boolean result = area >= areaFrom && area <= areaTo;
        return result;
    }
}
