package com.java.dsa.arrays;

import java.util.Arrays;

// Time Complexity - worst case - O(n^2)
// Time Complexity - best case - O(nlogn)
public class QuickSort {

    public void quickSort(int[] a, int lowerBound, int upperBound) {

        if (lowerBound < upperBound) {
            int pivotIndex = partition(a, lowerBound, upperBound);
            quickSort(a, lowerBound, pivotIndex-1);
            quickSort(a, pivotIndex+1, upperBound);
        }
    }

    private int partition(int[] a, int lowerBound, int upperBound) {
        int pivot = a[lowerBound];
        int start = lowerBound;
        int end = upperBound;

        while (start < end) {

            while (start <= upperBound && a[start] <= pivot) {
                start++;
            }

            while (end >= lowerBound && a[end] > pivot) {
                end--;
            }

            if (start < end) {
                int tmp = a[start];
                a[start] = a[end];
                a[end] = tmp;
            }
        }

        int tmp = a[end];
        a[end] = a[lowerBound];
        a[lowerBound] = tmp;
        return end;
    }

    public void printArray(int[] a) {
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {

        int[] a = {7, 6, 10, 5, 9, 2, 1, 15, 7};

        QuickSort qSort = new QuickSort();
        qSort.quickSort(a, 0, 8);
        qSort.printArray(a);
    }
}
