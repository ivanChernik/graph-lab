package com.bsuir.graph.lab.algoritm;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.GraphDelegator;

import java.util.LinkedList;
import java.util.Set;

public class BiconnectedComponents {

    // Count is number of biconnected components. time is
    // used to find discovery times
    private static int count = 0, time = 0;

    private static int NOT_VISITED = -1;

    public static void findBiconnectedComponents(final Graph<Integer, DefaultEdge> graph) {
        System.out.println("-------------");
        System.out.println("Biconnected components in graph");

        GraphDelegator<Integer, DefaultEdge> graphDelegator = new GraphDelegator<Integer, DefaultEdge>(graph);

        count = 0;
        time = 0;

        Set<Integer> vertexes = graph.vertexSet();
        final int vertexCount = vertexes.size();

        int discoveryTime[] = new int[vertexCount];
        int low[] = new int[vertexCount];

        LinkedList<DefaultEdge> visitedEdges = new LinkedList<DefaultEdge>();

        for (int vertex : vertexes) {
            discoveryTime[vertex] = NOT_VISITED;
            low[vertex] = NOT_VISITED;
        }

        for (int currentVertex : vertexes) {
            if (discoveryTime[currentVertex] == NOT_VISITED) {
                dfsAndBcc(currentVertex, discoveryTime, low, visitedEdges, NOT_VISITED, graphDelegator);
            }

            int j = 0;

            // If stack is not empty, pop all edges from stack
            while (visitedEdges.size() > 0) {
                j = 1;
                System.out.print(visitedEdges.getLast());
                visitedEdges.removeLast();
            }
            if (j == 1) {
                System.out.println();
                count++;
            }
        }

        System.out.println("Above are " + count + " biconnected components in graph");
    }

    // A recursive function that finds and prints strongly connected
    // components using DFS traversal
    // u --> The vertex to be visited next
    // disc[] --> Stores discovery times of visited vertices
    // low[] -- >> earliest visited vertex (the vertex with minimum
    // discovery time) that can be reached from subtree
    // rooted with current vertex
    // *st -- >> To store visited edges
    private static void dfsAndBcc(int currentVertex, int discoveryTime[], int low[],
            LinkedList<DefaultEdge> visitedEdges, int parentVertex,
            GraphDelegator<Integer, DefaultEdge> graphDelegator) {

        // Initialize discovery time and low value
        discoveryTime[currentVertex] = low[currentVertex] = ++time;
        int childrenCount = 0;

        // Go through all vertices adjacent to this
        for (DefaultEdge currentEdge : graphDelegator.edgesOf(currentVertex)) {

            int targetVertex =
                    getTargetVertex(currentVertex, currentEdge, graphDelegator); // v is current adjacent of 'u'

            // If v is not visited yet, then recur for it
            if (discoveryTime[targetVertex] == NOT_VISITED) {
                childrenCount++;
                parentVertex = currentVertex;

                // store the edge in stack
                visitedEdges.add(currentEdge);
                dfsAndBcc(targetVertex, discoveryTime, low, visitedEdges, parentVertex, graphDelegator);

                // Check if the subtree rooted with 'v' has a
                // connection to one of the ancestors of 'u'
                // Case 1 -- per Strongly Connected Components Article
                if (low[currentVertex] > low[targetVertex])
                    low[currentVertex] = low[targetVertex];

                // If u is an articulation point,
                // pop all edges from stack till u -- v
                if ((discoveryTime[currentVertex] == 1 && childrenCount > 1) || (discoveryTime[currentVertex] > 1
                        && low[targetVertex] >= discoveryTime[currentVertex])) {

                    while (!visitedEdges.getLast().equals(currentEdge)) {
                        System.out.print(visitedEdges.getLast());
                        visitedEdges.removeLast();
                    }

                    System.out.println(visitedEdges.getLast());
                    visitedEdges.removeLast();

                    count++;
                }
            }

            // Update low value of 'u' only if 'v' is still in stack
            // (i.e. it's a back edge, not cross edge).
            // Case 2 -- per Strongly Connected Components Article
            else if (targetVertex != parentVertex && discoveryTime[targetVertex] < discoveryTime[currentVertex]) {
                if (low[currentVertex] > discoveryTime[targetVertex])
                    low[currentVertex] = discoveryTime[targetVertex];

                visitedEdges.add(currentEdge);
            }
        }
    }

    private static int getTargetVertex(int sourceVertex, DefaultEdge edge,
            GraphDelegator<Integer, DefaultEdge> graphDelegator) {
        if (sourceVertex == graphDelegator.getEdgeSource(edge)) {
            return graphDelegator.getEdgeTarget(edge);
        } else {
            return graphDelegator.getEdgeSource(edge);
        }

    }
}