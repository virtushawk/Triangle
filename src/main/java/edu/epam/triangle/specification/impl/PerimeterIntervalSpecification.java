package edu.epam.triangle.specification.impl;

import edu.epam.triangle.entity.TriangleProperties;
import edu.epam.triangle.entity.Triangle;
import edu.epam.triangle.specification.Specification;
import edu.epam.triangle.warehouse.TriangleWarehouse;

public class PerimeterIntervalSpecification implements Specification<Triangle> {
    private double perimeterFrom;
    private double perimeterTo;

    public PerimeterIntervalSpecification(double perimeterFrom, double perimeterTo){
        this.perimeterFrom = perimeterFrom;
        this.perimeterTo = perimeterTo;
    }

    @Override
    public boolean specify(Triangle triangle) {
        TriangleWarehouse warehouse = TriangleWarehouse.getInstance();
        long id = triangle.getId();
        TriangleProperties properties =  warehouse.get(id);
        double perimeter = properties.getPerimeter();
        boolean result = perimeter >= perimeterFrom && perimeter <= perimeterTo;
        return result;
    }
}
