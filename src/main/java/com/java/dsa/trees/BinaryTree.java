package com.java.dsa.trees;

import java.util.Scanner;

public class BinaryTree {

    Node root = null;
    int count = 0;
    private static final Scanner SCANNER = new Scanner(System.in);

    private static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public void createBinaryTree() {
        root = create(root);
    }

    private Node create(Node node) {

        System.out.println("Enter the data : ");
        int data = SCANNER.nextInt();
        if (data == -1) {
            return node;
        }
        node = new Node(data);

        System.out.println("Enter left for : " + data);
        node.left = create(node.left);

        System.out.println("Enter right for : " + data);
        node.right = create(node.right);

        return node;
    }

    public void preOrder() {
        preOrderTraversal(root);
    }

    public void inOrder() {
        inOrderTraversal(root);
    }

    public void postOrder() {
        postOrderTraversal(root);
    }

    public int countLeafNodes() {
        getLeafNodesCount(root);
        return count;
    }

    public int getHeight() {
        return calcHeight(root);
    }

    public boolean isSameTree(Node node1, Node node2) {

        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 == null || node2 == null) {
            return false;
        }

        return node1.data == node2.data && isSameTree(node1.left, node2.left) && isSameTree(node1.right, node2.right);

    }

    private int calcHeight(Node node) {
        if (node == null) {
            return -1;
        }

        int left_depth = calcHeight(node.left);
        int right_depth = calcHeight(node.right);

        if (left_depth > right_depth) {
            return left_depth + 1;
        }
        else return right_depth + 1;
    }

    private void getLeafNodesCount(Node node) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            count++;
        }

        getLeafNodesCount(node.left);
        getLeafNodesCount(node.right);
    }

    private void preOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    private void inOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.left);
        System.out.print(node.data + " ");
        inOrderTraversal(node.right);
    }

    private void postOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.createBinaryTree();

        binaryTree.preOrder();
        System.out.println();

        binaryTree.inOrder();
        System.out.println();

        binaryTree.postOrder();

        System.out.println("\nNo. of leaf nodes in binary tree are : " + binaryTree.countLeafNodes());

        System.out.println("\nHeight of tree is : " + binaryTree.getHeight());
    }
}
