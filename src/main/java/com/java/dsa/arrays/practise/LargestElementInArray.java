package com.java.dsa.arrays.practise;

/*
Problem statement - Given an array A[] of size n. The task is to find the largest element in it.
Link - https://practice.geeksforgeeks.org/problems/largest-element-in-array4009/1/?category[]=Arrays&category[]=Arrays&page=1&query=category[]Arrayspage1category[]Arrays
 */
public class LargestElementInArray {

    public int largest(int arr[], int n) {

        int max = 0;

        for (int i = 0; i < 1; i++) {
            max = arr[0];
            for (int j = i+1; j < n; j++) {
                if (max < arr[j]) {
                    max = arr[j];
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {

        int[] arr = {2, 5, 3, 1, 7, 9, 4};

        LargestElementInArray p = new LargestElementInArray();
        System.out.println(p.largest(arr, arr.length));
    }
}
