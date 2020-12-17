package edu.epam.triangle.specification.impl;

import edu.epam.triangle.entity.Triangle;
import edu.epam.triangle.specification.Specification;

public class IdIntervalSpecification implements Specification<Triangle> {
    private long idFrom;
    private long idTo;

    public IdIntervalSpecification(long idFrom, long idTo) {
        this.idFrom = idFrom;
        this.idTo = idTo;
    }

    @Override
    public boolean specify(Triangle triangle) {
        long triangleId = triangle.getId();
        boolean result = triangleId >= idFrom && triangleId <= idTo;
        return result;
    }
}
