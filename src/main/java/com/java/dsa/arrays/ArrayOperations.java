package com.java.dsa.arrays;

import java.util.Scanner;

public class ArrayOperations {

    int size;
    int[] arr;
    Scanner sc = new Scanner(System.in);

    public ArrayOperations() {
        System.out.println("Enter the size of array : ");
        size = sc.nextInt();

        arr = new int[size];
    }

    public void addIntoArray() {
        System.out.println("Enter the elements in  array : ");
        for (int i = 0; i < arr.length; i++) {
            int e = sc.nextInt();
            arr[i] = e;
        }
    }

    // append the given element at last position
    public void append(int i) {
        int[] a = new int[arr.length+1];
        for (int j = 0; j < a.length; j++) {
            if (j == a.length - 1) {
                a[j] = i;
            }
            else {
                a[j] = arr[j];
            }
        }
        arr = a.clone();
        a = null;
    }

    // insert element at any given position
    public void insertAt(int e, int index) {
        int[] a = new int[arr.length + 1];
        for (int i = 0, j = 0; i < a.length && j < arr.length; i++, j++) {
            if (i == index) {
                a[i] = e;
                j--;
            }
            else {
                a[i] = arr[j];
            }
        }

        arr = a.clone();
        a = null;
    }

    public void deleteElement(int e) {
        int[] a = new int[arr.length - 1];
        boolean flag = false;
        for (int i = 0, j = 0; i < a.length && j < arr.length; i++, j++) {
            if (arr[j] == e) {
                i--;
                flag = true;
            }
            else {
                a[i] = arr[j];
            }
        }

        if (flag) {
            arr = a.clone();
        }
        a = null;
    }

    public void deleteByIndex(int index) {
        if (index >= arr.length) {
            System.out.println("Please enter the valid index!");
            return;
        }
        int[] a = new int[arr.length - 1];
        boolean flag = false;
        for (int i = 0, j = 0; i < a.length && j < arr.length; i++, j++) {
            if (j == index) {
                i--;
                flag = true;
            }
            else {
                a[i] = arr[j];
            }
        }

        if (flag) {
            arr = a.clone();
        }
        a = null;
    }

    public void printArray() {
        for (Integer i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {

        ArrayOperations arrayOperations = new ArrayOperations();
        arrayOperations.addIntoArray();
        arrayOperations.printArray();

        System.out.println();

        arrayOperations.append(213);
        arrayOperations.printArray();

        System.out.println();

        arrayOperations.insertAt(9, 2);
        arrayOperations.printArray();

        System.out.println();

        arrayOperations.deleteElement(3);
        arrayOperations.printArray();

        System.out.println();

        arrayOperations.deleteByIndex(30);
        arrayOperations.printArray();
    }
}
