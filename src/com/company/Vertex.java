package com.company;

import java.util.*;

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

    public int size() {
        return adjacentVertices.size();
    }

    public boolean contains(Vertex<V> vertexEdge) {
        return adjacentVertices.containsKey(vertexEdge);
    }

    public Set<Vertex<V>> getAdjacentVertices() {
        return adjacentVertices.keySet();
    }
}
