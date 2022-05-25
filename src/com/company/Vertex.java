package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Vertex<V> {
    private V data;
    private Map<Vertex<V>, Double > adjacentVertices;

    public Vertex(V data) {
        this.data = data;
        adjacentVertices = new HashMap<>();
    }

    public void addVertex(Vertex<V> dest, double weight) {
        adjacentVertices.put(dest, weight);
    }

    public V getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return data.equals(vertex.data);
    }

}
