package edu.epam.triangle.warehouse;

import edu.epam.triangle.entity.TriangleProperties;

import java.util.HashMap;
import java.util.Map;

public class TriangleWarehouse {
    private static final TriangleWarehouse instance = new TriangleWarehouse();
    private Map<Long,TriangleProperties> properties = new HashMap<>();

    private TriangleWarehouse() {}

    public static TriangleWarehouse getInstance() {
        return instance;
    }

    public void put(Long id, TriangleProperties tp) {
        properties.put(id,tp);
    }

    public TriangleProperties get(Long id) {
       return properties.get(id);
    }

}
