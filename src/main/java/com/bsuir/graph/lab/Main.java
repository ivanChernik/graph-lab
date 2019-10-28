package com.bsuir.graph.lab;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.GraphDelegator;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.traverse.DepthFirstIterator;
import org.jgrapht.traverse.GraphIterator;

import java.util.*;

import static com.bsuir.graph.lab.ClassifyGraphUtil.*;
import static java.util.Arrays.asList;
import static org.apache.commons.collections.CollectionUtils.isEmpty;

public class Main {
    public static void main(String[] args) {

        Graph<Integer, DefaultEdge> graph = new SimpleGraph<Integer, DefaultEdge>(DefaultEdge.class);
        graph.addVertex(1);
        graph.addVertex(2);
//        graph.addVertex(3);
//        graph.addVertex(4);
        graph.addEdge(1, 2);
//        graph.addEdge(1, 3);
//        graph.addEdge(2, 3);
        //graph.addEdge(3, 4);

//        graphNumericalCharacteristics(graph);
//        checkIfGraphIsConnected(graph);
//        checkIfGraphIsEmpty(graph);
//        checkIfGraphIsComplete(graph);

    }

}
