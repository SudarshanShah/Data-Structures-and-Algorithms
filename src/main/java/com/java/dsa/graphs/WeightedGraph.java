package com.java.dsa.graphs;

import java.util.HashSet;
import java.util.Set;

public class WeightedGraph<T> {

    int[] vertices;
    int[][] graph;

    public WeightedGraph(int vertexCount) {
        vertices = new int[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            vertices[i] = i;
        }
        graph = new int[vertices.length][vertices.length];
    }

    public void addEdge(int source, int destination, int sourceToDestinationWeight, int destinationToSourceWeight) {
        graph[source][destination] = sourceToDestinationWeight;
        graph[destination][source] = destinationToSourceWeight;
    }

    public Set<Integer> verticesSet() {

        Set<Integer> set = new HashSet<>();
        for (Integer i : vertices) {
            set.add(i);
        }

        return set;
    }

    public int getWeight(int source, int destination) {
        return graph[source][destination];
    }

    public void printGraph() {
        for (int[] arr : graph) {
            for (Integer i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        WeightedGraph graph = new WeightedGraph(4);

        graph.addEdge(0, 1, 16, 8);
        graph.addEdge(0, 2, 11, 4);
        graph.addEdge(0, 3, 6, 5);
        graph.addEdge(1, 0, 8, 16);
        graph.addEdge(1, 2, 13, 7);
        graph.addEdge(1, 3, 16, 12);
        graph.addEdge(2, 0, 4, 11);
        graph.addEdge(2, 1, 7, 13);
        graph.addEdge(2, 3, 9, 2);
        graph.addEdge(3, 0, 5, 6);
        graph.addEdge(3, 1, 12, 16);
        graph.addEdge(3, 2, 2, 9);

        graph.printGraph();
    }
}
