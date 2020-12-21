package edu.epam.triangle.observer;

import edu.epam.triangle.entity.AbstractShape;

public interface Observer<T extends AbstractShape> {
    void performedPerimeter(T t);
    void performedArea(T t);
}
