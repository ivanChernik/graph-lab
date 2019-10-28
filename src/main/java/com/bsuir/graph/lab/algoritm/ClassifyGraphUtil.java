package com.bsuir.graph.lab.algoritm;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.traverse.DepthFirstIterator;
import org.jgrapht.traverse.GraphIterator;

import java.util.HashSet;
import java.util.Set;

import static org.apache.commons.collections.CollectionUtils.isEmpty;

public class ClassifyGraphUtil {
    private ClassifyGraphUtil() {
    }

    public static void checkIfGraphIsConnected(Graph<Integer, DefaultEdge> graph) {
        System.out.println("-------------");

        Set<Integer> vertexes = graph.vertexSet();

        Set<Integer> visitedVertexes = dfs(graph, vertexes.iterator().next());

        //System.out.println("Visited Vertexes - " + visitedVertexes);
        System.out.println("Is graph connected ? - " + (vertexes.containsAll(visitedVertexes) && visitedVertexes.containsAll(vertexes)));
    }


    public static void graphNumericalCharacteristics(Graph<Integer, DefaultEdge> graph) {
        System.out.println("-------------");
        System.out.println("Amount of edges - " + graph.edgeSet().size());
        System.out.println("Amount of vertexes - " + graph.vertexSet().size());
    }

    public static void checkIfGraphIsEmpty(Graph<Integer, DefaultEdge> graph) {
        System.out.println("Is graph empty ? - " + isEmpty(graph.edgeSet()));
    }

    public static void checkIfGraphIsComplete(Graph<Integer, DefaultEdge> graph) {
        //System.out.println("-------------");
        final int edgeAmount = graph.edgeSet().size();

        final int vertexAmount = graph.vertexSet().size();

        int completeEdgeAmount = vertexAmount * (vertexAmount - 1) / 2;

        System.out.println("Is graph complete ? - " + (edgeAmount == completeEdgeAmount));
    }

    private static Set<Integer> dfs(Graph<Integer, DefaultEdge> graph, Integer startVertex) {
        final Set<Integer> visitedVertexes = new HashSet<Integer>();

        final GraphIterator<Integer, DefaultEdge> iterator =
                new DepthFirstIterator<Integer, DefaultEdge>(graph, startVertex);

        while (iterator.hasNext()) {
            final Integer vertex = iterator.next();
            visitedVertexes.add(vertex);
        }

        return visitedVertexes;
    }
}
