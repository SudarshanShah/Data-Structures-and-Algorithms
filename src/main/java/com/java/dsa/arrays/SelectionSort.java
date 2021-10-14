package com.java.dsa.arrays;

public class SelectionSort {

    public int[] sortArray(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int index = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[index];
            arr[index] = tmp;
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {32, 67, 43, 12, 50, 66, 98, 77, 38, 45, 10, 0, 100, 25, 1, 6};

        System.out.println("UnSorted Array : ");
        for (int j : arr) {
            System.out.print(j + " ");
        }

        SelectionSort sSort = new SelectionSort();
        arr = sSort.sortArray(arr);

        System.out.println();

        System.out.println("Sorted Array : ");
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}
