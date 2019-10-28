package com.bsuir.graph.lab.algoritm;

import org.jgrapht.Graph;
import org.jgrapht.alg.cycle.ChordalGraphMinimalVertexSeparatorFinder;

public class ChordalGraphUtil {

    public static void findChords(final Graph graph) {
        ChordalGraphMinimalVertexSeparatorFinder graphMinimalVertexSeparatorFinder =
                new ChordalGraphMinimalVertexSeparatorFinder(graph);

        System.out.println("-------------");
        System.out.println("Chords " + graphMinimalVertexSeparatorFinder.getMinimalSeparators());
    }
}
