package com.company;

public class DepthFirstSearch<V> extends Search<V> {
    public DepthFirstSearch(MyGraph<Vertex<V>> graph, Vertex<V> source) {
        super(source);
        dfs(graph, source);
    }

    private void dfs(MyGraph<Vertex<V>> graph, Vertex<V> current) {
        marked.add(current);
        count++;
        for (Vertex<V> v : graph.adjacencyList(current)) {
            if (!marked.contains(v)) {
                edgeTo.put(v, current);
                dfs(graph, v);
            }
        }
    }

}

