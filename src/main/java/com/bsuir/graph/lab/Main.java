package com.bsuir.graph.lab;

import org.jgrapht.Graph;

import static com.bsuir.graph.lab.algoritm.BiconnectedComponents.findBiconnectedComponents;
import static com.bsuir.graph.lab.algoritm.BridgeUtil.bridge;
import static com.bsuir.graph.lab.algoritm.ChordalGraphUtil.findChords;
import static com.bsuir.graph.lab.algoritm.ClassifyGraphUtil.*;
import static com.bsuir.graph.lab.examples.ExamplesUtil.*;

public class Main {
    public static void main(String[] args) {

        Graph graph = getUnconnectedGraph();

        graphNumericalCharacteristics(graph);
        checkIfGraphIsConnected(graph);
        checkIfGraphIsEmpty(graph);
        checkIfGraphIsComplete(graph);


        bridge(getBridgeGraph3());
        findBiconnectedComponents(getBccGraph());
        findChords(getChordalGraph2());

    }

}
