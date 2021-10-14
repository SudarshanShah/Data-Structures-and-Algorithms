package com.java.dsa.trees;

import java.util.Scanner;

public class BinarySearchTree {

    private static final Scanner SCANNER  = new Scanner(System.in);
    Node root;

    private class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public void createBST(int data) {
        root = createBinarySearchTree(root, data);
    }

    private Node createBinarySearchTree(Node node, int data) {

        if (node == null) {
            return new Node(data);
        }

        if (data < node.data) {
            node.left = createBinarySearchTree(node.left, data);
        }
        else {
            node.right = createBinarySearchTree(node.right, data);
        }

        return node;
    }

    public void createBSTV2(int data) {

        Node node  = new Node(data);

        if (root == null) {
            root = node;
            return;
        }

        Node parent = null;
        Node current = root;

        while (current != null) {
            parent = current;

            if (current.data > data) {
                current = current.left;
            }
            else {
                current = current.right;
            }
        }

        if (parent.data > data) {
            parent.left = node;
        }
        else {
            parent.right = node;
        }
    }

    public void inOrder() {
        inOrderTraversal(root);
    }

    public void preOrder() {
        preOrderTraversal(root);
    }

    public boolean search(int data) {
        return searchElement(root, data);
    }

    private boolean searchElement(Node node, int data) {

        if (node == null) {
            return false;
        }

        if (node.data == data) {
            return true;
        }

        if (node.data <= data) {
            return searchElement(node.right, data);
        }

        else {
            return searchElement(node.left, data);
        }
    }

    private void inOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.left);
        System.out.print(node.data + " ");
        inOrderTraversal(node.right);
    }

    private void preOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");
        inOrderTraversal(node.left);
        inOrderTraversal(node.right);
    }

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();

        bst.createBST(11);
        bst.createBST(6);
        bst.createBST(19);
        bst.createBST(5);
        bst.createBST(4);
        bst.createBST(10);
        bst.createBST(31);
        bst.createBST(60);
        bst.createBST(17);

        bst.preOrder();

        System.out.println();

        bst.createBSTV2(88);
        bst.createBSTV2(16);

        bst.preOrder();

        System.out.println();

        System.out.println( bst.search(5));
    }
}
