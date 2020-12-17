package edu.epam.triangle.observer;

import edu.epam.triangle.entity.Point;
import edu.epam.triangle.entity.Triangle;
import edu.epam.triangle.entity.TriangleProperties;
import edu.epam.triangle.observer.impl.TriangleObserver;
import edu.epam.triangle.repository.Repository;
import edu.epam.triangle.repository.impl.TriangleRepository;
import edu.epam.triangle.service.TriangleService;
import edu.epam.triangle.service.impl.TriangleServiceImpl;
import edu.epam.triangle.warehouse.TriangleWarehouse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TriangleObserverTest {
    public Repository<Triangle> repository = TriangleRepository.getInstance();
    public TriangleWarehouse triangleWarehouse = TriangleWarehouse.getInstance();

    @BeforeClass
    public void beforeClass() {
        Triangle triangle = new Triangle(new Point(1,3),new Point(2,-5),new Point(-8,4));
        TriangleService service = TriangleServiceImpl.getInstance();
        double area = service.area(triangle);
        double perimeter = service.perimeter(triangle);
        long id = triangle.getId();
        TriangleProperties triangleProperties = new TriangleProperties(area,perimeter);
        repository.add(triangle);
        triangleWarehouse.put(id,triangleProperties);
    }

    @Test
    public void notifyObserverTest() {
        Triangle triangle = repository.get(0);
        TriangleObserver observer = new TriangleObserver();
        triangle.attach(observer);
        Point point = new Point(2,3);
        triangle.setA(point);
        TriangleService service = TriangleServiceImpl.getInstance();
        double area = service.area(triangle);
        double perimeter = service.perimeter(triangle);
        long id = triangle.getId();
        TriangleProperties properties = triangleWarehouse.get(id);
        boolean actual = (area == properties.getArea()) && (perimeter == properties.getPerimeter());
        Assert.assertTrue(actual);
    }
}
