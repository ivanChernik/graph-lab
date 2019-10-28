package com.bsuir.graph.lab.examples;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

public class ExamplesUtil {
    private ExamplesUtil() {
    }

    public static Graph getBccGraph() {
        Graph graph = new SimpleGraph<Integer, DefaultEdge>(DefaultEdge.class);

        for (int i = 0; i < 12; i++) {
            graph.addVertex(i);
        }

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(1, 5);
        graph.addEdge(0, 6);
        graph.addEdge(5, 6);
        graph.addEdge(5, 7);
        graph.addEdge(5, 8);
        graph.addEdge(7, 8);
        graph.addEdge(8, 9);
        graph.addEdge(10, 11);

        return graph;
    }

    public static Graph getBridgeGraph() {

        Graph graph = new SimpleGraph<Integer, DefaultEdge>(DefaultEdge.class);

        for (int i = 0; i < 5; i++) {
            graph.addVertex(i);
        }

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(0, 3);
        graph.addEdge(4, 3);

        return graph;
    }

    public static Graph getChordalGraph() {

        Graph graph = new SimpleGraph<Integer, DefaultEdge>(DefaultEdge.class);

        for (int i = 0; i < 5; i++) {
            graph.addVertex(i);
        }

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 0);
        graph.addEdge(1, 4);
        graph.addEdge(1, 3);

        return graph;
    }

    public static Graph getCompleteGraph() {
        Graph graph = new SimpleGraph<Integer, DefaultEdge>(DefaultEdge.class);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        return graph;
    }

    public static Graph getEmptyGraph() {
        Graph graph = new SimpleGraph<Integer, DefaultEdge>(DefaultEdge.class);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        return graph;
    }

    public static Graph getConnectedGraph() {
        Graph graph = new SimpleGraph<Integer, DefaultEdge>(DefaultEdge.class);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        return graph;
    }

    public static Graph getUnconnectedGraph() {
        Graph graph = new SimpleGraph<Integer, DefaultEdge>(DefaultEdge.class);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);

        return graph;
    }
}
