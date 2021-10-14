package com.java.dsa.graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

// Alternative Approach of Constructing Graph
public class Graph {

    private Map<Integer, LinkedList<Integer>> graph = new HashMap<>();
    private static final Scanner SCANNER = new Scanner(System.in);

    public void createGraph(int vertex1, int vertex2) {

        LinkedList<Integer> list;

        if (!graph.containsKey(vertex1)) {
            list = new LinkedList<>();
            list.add(vertex2);
            graph.put(vertex1, list);
        }
        else  {
            if (graph.get(vertex1) == null) {
                list = new LinkedList<>();
                list.add(vertex2);
                graph.put(vertex1, list);
            }
            else {
                list = graph.get(vertex1);
                list.add(vertex2);
            }
        }
//----------------------------------------------------------//
        if (!graph.containsKey(vertex2)) {
            list = new LinkedList<>();
            list.add(vertex1);
            graph.put(vertex2, list);
        }
        else  {
            if (graph.get(vertex2) == null) {
                list = new LinkedList<>();
                list.add(vertex1);
                graph.put(vertex2, list);
            }
            else {
                list = graph.get(vertex2);
                list.add(vertex1);
            }
        }
    }

    public void printGraph() {

        System.out.println("Graph is : ");
        for (Map.Entry<Integer, LinkedList<Integer>> map : graph.entrySet()) {
            System.out.println(map.getKey() + " -> " + map.getValue());
        }
    }

    public static void main(String[] args) {

        Graph graph = new Graph();

        graph.createGraph(1, 2);
        graph.createGraph(1, 4);
        graph.createGraph(2, 3);
        graph.createGraph(2, 4);
        graph.createGraph(3, 5);
        graph.createGraph(4, 5);

        graph.printGraph();
    }
}
