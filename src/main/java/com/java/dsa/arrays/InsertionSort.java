package com.java.dsa.arrays;

import java.util.Arrays;

public class InsertionSort {

    public int[] sortArray(int[] arr) {

        // iterate from index 1 to n-1
        for (int i = 1; i < arr.length; i++) {
            // select the key from unsorted array
            int key = arr[i];
            // traverse through sorted array in reverse direction
            for (int j = i-1; j >= 0; j--) {
                // Till the key is less than its previous element,
                // shift that element to the next position
                if (key < arr[j]) {
                    arr[j+1] = arr[j];
                    arr[j] = key;
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {

        int[] arr = {32, 67, 43, 12, 50, 66, 98, 77, 38, 45, 10, 0, 100, 25, 1, 6};

        System.out.println("UnSorted Array : ");
        for (int j : arr) {
            System.out.print(j + " ");
        }

        InsertionSort iSort = new InsertionSort();
        arr = iSort.sortArray(arr);

        System.out.println();

        System.out.println("Sorted Array : ");
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}
