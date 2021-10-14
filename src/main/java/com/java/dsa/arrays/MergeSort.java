package com.java.dsa.arrays;

import java.util.Arrays;

// Time Complexity in best, average and worst case is -> O(nlogn)
public class MergeSort {

    public void mergeSort(int[] a, int lowerBound, int upperBound) {
        if (lowerBound < upperBound) {
            int mid = (lowerBound + upperBound) / 2;
            mergeSort(a, lowerBound, mid);
            mergeSort(a, mid+1, upperBound);
            merge(a, lowerBound, mid, upperBound);
        }
    }

    private void merge(int[] a, int lowerBound, int mid,  int upperBound) {
        int k = lowerBound;

        int[] left = new int[mid-lowerBound+1];
        int[] right = new int[upperBound-mid];

        for (int i = 0; i < left.length; i++) {
            left[i] = a[lowerBound+i];
        }

        for (int i = 0; i < right.length; i++) {
            right[i] = a[mid+1+i];
        }

        int i = 0;
        int j = 0;

        while (i < mid-lowerBound+1 && j < upperBound-mid) {
            if (left[i] <= right[j]) {
                a[k] = left[i];
                i++;
            } else {
                a[k] = right[j];
                j++;
            }
            k++;

        }

        while (i < mid-lowerBound+1) {
            a[k] = left[i];
            k++;
            i++;
        }

        while (j < upperBound-mid) {
            a[k] = right[j];
            k++;
            j++;
        }
    }

    public void printArray(int[] a) {
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {

        int[] a = {15, 5, 24, 8, 1, 3, 16, 10, 20};
        MergeSort mSort = new MergeSort();
        mSort.mergeSort(a, 0, a.length-1);
        mSort.printArray(a);
    }
}
