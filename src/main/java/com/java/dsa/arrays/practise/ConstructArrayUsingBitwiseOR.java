package com.java.dsa.arrays.practise;

import java.util.Arrays;

/*
Problem statement - You are given an array arr[], you have to re-construct an array arr[].
The values in arr[] are obtained by doing OR(bitwise or) of consecutive elements in the array.

Link - https://practice.geeksforgeeks.org/problems/play-with-or5515/1/?category[]=Arrays&category[]=Arrays&difficulty[]=-2&difficulty[]=-1&difficulty[]=0&page=1&query=category[]Arraysdifficulty[]-2difficulty[]-1difficulty[]0page1category[]Arrays
* */
public class ConstructArrayUsingBitwiseOR {

    public static int[] game_with_number(int arr[], int n) {

        for (int i = 0; i < n; i++) {
            if (i+1 > n-1) {
                break;
            }
            arr[i] = arr[i] | arr[i+1];
        }

        return arr;
    }

    public static void main(String[] args) {

        int[] arr = {10, 11, 1, 2, 3};

        System.out.println(Arrays.toString(ConstructArrayUsingBitwiseOR.game_with_number(arr, arr.length)));
    }
}
