package com.java.dsa.arrays.practise;

/*
*Problem Statement - You are given an array arr[], you have to re-construct an array arr[].
The values in arr[] are obtained by doing Xor of consecutive elements in the array.
* Link - https://practice.geeksforgeeks.org/problems/game-with-nos3123/1/?category[]=Arrays&category[]=Arrays&difficulty[]=-2&difficulty[]=-1&difficulty[]=0&page=1&query=category[]Arraysdifficulty[]-2difficulty[]-1difficulty[]0page1category[]Arrays
*/
public class ConstructArrayUsingXOR {

    public static int[] game_with_number(int[] arr, int n) {

        for (int i = 0; i < n; i++) {
            if (i+1 > n-1) {
                break;
            }
            arr[i] = arr[i] ^ arr[i+1];
        }

        return arr;
    }

    public static void main(String[] args) {

        int[] arr = {10, 11, 1, 2, 3};

        arr = ConstructArrayUsingXOR.game_with_number(arr, arr.length);

        for (Integer i : arr) {
            System.out.print(i + " ");
        }
    }
}
