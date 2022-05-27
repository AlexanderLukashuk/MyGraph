package com.company;

import java.util.*;

public class WeightedGraph<V> {
    private final boolean undirected;
    private Map<V, Vertex<V>> map = new HashMap<>();

    public WeightedGraph() {
        this.undirected = true;
    }

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(V v) {
        map.put(v, new Vertex<>(v));
    }

    public void addEdge(V source, V dest, double weight) {
        if (!hasVertex((Vertex) source))
            addVertex(source);

        if (!hasVertex((Vertex) dest))
            addVertex(dest);

        if (hasEdge(source, dest)
                || source.equals(dest))
            return; // reject parallels & self-loops

//        map.get(source).add(new Edge<>(source, dest, weight));
        map.get(source).addVertex(map.get(dest), weight);

        if (undirected) {
//            map.get(dest).add(new Edge<>(dest, source, weight));
            map.get(dest).addVertex(map.get(dest), weight);
        }
    }

    public int getVerticesCount() {
        return map.size();
    }

    public int getEdgesCount() {
        int count = 0;
        for (V v : map.keySet()) {
            count += map.get(v).size();
        }

        if (undirected)
            count /= 2;

        return count;
    }


    public boolean hasVertex(Vertex v) {
        return map.containsKey(v);
    }

    public boolean hasEdge(V source, V dest) {
        if (!hasVertex((Vertex) source)) return false;
        return map.get(source).contains(new Vertex<>(dest));
    }

    public Iterable<V> adjacencyList(V v) {
        if (!hasVertex((Vertex) v)) return null;
        List<V> vertices = new LinkedList<>();
        for (Vertex<V> e : map.get(v).getAdjacentVertices()) {
//            vertices.add(e.getDest());
            vertices.add(e.getData());
        }
        return vertices;
    }

//    public Iterable<Edge<V>> getEdges(V v) {
//        if (!hasVertex((Vertex) v)) return null;
//        return map.get(v).getAdjacentVertices(); // hz как исправить
//    }
}
