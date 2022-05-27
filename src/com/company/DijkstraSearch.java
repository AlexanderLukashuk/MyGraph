package com.company;

import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    private Set<Vertex<V>> unsettledNodes;
    private Map<Vertex<V>, Double> distances;
    private WeightedGraph<V> graph;

    public DijkstraSearch(WeightedGraph<V> graph, V source) {
        super((Vertex<V>) source);
        unsettledNodes = new HashSet<>();
        distances = new HashMap<>();
        this.graph = graph;
        dijkstra();
    }

    public void dijkstra() {
        distances.put(source, 0D);
        unsettledNodes.add(source);

        while (unsettledNodes.size() > 0) {
            Vertex<V> node = getVertexWithMinimumWeight(unsettledNodes);
            marked.add(node);
            unsettledNodes.remove(node);
            for (V target : graph.adjacencyList((V) node)) {
                if (getShortestDistance((Vertex) target) > getShortestDistance(node)
                        + getDistance((V) node, (V) target)) {
                    distances.put((Vertex<V>) target, getShortestDistance(node)
                            + getDistance((V) node, (V) target));
                    edgeTo.put((Vertex<V>) target, node);
                    unsettledNodes.add((Vertex<V>) target);
                }
            }
        }
    }

    private double getDistance(V node, V target) {
        for (Edge<V> edge : graph.getEdges(node)) {
            if (edge.getDest().equals(target))
                return edge.getWeight();
        }

        throw new RuntimeException("Not found!");
    }

    private Vertex getVertexWithMinimumWeight(Set<Vertex<V>> vertices) {
        Vertex minimum = null;
        for (Vertex vertex : vertices) {
            if (minimum == null)
                minimum = vertex;
            else {
                if (getShortestDistance(vertex) < getShortestDistance(minimum))
                    minimum = vertex;
            }
        }
        return minimum;
    }

    private double getShortestDistance(Vertex destination) {
        Double d = distances.get(destination);
        return (d == null ? Double.MAX_VALUE : d);
    }
}


