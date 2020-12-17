package edu.epam.triangle.observer.impl;

import edu.epam.triangle.entity.TriangleProperties;
import edu.epam.triangle.entity.Triangle;
import edu.epam.triangle.observer.Observer;
import edu.epam.triangle.service.TriangleService;
import edu.epam.triangle.service.impl.TriangleServiceImpl;
import edu.epam.triangle.warehouse.TriangleWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleObserver implements Observer<Triangle> {
    private static final Logger logger = LogManager.getLogger(TriangleObserver.class);
    @Override
    public void performedPerimeter(Triangle triangle) {
        Long id = triangle.getId();
        TriangleService triangleService = TriangleServiceImpl.getInstance();
        TriangleWarehouse triangleWarehouse = TriangleWarehouse.getInstance();
        double perimeter = triangleService.perimeter(triangle);
        TriangleProperties triangleProperties = triangleWarehouse.get(id);
        triangleProperties.setPerimeter(perimeter);
        logger.info("perimeter was updated in {} , new perimeter {}",triangle,perimeter);
    }

    @Override
    public void performedArea(Triangle triangle) {
        Long id = triangle.getId();
        TriangleService triangleService = TriangleServiceImpl.getInstance();
        TriangleWarehouse triangleWarehouse = TriangleWarehouse.getInstance();
        double area = triangleService.area(triangle);
        TriangleProperties triangleProperties = triangleWarehouse.get(id);
        triangleProperties.setArea(area);
        logger.info("area was updated in {} , new area {}",triangle,area);
    }
}
