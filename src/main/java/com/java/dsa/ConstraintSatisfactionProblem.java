package com.java.dsa;

import java.util.*;

public class ConstraintSatisfactionProblem {

    public static void main(String[] args) {

        ConstraintGraph constraintGraph = new ConstraintGraph();

        constraintGraph.createGraph("Raj", List.of("Guj", "MP", "PJ", "HR", "UP"), "Yellow");
        constraintGraph.createGraph("Guj", List.of("Raj", "MH", "MP"), "Green");
        constraintGraph.createGraph("MP", List.of("Raj", "Guj", "MH", "CH", "UP"), "Red");
        constraintGraph.createGraph("UP", List.of("Raj", "MP", "UK", "BH", "HP", "HR"), "Orange");
        constraintGraph.createGraph("JK", List.of("HP", "PJ"), "Yellow");
        constraintGraph.createGraph("PJ", List.of("Raj", "HR", "HP", "JK"), "Red");
        constraintGraph.createGraph("HR", List.of("Raj", "PJ", "HP", "UP"), "Green");
        constraintGraph.createGraph("HP", List.of("JK", "HR", "PJ", "UP"), "Orange");
        constraintGraph.createGraph("UK", List.of( "UP"), "Yellow");
        constraintGraph.createGraph("BH", List.of("SK", "AS", "JH", "WB", "UP"), "Red");
        constraintGraph.createGraph("AS", List.of("BH", "SK", "MG", "WB", "ARP", "ND", "TR", "MG", "MZ", "MR"), "Red");
        constraintGraph.createGraph("MG", List.of("AS"), "Green");
        constraintGraph.createGraph("ARP", List.of("AS", "NG"), "Orange");
        constraintGraph.createGraph("ND", List.of("AS", "ARP", "MR"), "Green");
        constraintGraph.createGraph("MZ", List.of("AS", "TR", "MR"), "Orange");
        constraintGraph.createGraph("MR", List.of("AS", "ND", "MZ"), "Yellow");
        constraintGraph.createGraph("TR", List.of("AS", "MZ"), "Yellow");
        constraintGraph.createGraph("JH", List.of("BH", "WB", "OR", "CH", "UP"), "Yellow");
        constraintGraph.createGraph("CH", List.of("MP", "JH", "OR", "MH", "AP"), "Green");
        constraintGraph.createGraph("WB", List.of("BH", "JH", "OR", "AS", "SK"), "Green");
        constraintGraph.createGraph("SK", List.of("BH", "AS", "WB"), "Orange");
        constraintGraph.createGraph("OR", List.of("WB", "JH", "AP", "CH"), "Orange");
        constraintGraph.createGraph("MH", List.of("Goa", "Guj", "MP", "AP", "KT"), "Orange");
        constraintGraph.createGraph("Goa", List.of("MH", "KT"), "Red");
        constraintGraph.createGraph("KT", List.of("MH", "AP", "Goa", "KR", "TN"), "Yellow");
        constraintGraph.createGraph("AP", List.of("TN", "KT", "MH", "CH", "OR"), "Red");
        constraintGraph.createGraph("TN", List.of("KT", "KR", "AP"), "Green");
        constraintGraph.createGraph("KR", List.of("KT", "TN"), "Red");

        constraintGraph.printGraph();

//        System.out.println(constraintGraph.isNeighbour("Raj", "PJ"));
//
//        System.out.println(constraintGraph.getNeighbours("Raj"));
//
//        System.out.println(constraintGraph.getStateCompleteInformation("Guj"));
    }
}

class ConstraintGraph {

    // Map contains Key as state and value as another map with List of neighbours and key state's color
    Map<String, Map<List<String>, String>> graph;

    // initializing 'graph' through constructor
    ConstraintGraph() {
        graph = new HashMap<>(28);
    }

    // Creating Constraint Graph
    public void createGraph(String state, List<String> neighbours, String color) {
        Map<List<String>, String> valueMap = new HashMap<>();
        valueMap.put(neighbours, color);
        graph.put(state, valueMap);
        valueMap = null;
    }

    // Checking if 2 states are neighbours or not
    public boolean isNeighbour(String state1, String state2) {
        boolean flag = false;
        List<String> neighbours = getNeighbours(state1);
        if (neighbours.contains(state2)) {
            flag = true;
        }

        return flag;
    }

    // getting all neighbours of given State
    public List<String> getNeighbours(String state) {

        List<String> list = null;
        for (Map.Entry<String, Map<List<String>, String>> entry : graph.entrySet()) {
                Map<List<String>, String> map = graph.get(state);
                for (Map.Entry<List<String>, String> e : map.entrySet()) {
                    // get list of neighbours
                     list = e.getKey();
                     break;
                }
                break;
        }

        return list;
    }

    public Map<String, String> getStateCompleteInformation(String state) {

        // getting list of neighbours from 'getNeighbours' method
        List<String> neighbours = getNeighbours(state);

        // map to store information of state and its neighbours, along with their respective colors.
        Map<String, String> stateInfo = new HashMap<>();

        // if list of neighbours is empty, an empty map is returned.
        if (neighbours == null) {
            System.out.println("Invalid Input!");
            return stateInfo;
        }

        Map<List<String>, String> map = null;
        for (Map.Entry<String, Map<List<String>, String>> entry : graph.entrySet()) {
            // If key is equal to given State
            if (entry.getKey().equals(state)) {
                map = graph.get(entry.getKey());
                String color = map.get(neighbours);
                stateInfo.put(entry.getKey(), color);
            }
            // If Key is one of the neighbours of the given State
            else if (neighbours.contains(entry.getKey())) {
                map = graph.get(entry.getKey());
                Set<List<String>> set = map.keySet();
                Object[] obj = set.toArray();
                String color = map.get(obj[0]);
                stateInfo.put(entry.getKey(), color);
            }
        }

        return stateInfo;
    }

    // Method to print Constraint graph
    public void printGraph() {

        for (Map.Entry<String, Map<List<String>, String>> entry : graph.entrySet()) {
            for (Map.Entry<List<String>, String> e : entry.getValue().entrySet()) {
                System.out.println(entry.getKey() + " neighbours => " + e.getKey() +  " & color =>" + e.getValue());
            }
        }
    }
}