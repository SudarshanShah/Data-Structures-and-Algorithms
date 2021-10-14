package com.java.dsa.graphs;

import java.util.*;

public class AdjacencyMatrixGraph {

    private final int[][] vertices;
    private static final Scanner SCANNER = new Scanner(System.in);

    public AdjacencyMatrixGraph(int v) {

        vertices = new int[v][v];
        for (int[] r : vertices) {
            Arrays.fill(r, -1);
        }
    }

    public void createGraph() {

        for (int i = 0; i < vertices.length; i++) {
            for (int j = 0; j < vertices.length; j++) {
                if (vertices[i][j] == -1) {
                    System.out.println("Enter 1 if connected or 0 if not connected ");
                    System.out.println("Enter value for ("+i+", "+j+")");
                    vertices[i][j] = SCANNER.nextInt();
                    vertices[j][i] = vertices[i][j];
                }
            }
        }
    }

    public void printGraph() {

        for (int[] vertex : vertices) {
            for (int j = 0; j < vertices.length; j++) {
                System.out.print(vertex[j] + " ");
            }
            System.out.println();
        }
    }

    public void bfsTraversal() {

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < vertices.length; i++) {
            if (!visited.contains(i+1)) {
                queue.offer(i+1);
                visited.add(i+1);
            }
            for (int j = 0; j < vertices.length; j++) {
                if (vertices[i][j] == 1 && !visited.contains(j+1)) {
                    queue.offer(j+1);
                    visited.add(j+1);
                }
            }
        }

        visited = null;
        System.out.println(queue);
        queue = null;
    }

    public void dfsTraversal() {

        boolean isAllVisited = false;

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        Set<Integer> visited = new HashSet<>();
        visited.add(1);

        System.out.print(stack.peek() + " ");

        for (int i = 0; i < vertices.length; i++) {
            for (int j = 0; j < vertices.length; j++) {
                if (vertices[i][j] == 1 && !visited.contains(j+1)) {
                    stack.push(j+1);
                    visited.add(j+1);
                    System.out.print(stack.peek() + " ");
                    i = j - 1;
                    isAllVisited = true;
                    break;
                }
            }

            if (!isAllVisited && !stack.isEmpty()) {
                stack.pop();
                if (!stack.isEmpty()) {
                    i = stack.peek() - 1;
                }
            }

            isAllVisited = false;

            if (stack.size() == vertices.length) {
                break;
            }
        }
    }

    public static void main(String[] args) {

        AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph(5);

        graph.createGraph();

        graph.printGraph();

        System.out.println("BFS Traversal is : ");
        graph.bfsTraversal();

        System.out.println("DFS Traversal is : ");
        graph.dfsTraversal();
    }
}
