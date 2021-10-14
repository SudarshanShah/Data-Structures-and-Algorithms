package com.java.dsa.arrays;

import java.util.Arrays;

public class BubbleSort {

    // simple bubble sort with time complexity of O(n^2)
    // n = length of the array
    public int[] sortArray(int[] arr) {

        boolean swapped = false;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    swapped =true;
                }
            }

            if (swapped == false) {
                break;
            }
        }

        return arr;
    }

    public static void main(String[] args) {

        int[] arr = {32, 67, 43, 12, 50, 66, 98, 77, 38, 45, 10, 0, 100, 25, 1, 6};

        System.out.println("UnSorted Array : ");
        System.out.print("[");
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println("]");

        BubbleSort bSort = new BubbleSort();
        arr = bSort.sortArray(arr);

        System.out.println();

        System.out.println("Sorted Array : ");
        System.out.println(Arrays.toString(arr));
    }
}
