package edu.epam.triangle.repository.impl;

import edu.epam.triangle.entity.Triangle;
import edu.epam.triangle.repository.Repository;
import edu.epam.triangle.specification.Specification;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TriangleRepository implements Repository<Triangle> {
    private static final TriangleRepository instance = new TriangleRepository();
    private List<Triangle> triangles = new ArrayList<>();

    private TriangleRepository() {}

    public static TriangleRepository getInstance() {
        return instance;
    }

    @Override
    public void add(Triangle triangle) {
        triangles.add(triangle);
    }

    @Override
    public void remove(Triangle triangle) {
        triangles.remove(triangle);
    }

    @Override
    public Triangle get(int index) {
        return triangles.get(index);
    }

    @Override
    public List<Triangle> sort(Comparator<? super Triangle> comparator) {
        List<Triangle> listResult = new ArrayList<>(triangles);
        listResult.sort(comparator);
        return listResult;
    }

    @Override
    public List<Triangle> query(Specification<Triangle> specification) {
        List<Triangle> listResult = triangles.stream().filter(o -> specification.specify(o)).collect(Collectors.toList());
        return listResult;
    }
}
