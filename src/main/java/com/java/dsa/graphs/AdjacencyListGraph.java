package com.java.dsa.graphs;

import java.util.*;
import java.util.stream.Collectors;

public class AdjacencyListGraph {

    // Array consisting of vertices of Graph
    private int[] vertices;
    // Linked List consisting of adjacent vertices to a vertex
    private LinkedList<LinkedList<Integer>> connections;
    // Input class object
    private static final Scanner SCANNER = new Scanner(System.in);

    // Initializing vertices array and linked list through constructor
    public AdjacencyListGraph() {

        System.out.println("How many vertices graph has ?");
        int v = SCANNER.nextInt();
        vertices = new int[v];
        connections = new LinkedList<>();
    }

    public void createGraph() {

        // Map for storing vertices that are not adjacent to a given vertex
        Map<Integer, ArrayList<Integer>> disconnected = new HashMap<>();
        // ArrayList for storing non-neighbour vertices in Map
        ArrayList<Integer> ar;

        System.out.println("Enter the vertices of graph : ");

        // Loop to get distinct vertices into array and adding empty list to Linked List for storing adjacent vertices
        for (int i = 0; i < vertices.length; i++) {
            int vertex = SCANNER.nextInt();
            vertices[i] = vertex;
            LinkedList<Integer> connection = new LinkedList<>();
            connections.add(connection);
        }

        // To get input about whether a particular vertex is connected with another vertex or not
        for (int i = 0; i < vertices.length ; i++) {
            for (int j = 0; j < vertices.length; j++) {
                // connection with self is restricted
                if (vertices[i] == vertices[j]) {
                    continue;
                }
                // this linked list has neighbours
                LinkedList<Integer> neighbour = connections.get(i);
                // this array list has non-neighbours
                ar = disconnected.get(j);

                /*
                * check if an adjacent vertex is present in list or not
                * check if non-adjacent vertex is present in list or not
                * if both conditions are satisfied, then those 2 vertices accordingly,
                * so to remove redundancy during input
                * */
                if (!neighbour.contains(vertices[j]) && (ar == null || !ar.contains(vertices[i]))) {
                    System.out.println("Enter 1 if connected or 0 if not connected ");
                    System.out.println("Is ("+vertices[i]+") connected with ("+vertices[j]+")");
                    int connect = SCANNER.nextInt();
                    if (connect == 1) {
                        // making 'j' as neighbour of 'i'
                        neighbour.add(vertices[j]);
                        // getting list of adjacent vertices to 'j'.
                        neighbour = connections.get(j);
                        // making 'i' as neighbour of 'j'
                        neighbour.add(vertices[i]);
                    }
                    else {
                        // check if map contains key
                        if (disconnected.containsKey(vertices[i])) {
                            // get value (of type List) for corresponding key
                            ar = disconnected.get(vertices[i]);
                            // add non-adjacent vertex
                            ar.add(vertices[j]);
                        }
                        else {
                            // create new ArrayList if expected key not exists
                            ar = new ArrayList<>();
                            // add non-adjacent vertex to ArrayList
                            ar.add(vertices[j]);
                            // add key vertex and value in map
                            disconnected.put(vertices[i], ar);
                        }
                    }
                }
                neighbour = null;
            }
        }

        // set declared collection to null for garbage collection, as they are no more required
        disconnected = null;
        ar = null;
    }

    public void printGraph() {

        int i = 0;
        for (LinkedList<Integer> list : connections) {
            System.out.print(vertices[i] + " -> " + list);
            i++;
            System.out.println();
        }
    }

    public void bfsTraversal() {

        // queue for maintaining BFS traversal order
        Queue<Integer> queue = new LinkedList<>();
        // set for keeping track of visited vertices, so to avoid repetition in queue
        Set<Integer> visited = new HashSet<>();

        int i = 0;
        // traversing the Linked List of all Lists of adjacent vertices of each vertex
        for (LinkedList<Integer> neighbours : connections) {
            // to add vertex to queue only once, checking whether its visited or not
            if (!visited.contains(vertices[i])) {
                queue.offer(vertices[i]);
                visited.add(vertices[i]);
            }
            // traversing Linked List of adjacent vertices to particular vertex
            for (Integer neighbour : neighbours) {
                if (!visited.contains(neighbour)) {
                    queue.offer(neighbour);
                    visited.add(neighbour);
                }
            }
            i++;
        }

        visited = null;
        // printing the BFS traversal path
        System.out.println(queue);
        queue = null;
    }

    public void dfsTraversal() {

        // variable for controlling while-loop
        boolean flag = true ;
        // variable to check if all vertices are visited
        boolean isAllVisited = false;
        // variable for index of array
        int i = 0;
        // variable for changing value of 'i' accordingly
        int store = 0;

        // Stack is used for backtracking graph, if any vertex can't be visited through loop
        Stack<Integer> stack = new Stack<>();
        // Set to keep track of vertices that are visited
        Set<Integer> visited = new HashSet<>();
        // Array of vertices converted to List for ease of operations
        List<Integer> ar = Arrays.stream(vertices).boxed().collect(Collectors.toList());

        while (flag) {
            // Checking if a vertex is visited or not
            if (!visited.contains(vertices[i])) {
                // putting visited vertex in Stack
                stack.push(vertices[i]);
                visited.add(vertices[i]);
                // getting index of vertex for accessing its List of adjacent vertices
                i = ar.indexOf(vertices[i]);
                // printing the top most stack element
                System.out.print(stack.peek() + " ");
            }
            // Accessing Linked List of adjacent vertices to the given vertex
            LinkedList<Integer> list = connections.get(i);
            for (Integer neighbour : list) {
                if (!visited.contains(neighbour)) {
                    store = neighbour;
                    stack.push(neighbour);
                    visited.add(neighbour);
                    isAllVisited = true;
                    System.out.print(stack.peek() + " ");
                    break;
                }
            }
            if (!isAllVisited && !stack.isEmpty()) {
                stack.pop();
                store = stack.peek();
            }

            isAllVisited = false;

            i = ar.indexOf(store);

            if (visited.size() == ar.size()) {
                flag = false;
            }
        }

        stack = null;
        visited = null;
        ar = null;
    }

    public static void main(String[] args) {

        AdjacencyListGraph graph = new AdjacencyListGraph();

        graph.createGraph();

        graph.printGraph();

        System.out.println("BFS Traversal is : ");
        graph.bfsTraversal();

        System.out.println("DFS Traversal is : ");
        graph.dfsTraversal();

    }
}
