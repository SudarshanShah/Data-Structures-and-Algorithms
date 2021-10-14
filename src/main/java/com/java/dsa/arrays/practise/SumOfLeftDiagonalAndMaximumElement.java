package com.java.dsa.arrays.practise;

import java.util.ArrayList;
import java.util.Arrays;

/*
* Problem statement - Given a integer n. We have n*n values of a 2-d array, and  n values of 1-d array.
* Task is to find the sum of the left diagonal values of the 2-d array and the max element of the 1-d
* array and print them with space in between.
*
* Link - https://practice.geeksforgeeks.org/problems/java-1-d-and-2-d-array2952/1/?category[]=Arrays&category[]=Arrays&difficulty[]=-2&difficulty[]=-1&difficulty[]=0&page=1&query=category[]Arraysdifficulty[]-2difficulty[]-1difficulty[]0page1category[]Arrays
* */
public class SumOfLeftDiagonalAndMaximumElement {

    public static ArrayList<Integer> array(int a[][], int b[], int n) {

        ArrayList<Integer> list = new ArrayList<>();

        int sum  = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    sum += a[i][j];
                }
            }
        }

        Arrays.sort(b);
        int max = b[b.length-1];
        list.add(sum);
        list.add(max);

        return list;
    }

    public static void main(String[] args) {

        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] b = {3, 6, 9};

        ArrayList<Integer> ar = SumOfLeftDiagonalAndMaximumElement.array(arr, b, 3);

        System.out.println(ar.get(0) + " " + ar.get(1));
    }
}
