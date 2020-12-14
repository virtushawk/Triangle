package edu.epam.triangle.observer;

import edu.epam.triangle.entity.Shape;

public interface Observer<T extends Shape> {
    void performedPerimeter(T t);
    void performedArea(T t);
}
