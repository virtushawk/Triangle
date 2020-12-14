package edu.epam.triangle.creator;

import edu.epam.triangle.entity.TriangleProperties;
import edu.epam.triangle.entity.impl.Triangle;
import edu.epam.triangle.parser.TriangleParser;
import edu.epam.triangle.reader.TriangleReader;
import edu.epam.triangle.repository.impl.TriangleRepository;
import edu.epam.triangle.service.TriangleService;
import edu.epam.triangle.service.impl.TriangleServiceImpl;
import edu.epam.triangle.warehouse.TriangleWarehouse;

import java.util.List;

public class RepositoryCreator {
    public void createRepositoryFromFile(String path) {
        TriangleReader triangleReader = new TriangleReader();
        TriangleParser triangleParser = new TriangleParser();
        TriangleRepository repository = TriangleRepository.getInstance();
        TriangleWarehouse warehouse = TriangleWarehouse.getInstance();
        TriangleService triangleService = TriangleServiceImpl.getInstance();
        List<String> data = triangleReader.readFromFile(path);
        List<Triangle> triangles = triangleParser.parseTriangle(data);
        for (Triangle triangle: triangles) {
            double area = triangleService.area(triangle);
            double perimeter = triangleService.perimeter(triangle);
            long id =  triangle.getId();
            TriangleProperties properties = new TriangleProperties(area,perimeter);
            repository.add(triangle);
            warehouse.put(id,properties);
        }
    }
}
