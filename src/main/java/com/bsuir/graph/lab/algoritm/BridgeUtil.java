package com.bsuir.graph.lab.algoritm;

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

    public static void bridge(final Graph graph) {

        System.out.println("-------------");

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
}
