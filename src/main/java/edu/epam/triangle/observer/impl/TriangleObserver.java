package edu.epam.triangle.observer.impl;

import edu.epam.triangle.entity.TriangleProperties;
import edu.epam.triangle.entity.impl.Triangle;
import edu.epam.triangle.observer.Observer;
import edu.epam.triangle.service.TriangleService;
import edu.epam.triangle.service.impl.TriangleServiceImpl;
import edu.epam.triangle.warehouse.TriangleWarehouse;

public class TriangleObserver implements Observer<Triangle> {
    @Override
    public void performedPerimeter(Triangle triangle) {
        Long id = triangle.getId();
        TriangleService triangleService = TriangleServiceImpl.getInstance();
        TriangleWarehouse triangleWarehouse = TriangleWarehouse.getInstance();
        double perimeter = triangleService.perimeter(triangle);
        TriangleProperties triangleProperties = triangleWarehouse.get(id);
        triangleProperties.setPerimeter(perimeter);

    }

    @Override
    public void performedArea(Triangle triangle) {
        Long id = triangle.getId();
        TriangleService triangleService = TriangleServiceImpl.getInstance();
        TriangleWarehouse triangleWarehouse = TriangleWarehouse.getInstance();
        double area = triangleService.area(triangle);
        TriangleProperties triangleProperties = triangleWarehouse.get(id);
        triangleProperties.setArea(area);
    }
}
