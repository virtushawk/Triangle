package edu.epam.triangle.entity;

import edu.epam.triangle.util.IdGenerator;

public abstract class AbstractShape {
    private long id = IdGenerator.generateId();

    public long getId() {
        return id;
    }

}
