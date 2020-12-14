package edu.epam.triangle.repository;

import edu.epam.triangle.creator.RepositoryCreator;
import edu.epam.triangle.entity.Point;
import edu.epam.triangle.entity.impl.Triangle;
import edu.epam.triangle.repository.impl.TriangleRepository;
import edu.epam.triangle.specification.Specification;
import edu.epam.triangle.specification.impl.AreaIntervalSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TriangleRepositoryTest {

    public final static String PATH = "file/test.txt";
    public TriangleRepository repository = TriangleRepository.getInstance();

    @BeforeClass
    public void beforeClass() {
        RepositoryCreator repositoryCreator = new RepositoryCreator();
        repositoryCreator.createRepositoryFromFile(PATH);
    }

    @Test
    public void queryAreaIntervalTest() {
        Specification specification = new AreaIntervalSpecification(1,10);
        List<Triangle> actual = repository.query(specification);
        List<Triangle> expected = new ArrayList<>();
        expected.add(repository.get(1));
        expected.add(repository.get(2));
        expected.add(repository.get(3));
        Assert.assertEquals(actual,expected);
    }
}
