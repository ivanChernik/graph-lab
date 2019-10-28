package com.bsuir.graph.lab;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.GraphDelegator;
import org.jgrapht.graph.SimpleGraph;

import java.util.Set;

public class BridgeUtil {
    private BridgeUtil() {
    }

    private static int time = 0;

    private static void dfsAndFindBridges(int currentVertex, boolean visited[], int discoveryTime[],
                                          int lowValue[], int parent, GraphDelegator graphDelegator) {

        // Mark the current node as visited
        visited[currentVertex] = true;

        // Initialize discovery time and low value
        discoveryTime[currentVertex] = lowValue[currentVertex] = time++;

        // Go through all vertices adjacent to this
        final Set<DefaultEdge> edges = graphDelegator.edgesOf(currentVertex);

        for (DefaultEdge defaultEdge : edges) {
            int targetVertex = getTargetVertex(currentVertex, defaultEdge, graphDelegator);

            if (targetVertex == parent) continue;

            if (visited[targetVertex]) {
                lowValue[currentVertex] = Math.min(lowValue[currentVertex], discoveryTime[targetVertex]);
            } else {
                dfsAndFindBridges(targetVertex, visited, discoveryTime, lowValue, currentVertex, graphDelegator);
                lowValue[currentVertex] = Math.min(lowValue[currentVertex], lowValue[targetVertex]);
                if (lowValue[targetVertex] > discoveryTime[currentVertex]) {
                    System.out.println("Bridges in graph");
                    System.out.println(currentVertex + " " + targetVertex);
                }
            }
        }
    }

    private static int getTargetVertex(int sourceVertex, DefaultEdge defaultEdge, GraphDelegator graphDelegator) {
        int targetVertex = (Integer) graphDelegator.getEdgeTarget(defaultEdge);

        if (targetVertex == sourceVertex) {
            targetVertex = (Integer) graphDelegator.getEdgeSource(defaultEdge);
        }

        return targetVertex;
    }

    private static void bridge(final Graph graph) {

        time = 0;

        GraphDelegator graphDelegator = new GraphDelegator(graph);

        Set<Integer> vertexSet = graph.vertexSet();
        final int vertexAmount = vertexSet.size();

        // Mark all the vertices as not visited
        boolean visited[] = new boolean[vertexAmount];
        int discoveryTime[] = new int[vertexAmount];
        int lowValue[] = new int[vertexAmount];

        for (int i = 0; i < vertexAmount; i++) {
            visited[i] = false;
        }

        for (final Integer vertex : vertexSet)
            if (!visited[vertex])
                dfsAndFindBridges(vertex, visited, discoveryTime, lowValue, -1, graphDelegator);
    }

    public static void main(String[] args) {

        Graph<Integer, DefaultEdge> graph = new SimpleGraph<Integer, DefaultEdge>(DefaultEdge.class);
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(0, 3);
        graph.addEdge(4, 3);

//        Graph<Integer, DefaultEdge> graph = new SimpleGraph<Integer, DefaultEdge>(DefaultEdge.class);
//        graph.addVertex(0);
//        graph.addVertex(1);
//        graph.addVertex(2);
//        graph.addVertex(3);
//        graph.addVertex(4);
//        graph.addVertex(5);
//        graph.addVertex(6);
//
//        graph.addEdge(0, 1);
//        graph.addEdge(0, 2);
//        graph.addEdge(1, 2);
//        graph.addEdge(1, 6);
//        graph.addEdge(1, 3);
//        graph.addEdge(1, 4);
//        graph.addEdge(3, 5);
//        graph.addEdge(4, 5);

        bridge(graph);
    }
}
